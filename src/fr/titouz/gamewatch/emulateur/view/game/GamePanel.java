package fr.titouz.gamewatch.emulateur.view.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static GamePanel instance;

	private GamePanel() {
	}

	public static synchronized GamePanel getInstance() {
		if (null == instance) {
			instance = new GamePanel();
		}
		return instance;
	}
	
	public GamePanel init() {
		this.setMinimumSize(new Dimension(600,350));
		this.setBackground(Color.black);
		
		
		return this;
	}
}
