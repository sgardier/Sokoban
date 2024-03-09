package be.uliege.boigelot.oop.sokoban.main.windowContent;

import be.uliege.boigelot.oop.sokoban.gui.SokobanError;
import be.uliege.boigelot.oop.sokoban.main.ui.UI;

public interface WindowContent {
	public void draw(UI ui) throws SokobanError;
	
	public void update(int event);
}
