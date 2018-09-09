package com.projectWork.GUI;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.projectWork.model.Point;

public class MouseMovement {

	private int mouseX;
	private int mouseY;
	private Point mouse;

	private Image mousePic;

	public MouseMovement(Point mouse) {

		ImageIcon img = new ImageIcon(MouseMovement.class.getClassLoader().getResource("mouse.png"));
		setMousePic(img.getImage());

		this.mouseX = mouse.getX();
		this.mouseY = mouse.getY();

	}

	public void moveLeft() {

		this.setMouseX(getMouseX() - 1);
		this.setMouseY(getMouseY());

	}

	public void moveRight() {

		this.setMouseX(getMouseX() + 1);
		this.setMouseY(getMouseY());

	}

	public void moveUp() {

		this.setMouseX(getMouseX());
		this.setMouseY(getMouseY() - 1);

	}

	public void moveDown() {

		this.setMouseX(getMouseX());
		this.setMouseY(getMouseY() + 1);

	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public Image getMousePic() {
		return mousePic;
	}

	public void setMousePic(Image mousePic) {
		this.mousePic = mousePic;
	}

	public Point getMouse() {
		return mouse;
	}

	public void setMouse(Point mouse) {
		this.mouse = mouse;
	}

}
