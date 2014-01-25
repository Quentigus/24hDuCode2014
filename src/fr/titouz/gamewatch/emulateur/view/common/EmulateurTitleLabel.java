package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class EmulateurTitleLabel extends JLabel{

	private static EmulateurTitleLabel instance;
	private final String title = "Titz & Watch";

	private EmulateurTitleLabel() {
	}

	public static synchronized EmulateurTitleLabel getInstance() {
		if (null == instance) {
			instance = new EmulateurTitleLabel();
		}
		return instance;
	}
	
	public EmulateurTitleLabel init() {
		this.setPreferredSize(new Dimension(150,100));
		this.setOpaque(false);
		this.setText(this.title);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		return this;
	}
	
}
