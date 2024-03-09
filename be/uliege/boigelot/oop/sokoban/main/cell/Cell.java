package be.uliege.boigelot.oop.sokoban.main.cell;

import be.uliege.boigelot.oop.sokoban.main.entity.Entity;

public class Cell {
	private CellType background;
	private Entity content;

	public Cell(CellType background, Entity content) {
		this.background = background;
		this.content = content;
	}

	public Entity getContent() {
		return content;
	}

	public void setContent(Entity content) {
		this.content = content;
	}
	
	public void removeContent() {
		this.content = null;
	}

	public CellType render() {
		if(content == null)
			return background;
		else
			return content.getImage();
	}
	
	public boolean isEmpty() {
		return this.content == null;
	}
	
	public boolean isContentMovable() {
		return !isEmpty() && content.isMovable();
	}
}
