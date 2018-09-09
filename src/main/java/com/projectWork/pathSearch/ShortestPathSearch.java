package com.projectWork.pathSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.projectWork.model.Maze;
import com.projectWork.model.Point;

public class ShortestPathSearch {

	private static final boolean VISITED = true;

	private Maze mazePlan;
	private Point cat;
	private Point mouse;
	private boolean[][] visitedMaze;
	private Map<Point, Point> parents;

	public ShortestPathSearch(Maze mazePlan, Point cat, Point mouse) {
		this.mazePlan = mazePlan;
		this.cat = cat;
		this.mouse = mouse;
		this.visitedMaze = new boolean[mazePlan.getWidth()][mazePlan.getHeight()];
		this.parents = new HashMap<>();
		this.parents.put(cat, null);
	}

	public List<Point> findShortestPath() {

		List<Point> path = new ArrayList<>();
		if (findShortestPath(mazePlan, cat, mouse, path)) {
			Collections.reverse(path);
			return path;
		}
		return null;

	}

	private boolean findShortestPath(Maze mazePlan, Point cat, Point mouse, List<Point> path) {

		Queue<Point> galimiKeliai = new LinkedList<>();
		visitedMaze[cat.getX()][cat.getY()] = VISITED;
		galimiKeliai.add(new Point(cat.getX(), cat.getY()));

		while (!galimiKeliai.isEmpty()) {

			Point dabartinisPoint = galimiKeliai.remove();

			if (dabartinisPoint.getX() == mouse.getX() && dabartinisPoint.getY() == mouse.getY()) {

				while (dabartinisPoint != null) {
					path.add(dabartinisPoint);
					dabartinisPoint = parents.get(dabartinisPoint);
				}
				return true;
			}

			for (Point kaimynas : getKaimynuSarasas(dabartinisPoint)) {
				if (mazePlan.pointIsValid(kaimynas) && !visitedMaze[kaimynas.getX()][kaimynas.getY()]) {
					visitedMaze[kaimynas.getX()][kaimynas.getY()] = VISITED;
					galimiKeliai.add(kaimynas);
					parents.put(kaimynas, dabartinisPoint);
				}
			}

		}

		return false;
	}

	private List<Point> getKaimynuSarasas(Point dabartinisPoint) {

		Point up = new Point(dabartinisPoint.getX(), dabartinisPoint.getY() - 1);
		Point down = new Point(dabartinisPoint.getX(), dabartinisPoint.getY() + 1);
		Point toLeft = new Point(dabartinisPoint.getX() - 1, dabartinisPoint.getY());
		Point toRight = new Point(dabartinisPoint.getX() + 1, dabartinisPoint.getY());

		List<Point> kaimynuSarasas = new ArrayList<>(4);

		if (mazePlan.pointIsFree(up)) {
			kaimynuSarasas.add(up);
		}

		if (mazePlan.pointIsFree(down)) {
			kaimynuSarasas.add(down);
		}

		if (mazePlan.pointIsFree(toLeft)) {
			kaimynuSarasas.add(toLeft);
		}

		if (mazePlan.pointIsFree(toRight)) {
			kaimynuSarasas.add(toRight);
		}

		return kaimynuSarasas;
	}

}
