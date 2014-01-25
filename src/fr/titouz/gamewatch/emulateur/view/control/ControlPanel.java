package fr.titouz.gamewatch.emulateur.view.control;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

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
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.setMinimumSize(new Dimension(600,150));
		this.setPreferredSize(new Dimension(600,150));
		this.setMaximumSize(new Dimension(600,150));
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(ControlList.getInstance().init()), BorderLayout.CENTER);
		return this;
	}
}
