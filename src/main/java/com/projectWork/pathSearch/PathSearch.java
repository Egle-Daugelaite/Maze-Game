package com.projectWork.pathSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.projectWork.model.Maze;
import com.projectWork.model.Point;

public class PathSearch {

	private static final boolean VISITED = true;

	private Maze mazePlan;
	private Point cat;
	private Point mouse;
	private boolean[][] visitedMaze;

	public PathSearch(Maze mazePlan, Point cat, Point mouse) {
		this.mazePlan = mazePlan;
		this.cat = cat;
		this.mouse = mouse;
		this.visitedMaze = new boolean[mazePlan.getHeight()][mazePlan.getWidth()];
	}

	public List<Point> findPath() {

		List<Point> path = new ArrayList<>();
		if (findPath(mazePlan, cat, mouse, path)) {
			Collections.reverse(path);
			return path;
		}
		return null;

	}

	public boolean findPath(Maze mazePlan, Point cat, Point mouse, List<Point> path) {

		if (cat.getX() == mouse.getX() && cat.getY() == mouse.getY()) {
			path.add(cat);
			return true;

		}

		if (mazePlan.pointIsFree(cat) && !visitedMaze[cat.getX()][cat.getY()]) {
			visitedMaze[cat.getX()][cat.getY()] = VISITED;

			Point toRight = new Point(cat.getX(), cat.getY() + 1);
			if (findPath(mazePlan, toRight, mouse, path)) {
				path.add(toRight);
				return true;
			}

			Point down = new Point(cat.getX() + 1, cat.getY());
			if (findPath(mazePlan, down, mouse, path)) {
				path.add(down);
				return true;
			}

			Point up = new Point(cat.getX() - 1, cat.getY());
			if (findPath(mazePlan, up, mouse, path)) {
				path.add(up);
				return true;
			}

			Point toLeft = new Point(cat.getX(), cat.getY() - 1);
			if (findPath(mazePlan, toLeft, mouse, path)) {
				path.add(toLeft);
				return true;
			}

		}

		return false;
	}

}
