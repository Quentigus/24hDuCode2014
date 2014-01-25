package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.titouz.gamewatch.tools.ImagesHelper;

public class ImagePanel extends JPanel{

	private String url;
	private Image img;
	
	public ImagePanel (String url) {
		this.url = url;
		this.setPreferredSize(new Dimension(100,100));
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
		try {
			JLabel button = new JLabel(ImagesHelper.getIcon("resources/right-arrow.png"));
			this.img = ImagesHelper.getImage(this.url);
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
