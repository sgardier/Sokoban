package be.uliege.boigelot.oop.sokoban.main.cell;

import be.uliege.boigelot.oop.sokoban.main.entity.Entity;

public class Arrow extends Cell {
	private static CellType imgUp = CellType.ARROW_UP;
	private static CellType imgDown = CellType.ARROW_DOWN;
	private static CellType imgRight = CellType.ARROW_RIGHT;
	private static CellType imgLeft = CellType.ARROW_LEFT;
	private String direction;

	public Arrow(Entity content, String direction) {
		super(((direction.equals("up")) ? imgUp
				: (direction.equals("down")) ? imgDown : (direction.equals("left")) ? imgLeft : imgRight), content);
		this.direction = direction;
	}

	public boolean moveAllowed(int dx, int dy) {
		switch (direction) {
		case ("up"):
			if (dx == 0 && dy == -1)
				return true;
			break;
		case ("down"):
			if (dx == 0 && dy == 1)
				return true;
			break;
		case ("right"):
			if (dx == 1 && dy == 0)
				return true;
			break;
		case ("left"):
			if (dx == -1 && dy == 0)
				return true;
			break;
		}
		return false;
	}
}
