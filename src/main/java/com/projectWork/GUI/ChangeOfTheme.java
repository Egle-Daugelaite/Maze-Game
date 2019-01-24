package com.projectWork.GUI;

import java.awt.Color;
import java.awt.Font;

public class ChangeOfTheme {

	private ColorOfTheme color;

	private Font fontE;

	private Color wallE;

	private Color openE;

	private Color backgroundE;

	public ChangeOfTheme(ColorOfTheme color) {
		this.color = color;

	}

	public Color changeBackground() {
		switch (color) {
		case GREEN:
			return backgroundE = new Color(19, 209, 31);
		case DARK_GRAY:
			return backgroundE = Color.DARK_GRAY;
		case RED:
			return backgroundE = Color.RED;
		default:
			break;
		}

		return null;

	}

	public Color changeWall() {
		switch (color) {
		case GREEN:
			return wallE = Color.DARK_GRAY;
		case DARK_GRAY:
			return wallE = Color.GRAY;
		case RED:
			return wallE = Color.LIGHT_GRAY;
		default:
			break;
		}

		return null;

	}

	public Color changeOpen() {
		switch (color) {
		case GREEN:
			return openE = Color.GREEN;
		case DARK_GRAY:
			return openE = Color.LIGHT_GRAY;
		case RED:
			return openE = Color.RED;
		default:
			break;
		}

		return null;

	}

	public ColorOfTheme getColor() {
		return color;
	}

	public void setColor(ColorOfTheme color) {
		this.color = color;
	}

	public Font getFontE() {
		return fontE;
	}

	public void setFontE(Font fontE) {
		this.fontE = fontE;
	}

	public Color getWallE() {
		return wallE;
	}

	public void setWallE(Color wallE) {
		this.wallE = wallE;
	}

	public Color getOpenE() {
		return openE;
	}

	public void setOpenE(Color openE) {
		this.openE = openE;
	}

	public Color getBackgroundE() {
		return backgroundE;
	}

	public void setBackgroundE(Color backgroundE) {
		this.backgroundE = backgroundE;
	}

}
