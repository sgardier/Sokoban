package be.uliege.boigelot.oop.sokoban.main.entity;

import be.uliege.boigelot.oop.sokoban.main.cell.CellType;
import be.uliege.boigelot.oop.sokoban.main.cell.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.level.Level;

public abstract class Entity {
	private CellType image;
	private boolean movable;
	private Coordinate coord;
	private Level level;

	public Entity(CellType image, boolean movable, Coordinate coord, Level level) {
		this.image = image;
		this.movable = movable;
		this.coord = coord;
		this.level = level;
	}

	public CellType getImage() {
		return image;
	}

	public void setImage(CellType image) {
		this.image = image;
	}
	

	public boolean isMovable() {
		return movable;
	}

	public void setMovable(boolean movable) {
		this.movable = movable;
	}

	public Coordinate getPosition() {
		return coord;
	}

	public void setPosition(int x, int y) {
		this.coord.x = x;
		this.coord.y = y;
	}
	
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		 this.level = level;
	}
	
	public abstract boolean move(int dx, int dy);
}
