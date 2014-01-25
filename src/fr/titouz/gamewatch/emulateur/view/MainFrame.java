package fr.titouz.gamewatch.emulateur.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static MainFrame instance;

	private MainFrame() {
	}

	public static synchronized MainFrame getInstance() {
		if (null == instance) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame init() {
		this.setMinimumSize(new Dimension(820, 720));
		this.setContentPane(MainPanel.getInstance().init());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
		return this;
	}
}
