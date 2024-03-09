package be.uliege.boigelot.oop.sokoban.main.cell;

import be.uliege.boigelot.oop.sokoban.main.entity.Entity;

public class Empty extends Cell{
	private static CellType img = CellType.EMPTY;
	public Empty(Entity content) {
		super(img, content);
	}
}