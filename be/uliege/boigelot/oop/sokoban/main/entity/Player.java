package be.uliege.boigelot.oop.sokoban.main.entity;

import java.util.Vector;

import be.uliege.boigelot.oop.sokoban.main.cell.Arrow;
import be.uliege.boigelot.oop.sokoban.main.cell.Cell;
import be.uliege.boigelot.oop.sokoban.main.cell.CellType;
import be.uliege.boigelot.oop.sokoban.main.cell.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.cell.Wall;
import be.uliege.boigelot.oop.sokoban.main.level.Level;
import be.uliege.boigelot.oop.sokoban.main.shop.Item;

public class Player extends Entity {
	private static final CellType image = CellType.CYNTHIA;
	private Vector<Item> inventory = new Vector<Item>();
	private Item equipedItem = new Item(CellType.CYNTHIA, CellType.CYNTHIA_SHOP, 0);
	private int balance;

	public Player(Level level) {
		super(image, false, new Coordinate(0, 0), level);
	}
	
	@Override
	public boolean move(int dx, int dy) {
		Coordinate coords = super.getPosition();
		Level level = super.getLevel();
		Cell nextCell = level.cellAt(coords.x + dx, coords.y + dy);
		Cell currCell = level.cellAt(coords.x, coords.y);

		if (nextCell instanceof Wall) {
			return false;
		}
		if (currCell instanceof Arrow) {
			if (!((Arrow) currCell).moveAllowed(dx, dy))
				return false;
		}

		if (nextCell instanceof Arrow) {
			if (!((Arrow) nextCell).moveAllowed(dx, dy)) {
				nextCell.setContent(this);
				currCell.removeContent();
				setPosition(coords.x + dx, coords.y + dy);
			}
		}

		if (nextCell.isEmpty()) {
			nextCell.setContent(this);
			currCell.removeContent();
			setPosition(coords.x + dx, coords.y + dy);
			return true;
		}

		if (nextCell.isContentMovable()) {
			Entity content = nextCell.getContent();
			if (content.move(dx, dy)) {
				nextCell.setContent(this);
				currCell.removeContent();
				setPosition(coords.x + dx, coords.y + dy);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void goToLevel(Level level) {
		super.setLevel(level);
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int toAdd) {
		this.balance += toAdd;
	}
	
	public void equip(Item item) {
		super.setImage(item.getInGameImg());
		this.equipedItem = item;
	}
	
	public boolean haveBought(Item item) {
		return inventory.contains(item);
	}

	public void buy(Item selected) {
		this.inventory.add(selected);
		this.balance -= selected.getPrice();
	}
	
	public Item getEquipedItem() {
		return this.equipedItem;
	}
}
