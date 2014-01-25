package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.view.control.ControlPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;

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
		this.setPreferredSize(new Dimension(600,500));
		this.add(GameTitlePanel.getInstance().init().setHome(), BorderLayout.NORTH);
		this.add(ControlPanel.getInstance().init(), BorderLayout.SOUTH);
		
		return this;
	}

	public void changerEcranToGame() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GameTitlePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GamePanel.getInstance().init(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
	
	public void changerEcranToGameOver() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GamePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GameTitlePanel.getInstance().init().setGameOver(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
	
	public void changerEcranToHome() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GamePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GameTitlePanel.getInstance().init().setHome(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
}
