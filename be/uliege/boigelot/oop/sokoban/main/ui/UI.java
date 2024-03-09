package be.uliege.boigelot.oop.sokoban.main.ui;

import java.util.Hashtable;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.gui.SokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.cell.CellType;

public class UI extends SokobanGUI {
	private Hashtable<CellType, Integer> tilesImage = new Hashtable<CellType, Integer>();
	private Hashtable<String, Integer> lettersImage = new Hashtable<String, Integer>();
	private Hashtable<Integer, Integer> numbersImage = new Hashtable<Integer, Integer>();
	private final static int WIDTH = 15, HEIGHT = 15;

	public UI() throws SokobanError {
		super(WIDTH, HEIGHT);
		loadImages();
	}

	private void loadImages() throws SokobanError {
		//level tiles
		tilesImage.put(CellType.WALL, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/wall.png"));
		tilesImage.put(CellType.EMPTY, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/empty.png"));
		tilesImage.put(CellType.CRATE, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/crate.png"));
		tilesImage.put(CellType.CRATE2, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/crate2.png"));
		tilesImage.put(CellType.TARGET, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/target.png"));
		tilesImage.put(CellType.PLAYER, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/player.png"));
		tilesImage.put(CellType.ARROW_DOWN, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/arrowdown.png"));
		tilesImage.put(CellType.ARROW_UP, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/arrowup.png"));
		tilesImage.put(CellType.ARROW_LEFT, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/arrowleft.png"));
		tilesImage.put(CellType.ARROW_RIGHT, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/arrowright.png"));

		//player img
		tilesImage.put(CellType.CYNTHIA, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/cynthia.png"));
		tilesImage.put(CellType.CYNTHIA_SHOP, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/cynthia_shop.png"));
		tilesImage.put(CellType.MARIO, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/mario.png"));
		tilesImage.put(CellType.MARIO_SHOP, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/mario_shop.png"));
		tilesImage.put(CellType.CINNAMOROLL, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/cinnamoroll.png"));
		tilesImage.put(CellType.CINNAMOROLL_SHOP, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/cinnamoroll_shop.png"));
		tilesImage.put(CellType.FRISK, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/frisk.png"));
		tilesImage.put(CellType.FRISK_SHOP, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/frisk_shop.png"));

		//shop
		tilesImage.put(CellType.CLEAR, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/clear.png"));
		tilesImage.put(CellType.ARROW, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/arrow.png"));
		tilesImage.put(CellType.GOLD, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/gold.png"));

		//lettres
		lettersImage.put("S", this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/letters/S.png"));
		lettersImage.put("h", this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/letters/h.png"));
		lettersImage.put("o", this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/letters/o.png"));
		lettersImage.put("p", this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/letters/p.png"));

		//nombres
		numbersImage.put(0, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/0.png"));
		numbersImage.put(1, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/1.png"));
		numbersImage.put(2, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/2.png"));
		numbersImage.put(3, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/3.png"));
		numbersImage.put(4, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/4.png"));
		numbersImage.put(5, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/5.png"));
		numbersImage.put(6, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/6.png"));
		numbersImage.put(7, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/7.png"));
		numbersImage.put(8, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/8.png"));
		numbersImage.put(9, this.loadImage("be/uliege/boigelot/oop/sokoban/main/images/numbers/9.png"));
	}

	public void clear() throws SokobanError {
		for(int i = 0; i < WIDTH; i++) {
			for(int j = 0; j < HEIGHT; j++) {
				super.setCell(j, i, tilesImage.get(CellType.CLEAR));
			}
		}
	}

	public void setCell(int x, int y, CellType type) throws SokobanError {
		super.setCell(x, y, tilesImage.get(type));
	}

	public void setCell(int x, int y, String letter) throws SokobanError {
		super.setCell(x, y, lettersImage.get(letter));
	}

	public void setCell(int x, int y, int digit) throws SokobanError {
		super.setCell(x, y, numbersImage.get(digit));
	}

	public int getEvent() throws SokobanError {
		return super.getEvent();
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}
}
