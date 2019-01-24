package com.projectWork.model;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class MazeTest {

	private Maze mazePlan;
	private Point firstPoint;
	private Point secondPoint;
	private Point thirdPoint;

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

		firstPoint = new Point(1, 1);
		secondPoint = new Point(7, 8);
		thirdPoint = new Point(8, 11);

	}

	@Test
	public void isPointIsTransible() {
		boolean firstPointisTransible = mazePlan.pointIsTransible(firstPoint);
		boolean secondPointisTransible = mazePlan.pointIsTransible(secondPoint);
		boolean thirdPointisTransible = mazePlan.pointIsTransible(thirdPoint);
		assertFalse(!firstPointisTransible);
		assertFalse(secondPointisTransible);
		assertFalse(!thirdPointisTransible);
	}

}
