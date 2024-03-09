package be.uliege.boigelot.oop.sokoban.main.cell;

import be.uliege.boigelot.oop.sokoban.main.entity.Entity;

public class Target extends Cell{
	private static CellType img = CellType.TARGET;
	public Target(Entity content) {
		super(img, content);
	}
}
