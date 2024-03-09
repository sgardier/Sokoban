package be.uliege.boigelot.oop.sokoban.main.shop;

import java.util.Vector;
import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.gui.SokobanGUI;
import be.uliege.boigelot.oop.sokoban.main.cell.CellType;
import be.uliege.boigelot.oop.sokoban.main.entity.Player;
import be.uliege.boigelot.oop.sokoban.main.ui.UI;
import be.uliege.boigelot.oop.sokoban.main.windowContent.WindowContent;

public class Shop implements WindowContent{
	private static final int Y_OFFSET_ITEMS = 5;
	private boolean shoppingEnded = false;
	private Vector<Item> items = new Vector<Item>();
	private int selectedItem = 0;
	private Player player;

	public Shop(Player player) {
		this.player = player;
		this.items.add(new Item(CellType.MARIO, CellType.MARIO_SHOP, 5));
		this.items.add(new Item(CellType.CINNAMOROLL, CellType.CINNAMOROLL_SHOP, 15));
		this.items.add(new Item(CellType.FRISK, CellType.FRISK_SHOP, 30));
	}
	
	@Override
	public void draw(UI ui) throws SokobanError{
		ui.clear();
		
		//title
		ui.setCell(0, 0, "S");
		ui.setCell(1, 0, "h");
		ui.setCell(2, 0, "o");
		ui.setCell(3, 0, "p");
		
		//balance
		ui.setCell(ui.getWidth()-5,0, player.getEquipedItem().getInShopImage());
		ui.setCell(ui.getWidth()-3,0, player.getBalance()/10);
		ui.setCell(ui.getWidth()-2,0, player.getBalance()%10);
		ui.setCell(ui.getWidth()-1,0, CellType.GOLD);
		
		//selection arrow
		ui.setCell(2, Y_OFFSET_ITEMS+selectedItem, CellType.ARROW);
		
		//items
		for(int i = 0; i < items.size(); i++){
			ui.setCell(3, Y_OFFSET_ITEMS+i, items.get(i).getInShopImage());
			ui.setCell(6, Y_OFFSET_ITEMS+i, items.get(i).getPrice()/10);
			ui.setCell(7, Y_OFFSET_ITEMS+i, items.get(i).getPrice()%10);
			ui.setCell(8, Y_OFFSET_ITEMS+i, CellType.GOLD);
		}
	}

	@Override
	public void update(int event) {
		if(event == SokobanGUI.LEFT) {
			this.selectedItem = 0;
			this.shoppingEnded = true;
		}
		
		if(event == SokobanGUI.DOWN) {
			this.selectedItem = (this.selectedItem + 1) % items.size();
		}
		
		if(event == SokobanGUI.UP) {
			if(this.selectedItem == 0) {
				this.selectedItem = items.size()-1;
			}
			else {
				this.selectedItem--;
			}
		}
		
		if(event == SokobanGUI.RIGHT) {
			Item selected = this.items.get(selectedItem);
			if(player.haveBought(selected)) {
				player.equip(selected);
			}
			else {
				if(player.getBalance() >= selected.getPrice()) {
					player.buy(selected);
					player.equip(selected);
				}
			}
		}
	}
	
	public boolean shoppingEnded() {
		return this.shoppingEnded;
	}

	public boolean beginShopping() {
		return this.shoppingEnded = false;
	}
}
