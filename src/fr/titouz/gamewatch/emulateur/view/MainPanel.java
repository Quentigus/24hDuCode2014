package fr.titouz.gamewatch.emulateur.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private static MainPanel instance;

	private MainPanel() {
		
	}

	public static synchronized MainPanel getInstance() {
		if (null == instance) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	public MainPanel init() {
		this.setBackground(new Color(227, 227, 227));
		this.setMinimumSize(new Dimension(1000,500));
		return this;
	}
}
