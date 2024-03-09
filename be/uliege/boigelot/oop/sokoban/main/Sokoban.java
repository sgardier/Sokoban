package be.uliege.boigelot.oop.sokoban.main;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.gui.SokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.entity.Player;
import be.uliege.boigelot.oop.sokoban.main.shop.Shop;
import be.uliege.boigelot.oop.sokoban.main.ui.UI;
import be.uliege.boigelot.oop.sokoban.main.windowContent.GameBoard;

public class Sokoban {
	private UI ui;
	private GameBoard gameBoard;
	private Shop shop;
	private boolean isRunning = true;
	private boolean inGame = true;
	private Player player;

	public Sokoban() throws SokobanError {
		this.player = new Player(null);
		gameBoard = new GameBoard(this.player);
		shop = new Shop(this.player);
		ui = new UI();
		show();
	}

	private void show() throws SokobanError {
		if(inGame) {
			gameBoard.draw(ui);
		}
		else {
			shop.draw(ui);
		}
		ui.show();
	}
	
	
	private void inGameUpdate(int event) {
		gameBoard.update(event);
		if(gameBoard.endGame()) {
			isRunning = false;
		}
		else if(gameBoard.levelEnd()) {
			inGame = false;
			this.shop.beginShopping();
		}
	}
	
	private void inShopUpdate(int event) throws SokobanError {
		shop.update(event);
		if(shop.shoppingEnded()) {
			inGame = true;
			gameBoard.nextLevel();
			ui.clear();
		}
	}

	private void update() throws SokobanError {
		int event = ui.getEvent();
		if (event == SokobanGUI.QUIT){
			isRunning = false;
		}
		else if(inGame) {
			inGameUpdate(event);
			show();
		}
		else {
			inShopUpdate(event);
		}
	}

	public void run() throws SokobanError {
		isRunning = true;
		while (isRunning) {
			show();
			update();
		}
	}

	public static void main(String[] args) throws SokobanError {
		Sokoban game = new Sokoban();
		game.run();
	}
}
