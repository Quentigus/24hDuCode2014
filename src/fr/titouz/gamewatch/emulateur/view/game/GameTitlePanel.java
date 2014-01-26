package fr.titouz.gamewatch.emulateur.view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Date;

import javax.swing.JPanel;

import fr.titouz.gamewatch.tools.ImagesHelper;

public class GameTitlePanel extends JPanel{

	private static GameTitlePanel instance;
	private final String url_home = "ressources/screen_home.png";
	private final String url_over = "ressources/game_over.png";
	private String url_current;
	private Image img;

	private GameTitlePanel() {
	}

	public static synchronized GameTitlePanel getInstance() {
		if (null == instance) {
			instance = new GameTitlePanel();
		}
		return instance;
	}
	
	public GameTitlePanel init() {
		this.setMinimumSize(new Dimension(600,350));
		this.setPreferredSize(new Dimension(600,350));
		this.setMaximumSize(new Dimension(600,350));
		return this;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			if(!this.url_current.equalsIgnoreCase("")) {
				this.img = ImagesHelper.getImage(this.url_current);
			}
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GameTitlePanel setGameOver(){
		this.url_current = this.url_over;
		this.repaint();this.validate();
		return this;
	}
	
	public GameTitlePanel setHome(){
		this.url_current = this.url_home;
		this.repaint();this.validate();
		return this;
	}
}
