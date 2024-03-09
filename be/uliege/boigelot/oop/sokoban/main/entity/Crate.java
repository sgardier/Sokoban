package be.uliege.boigelot.oop.sokoban.main.entity;

import be.uliege.boigelot.oop.sokoban.main.cell.Cell;
import be.uliege.boigelot.oop.sokoban.main.cell.CellType;
import be.uliege.boigelot.oop.sokoban.main.cell.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.cell.Target;
import be.uliege.boigelot.oop.sokoban.main.level.Level;

public class Crate extends Entity {
	private static CellType movableCrate = CellType.CRATE;
	private static CellType fixedCrate = CellType.CRATE2;
	
	public Crate(boolean movable, Coordinate coord, Level level) {
		super(movable ? movableCrate : fixedCrate, movable, coord, level);
	}
	
	@Override
	public boolean move(int dx, int dy) {
		Coordinate coords = super.getPosition();
		Level level = super.getLevel();
		Cell nextCell = level.cellAt(coords.x + dx, coords.y + dy);
		Cell currCell = level.cellAt(coords.x, coords.y);
		
		if (nextCell.isEmpty()) {
			if(nextCell instanceof Target) {
				super.setImage(fixedCrate);
				super.setMovable(false);
			}
			nextCell.setContent(this);
			currCell.removeContent();
			setPosition(coords.x + dx, coords.y + dy);
			return true;
		}
		else {
			return false;
		}
	}
}
