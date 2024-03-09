package be.uliege.boigelot.oop.sokoban.main.windowContent;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.gui.SokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.entity.Player;
import be.uliege.boigelot.oop.sokoban.main.level.Level;
import be.uliege.boigelot.oop.sokoban.main.ui.UI;

public class GameBoard implements WindowContent{
	private Level currentLevel;
	private Player player;
	private boolean endGame;

	public GameBoard(Player player) {
		this.player = player;
		currentLevel = new Level(1, player);
		this.player.goToLevel(currentLevel);
	}
	
	@Override
	public void update(int event) {
		int dx = 0, dy = 0;
		switch (event) {
		case SokobanGUI.UP:
			dy = -1;
			break;
		case SokobanGUI.DOWN:
			dy = 1;
			break;
		case SokobanGUI.LEFT:
			dx = -1;
			break;
		case SokobanGUI.RIGHT:
			dx = 1;
			break;
		}
		currentLevel.move(player, dx, dy);
		if(currentLevel.isWon() && currentLevel.getLevelId() == Level.MAX_LEVEL) {
			this.endGame = true;
		}
	}
	
	public void nextLevel() {
		if(currentLevel.getLevelId() < Level.MAX_LEVEL) {
			this.currentLevel = new Level(this.currentLevel.getLevelId()+1, this.player);
			this.player.goToLevel(this.currentLevel);
		}
	}
	
	public void draw(UI ui) throws SokobanError {
		int offsetX = (ui.getWidth() - currentLevel.getWidth()) / 2;
		int offsetY = (ui.getHeight() - currentLevel.getHeight()) / 2;
		for (int i = 0; i < this.currentLevel.getHeight(); i++) {
			for (int j = 0; j < this.currentLevel.getWidth(); j++) {
				ui.setCell(j + offsetX, i + offsetY, this.currentLevel.cellAt(j, i).render());
			}
		}
	}

	public Level getCurrentLevel() {
		return this.currentLevel;
	}
	
	public boolean levelEnd() {
		return this.currentLevel.isWon();
	}
	
	public boolean endGame() {
		return this.endGame;
	}
}
