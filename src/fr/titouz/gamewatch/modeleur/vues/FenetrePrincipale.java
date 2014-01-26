package fr.titouz.gamewatch.modeleur.vues;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.ChargerFond;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.sprites.PositionnementSprite;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	public FenetrePrincipale() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		JTabbedPane tab = new JTabbedPane();
		
		tab.addTab("1", new DecoupeurSprites());
		tab.addTab("2.1", new ChargerFond());
		try {
			tab.addTab("2.2", new DecoupeurFond(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\MrGameWatch-11.png"))));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tab.addTab("3", new PositionnementSprite());
		tab.addTab("4", new PositionnementSprite());
		tab.addTab("5", new PositionnementSprite());
		tab.addTab("6", null);
		tab.addTab("7", null);
		
		this.setContentPane(tab);
		this.revalidate();
	}
}
