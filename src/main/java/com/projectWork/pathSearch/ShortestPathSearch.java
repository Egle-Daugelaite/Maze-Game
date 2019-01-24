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

/**
 * Class for the shortest path search using Breadth first search algorithm.
 * 
 */
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

		Queue<Point> possiblePaths = new LinkedList<>();
		visitedMaze[cat.getX()][cat.getY()] = VISITED;
		possiblePaths.add(new Point(cat.getX(), cat.getY()));

		while (!possiblePaths.isEmpty()) {

			Point currentPoint = possiblePaths.remove();

			if (currentPoint.getX() == mouse.getX() && currentPoint.getY() == mouse.getY()) {

				while (currentPoint != null) {
					path.add(currentPoint);
					currentPoint = parents.get(currentPoint);
				}
				return true;
			}

			for (Point neighbor : getNeighborsList(currentPoint)) {
				if (mazePlan.pointIsValid(neighbor) && !visitedMaze[neighbor.getX()][neighbor.getY()]) {
					visitedMaze[neighbor.getX()][neighbor.getY()] = VISITED;
					possiblePaths.add(neighbor);
					parents.put(neighbor, currentPoint);
				}
			}

		}

		return false;
	}

	private List<Point> getNeighborsList(Point currentPoint) {

		Point up = new Point(currentPoint.getX(), currentPoint.getY() - 1);
		Point down = new Point(currentPoint.getX(), currentPoint.getY() + 1);
		Point toLeft = new Point(currentPoint.getX() - 1, currentPoint.getY());
		Point toRight = new Point(currentPoint.getX() + 1, currentPoint.getY());

		List<Point> neighborsList = new ArrayList<>(4);

		if (mazePlan.pointIsFree(up)) {
			neighborsList.add(up);
		}

		if (mazePlan.pointIsFree(down)) {
			neighborsList.add(down);
		}

		if (mazePlan.pointIsFree(toLeft)) {
			neighborsList.add(toLeft);
		}

		if (mazePlan.pointIsFree(toRight)) {
			neighborsList.add(toRight);
		}

		return neighborsList;
	}

}
