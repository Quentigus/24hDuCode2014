package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import fr.titouz.gamewatch.emulateur.view.control.ControlPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;

public class CenterPanel extends JPanel{

	private static CenterPanel instance;

	private CenterPanel() {
	}

	public static synchronized CenterPanel getInstance() {
		if (null == instance) {
			instance = new CenterPanel();
		}
		return instance;
	}
	
	public CenterPanel init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.add(GamePanel.getInstance().init(), BorderLayout.NORTH);
		this.add(ControlPanel.getInstance().init(), BorderLayout.SOUTH);
		
		return this;
	}
}
