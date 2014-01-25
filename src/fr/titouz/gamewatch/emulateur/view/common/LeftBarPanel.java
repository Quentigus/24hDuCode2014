package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class LeftBarPanel extends JPanel{
	
	private static LeftBarPanel instance;

	private LeftBarPanel() {
	}

	public static synchronized LeftBarPanel getInstance() {
		if (null == instance) {
			instance = new LeftBarPanel();
		}
		return instance;
	}
	
	public LeftBarPanel init() {
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(100,700));
		this.setLayout(new BorderLayout());
		this.add(RedButtonPanel.getInstance().init(), BorderLayout.SOUTH);
		return this;
	}

}
