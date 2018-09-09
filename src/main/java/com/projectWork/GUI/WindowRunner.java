package com.projectWork.GUI;

import java.io.IOException;

import javax.swing.JFrame;

public class WindowRunner {

	public static WindowRunner game;
	public Screen screen;
	public JFrame frame;

	public static String title = "Catch Me If You Can";
	public static int width = 800;
	public static int height = 700;
	public static int buttonWidth = 200;
	public static int butttonHeight = 50;

	public WindowRunner(ColorOfTheme color) throws IOException {

		frame = new JFrame();
		frame.setTitle(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		screen = new Screen(color);
		frame.add(screen);

		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException {

		ColorOfTheme color = ColorOfTheme.DARK_GRAY;

		game = new WindowRunner(color);

	}

}
