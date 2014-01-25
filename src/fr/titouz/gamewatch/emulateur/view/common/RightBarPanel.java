package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.titouz.gamewatch.tools.ImagesHelper;

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
		try {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(110,500));
			this.setLayout(new BorderLayout());
			this.add(EmulateurTitleLabel.getInstance().init(),BorderLayout.NORTH);

			this.add(new ImagePanel("ressources/right-arrow.png"), BorderLayout.SOUTH);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this;
	}

}
