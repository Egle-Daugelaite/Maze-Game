package com.projectWork.mazePlanLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.projectWork.model.Maze;

public class MazePlan {

	private Maze mazePlan;

	public void loadMazePlan() throws IOException {

		try {

			InputStream mazeTxt = MazePlan.class.getClassLoader().getResourceAsStream("maze1.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(mazeTxt));

			StringBuilder mazeTxtBl = new StringBuilder();
			String line = reader.readLine();

			while (line != null) {
				mazeTxtBl.append(line);
				mazeTxtBl.append(System.lineSeparator());
				line = reader.readLine();
			}

			String mazeStr = mazeTxtBl.toString();
			String mazeStrValid = mazeTxtBl.toString().trim().replaceAll("\n", "").replaceAll("\r", "");
			String[] mazeStrLines = mazeStr.split("\n");
			int numberOfRows = mazeStrLines.length;
			String mazeStrLine = mazeStrLines[0].trim();
			int numberOfColumns = mazeStrLine.length();

			char[][] maze = new char[numberOfColumns][numberOfRows];
			int counter = 0;
			for (int y = 0; y < numberOfRows; y++) {
				for (int x = 0; x < numberOfColumns; x++) {
					maze[x][y] = mazeStrValid.charAt(counter++);

				}

			}

			setMazePlan((new Maze(maze)));

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Unable to load a file");
		} catch (NullPointerException e) {
			System.out.println("File is empty");
		}

	}

	public Maze getMazePlan() {
		return mazePlan;
	}

	public void setMazePlan(Maze mazePlan) {
		this.mazePlan = mazePlan;
	}

}
