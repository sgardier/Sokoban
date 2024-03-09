package be.uliege.boigelot.oop.sokoban.main.shop;

import be.uliege.boigelot.oop.sokoban.main.cell.CellType;

public class Item {
	private CellType inGameImg;
	private CellType inShopImg;
	private int price;
	
	public Item(CellType inGameImg, CellType inShopImg, int price) {
		this.inGameImg = inGameImg;
		this.inShopImg = inShopImg;
		this.price = price;
	}
	
	public CellType getInShopImage() {
		return inShopImg;
	}
	
	public CellType getInGameImg() {
		return inGameImg;
	}
	
	public int getPrice() {
		return price;
	}
}
