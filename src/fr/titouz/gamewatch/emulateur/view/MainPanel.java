package fr.titouz.gamewatch.emulateur.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.common.LeftBarPanel;
import fr.titouz.gamewatch.emulateur.view.common.RightBarPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;

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
		this.setMinimumSize(new Dimension(800,700));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.setLayout(new BorderLayout(5, 5));
		this.add(RightBarPanel.getInstance().init(),BorderLayout.WEST);
		this.add(CenterPanel.getInstance().init(),BorderLayout.CENTER);
		this.add(LeftBarPanel.getInstance().init(), BorderLayout.EAST);
		
		return this;
	}
}
