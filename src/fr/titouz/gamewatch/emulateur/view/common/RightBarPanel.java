package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class RightBarPanel extends JPanel{
	
	private static RightBarPanel instance;

	private RightBarPanel() {
		
	}

	public static synchronized RightBarPanel getInstance() {
		if (null == instance) {
			instance = new RightBarPanel();
		}
		return instance;
	}
	
	public RightBarPanel init() {
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(100,700));
		this.setLayout(new BorderLayout());
		this.add(EmulateurTitleLabel.getInstance().init(),BorderLayout.NORTH);
		this.add(RedButtonPanel.getInstance().init(), BorderLayout.SOUTH);
		return this;
	}

}
