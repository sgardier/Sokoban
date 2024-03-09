package be.uliege.boigelot.oop.sokoban.main.cell;

import be.uliege.boigelot.oop.sokoban.main.entity.Entity;

public class Wall extends Cell{
	private static CellType img = CellType.WALL;
	public Wall(Entity content) {
		super(img, content);
	}
	@Override
	public boolean isEmpty() {
		return false;
	}
}

