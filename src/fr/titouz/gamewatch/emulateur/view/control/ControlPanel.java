package fr.titouz.gamewatch.emulateur.view.control;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{

	private static ControlPanel instance;

	private ControlPanel() {
	}

	public static synchronized ControlPanel getInstance() {
		if (null == instance) {
			instance = new ControlPanel();
		}
		return instance;
	}
	
	public ControlPanel init() {
		this.setOpaque(false);
		return this;
	}
}
