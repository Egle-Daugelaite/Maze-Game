package com.projectWork.GUI;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import com.projectWork.model.Maze;
import com.projectWork.model.Point;
import com.projectWork.pathSearch.ShortestPathSearch;

public class CatMovement {

	private int catX;
	private int catY;

	private Image catPic;

	public CatMovement(Point cat) {

		ImageIcon img = new ImageIcon(CatMovement.class.getClassLoader().getResource("cat.png"));
		this.setCatPic(img.getImage());

		this.setCatX(cat.getX());
		this.setCatY(cat.getY());
	}

	public Point start(Maze mazePlan, Point cat, Point mouse) {

		ShortestPathSearch shortestPath = new ShortestPathSearch(mazePlan, cat, mouse);
		List<Point> path = shortestPath.findShortestPath();

		Point movingPoint = null;
		if (path.size() >= 3) {
			movingPoint = path.get(2);
		} else if (path.size() == 2) {
			movingPoint = path.get(1);
		} else {
			movingPoint = path.get(0);
		}

		cat = movingPoint;

		this.setCatX(movingPoint.getX());
		this.setCatY(movingPoint.getY());

		return cat;

	}

	public int getCatX() {
		return catX;
	}

	public void setCatX(int catX) {
		this.catX = catX;
	}

	public int getCatY() {
		return catY;
	}

	public void setCatY(int catY) {
		this.catY = catY;
	}

	public Image getCatPic() {
		return catPic;
	}

	public void setCatPic(Image catPic) {
		this.catPic = catPic;
	}

}
