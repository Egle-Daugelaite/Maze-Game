package com.projectWork.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.projectWork.mazePlanLoader.MazePlan;
import com.projectWork.model.Maze;
import com.projectWork.model.Point;

public class Screen extends JPanel implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int CELLSIZE = 30;
	private static final char OPEN = ' ';
	private static final char WALL = 'X';

	private ColorOfTheme color;
	private ChangeOfTheme changeOfTheme;

	private Maze mazePlan;
	private MouseMovement mouseI;
	private CatMovement catI;
	private Point mouse;
	private Point cat;
	String messageOver = "";
	private boolean win = false;

	Timer tm = new Timer(5, this);

	Font font = new Font("Zapfino", Font.BOLD, 24);

	public Screen(ColorOfTheme color) throws IOException {

		setChangeOfTheme(new ChangeOfTheme(color));

		Color colorOfBackground = changeOfTheme.changeBackground();
		setBackground(colorOfBackground);

		MazePlan mazeLoader = new MazePlan();
		mazeLoader.loadMazePlan();
		mazePlan = mazeLoader.getMazePlan();

		mouse = new Point(10, 10);
		cat = new Point(1, 1);

		this.mouseI = new MouseMovement(mouse);
		this.catI = new CatMovement(cat);

		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.translate(25, 25);

		if (!win) {

			for (int i = 0; i < mazePlan.getWidth(); i++) {
				for (int j = 0; j < mazePlan.getHeight(); j++) {

					switch (mazePlan.getMaze()[i][j]) {
					case WALL:
						g.setColor(changeOfTheme.changeWall());
						break;
					case OPEN:
						g.setColor(changeOfTheme.changeOpen());
						break;
					default:
						g.setColor(changeOfTheme.changeBackground());
					}

					g.fillRect(30 * i, 30 * j, 30, 30);

				}
			}

			g.drawImage(mouseI.getMousePic(), mouseI.getMouseX() * CELLSIZE, mouseI.getMouseY() * CELLSIZE, null);
			g.drawImage(catI.getCatPic(), catI.getCatX() * CELLSIZE, catI.getCatY() * CELLSIZE, null);
		}

		if (win) {

			g.setColor(Color.WHITE);
			g.setFont(font);
			g.drawString(messageOver, 300, 200);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((cat.getX() == mouse.getX() && cat.getY() == mouse.getY())) {
			win = true;
			messageOver = "Game Over";

		}
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int choice = e.getKeyCode();

		if (choice == KeyEvent.VK_RIGHT) {
			Point toRight = new Point(mouse.getX() + 1, mouse.getY());
			if (mazePlan.pointIsTransible(toRight)) {
				mouseI.moveRight();
				mouse = toRight;
			}

		} else if (choice == KeyEvent.VK_LEFT) {
			Point toLeft = new Point(mouse.getX() - 1, mouse.getY());
			if (mazePlan.pointIsTransible(toLeft)) {
				mouseI.moveLeft();
				mouse = toLeft;
			}

		} else if (choice == KeyEvent.VK_UP) {
			Point up = new Point(mouse.getX(), mouse.getY() - 1);
			if (mazePlan.pointIsTransible(up)) {
				mouseI.moveUp();
				mouse = up;
			}

		} else if (choice == KeyEvent.VK_DOWN) {
			Point down = new Point(mouse.getX(), mouse.getY() + 1);
			if (mazePlan.pointIsTransible(down)) {
				mouseI.moveDown();
				mouse = down;
			}
		}

		cat = catI.start(mazePlan, cat, mouse);

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public ColorOfTheme getColor() {
		return color;
	}

	public void setColor(ColorOfTheme color) {
		this.color = color;
	}

	public ChangeOfTheme getChangeOfTheme() {
		return changeOfTheme;
	}

	public void setChangeOfTheme(ChangeOfTheme changeOfTheme) {
		this.changeOfTheme = changeOfTheme;
	}

}
