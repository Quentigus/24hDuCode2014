package fr.titouz.gamewatch.emulateur.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.common.LeftBarPanel;
import fr.titouz.gamewatch.emulateur.view.common.RightBarPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class MainPanel extends JPanel{

	private static MainPanel instance;
	private Image img;
	private String url_fond = "ressources/fond.png";

	private MainPanel() {
		
	}

	public static synchronized MainPanel getInstance() {
		if (null == instance) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	public MainPanel init() {
		this.setMinimumSize(new Dimension(800,500));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.setLayout(new BorderLayout(5, 5));
		this.add(RightBarPanel.getInstance().init(),BorderLayout.WEST);
		this.add(CenterPanel.getInstance().init(),BorderLayout.CENTER);
		this.add(LeftBarPanel.getInstance().init(), BorderLayout.EAST);
		
		return this;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			this.img = ImagesHelper.getImage(this.url_fond);
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
