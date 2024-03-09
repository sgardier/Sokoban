package be.uliege.boigelot.oop.sokoban.main.level;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import be.uliege.boigelot.oop.sokoban.main.cell.Arrow;
import be.uliege.boigelot.oop.sokoban.main.cell.Cell;
import be.uliege.boigelot.oop.sokoban.main.cell.Coordinate;
import be.uliege.boigelot.oop.sokoban.main.cell.Empty;
import be.uliege.boigelot.oop.sokoban.main.cell.Target;
import be.uliege.boigelot.oop.sokoban.main.cell.Wall;
import be.uliege.boigelot.oop.sokoban.main.entity.Crate;
import be.uliege.boigelot.oop.sokoban.main.entity.Entity;
import be.uliege.boigelot.oop.sokoban.main.entity.Player;

public class Level {
	private int width;
	private int height;
	private boolean isWon;
	private Cell levelBoard[][];
	private  Vector<Target> targetCells;
	private int levelId;
	private int reward;
	public final static int MAX_LEVEL = 4;
	private Player player;

	/*
	 * Load a level from a file
	 */
	public Level(int level, Player player) {
		File levelFile = new File("be/uliege/boigelot/oop/sokoban/main/level/" + level);
		Scanner reader = null;
		try {
			reader = new Scanner(levelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.width = Integer.valueOf(reader.next());
		this.height = Integer.valueOf(reader.next());
		this.reward = Integer.valueOf(reader.next());
		this.isWon = false;
		this.levelId = level;
		this.targetCells = new Vector<Target>();
		this.levelBoard = new Cell[height][];
		this.player = player;

		for (int i = 0; i < this.height; i++) {
			this.levelBoard[i] = new Cell[width];
			for (int j = 0; j < this.width; j++) {
				String var = reader.next();
				switch (var) {
				case "wall":
					this.levelBoard[i][j] = new Wall(null);
					break;
				case "crate":
					this.levelBoard[i][j] = new Empty(new Crate(true, new Coordinate(j, i), this));
					break;
				case "crate2":
					this.levelBoard[i][j] = new Target(new Crate(false, new Coordinate(j, i), this));
					break;
				case "empty":
					this.levelBoard[i][j] = new Empty(null);
					break;
				case "arrowleft":
					this.levelBoard[i][j] = new Arrow(null, "left");
					break;
				case "arrowright":
					this.levelBoard[i][j] = new Arrow(null, "right");
					break;
				case "arrowup":
					this.levelBoard[i][j] = new Arrow(null, "up");
					break;
				case "arrowdown":
					this.levelBoard[i][j] = new Arrow(null, "down");
					break;
				case "target":
					Target targetCell = new Target(null);
					this.levelBoard[i][j] = targetCell;
					this.targetCells.add(targetCell);
					break;
				case "player":
					this.levelBoard[i][j] = new Empty(player);
					player.setPosition(j, i);
					break;
				}
			}
		}
		reader.close();
	}

	public void move(Entity entity, int dx, int dy){
		entity.move(dx, dy);
		checkForVictory();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Cell cellAt(int x, int y) {
		return levelBoard[y][x];
	}

	private void checkForVictory() {
		for(int i = 0; i < this.targetCells.size(); i++) {
			Cell cell = this.targetCells.get(i);
			if(cell.isEmpty() || !(cell.getContent() instanceof Crate)){
				this.isWon = false;
				return;
			}
		}
		this.isWon = true;
		this.player.setBalance(reward);
	}

	public boolean isWon() {
		return this.isWon;
	}

	public int getLevelId() {
		return this.levelId ;
	}

	public int getReward() {
		return reward;
	}
}
