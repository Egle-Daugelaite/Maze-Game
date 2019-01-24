package com.projectWork.pathSearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.projectWork.model.Maze;
import com.projectWork.model.Point;

public class ShortestPathSearchTest {

	private ShortestPathSearch shortestPathSearch;
	private Maze mazePlan;
	private Point cat;
	private Point mouse;
	List<Point> path;

	@Before
	public void setUp() {

		char[][] maze = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, // O - open
				{ 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X' }, // x - wall
				{ 'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X' },
				{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		mazePlan = new Maze(maze);

		cat = new Point(1, 1);
		mouse = new Point(8, 4);

		shortestPathSearch = new ShortestPathSearch(mazePlan, cat, mouse);

	}

	@Test
	public void findShortestPath() {
		path = shortestPathSearch.findShortestPath();
		assertEquals(11, path.size());
		assertEquals(cat.getX(), path.get(0).getX());
		assertEquals(mouse.getX(), path.get(path.size() - 1).getX());
		assertNotSame(mouse.getX(), cat.getX());

	}


}
