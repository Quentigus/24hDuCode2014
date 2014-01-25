package fr.titouz.gamewatch.emulateur.view;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import fr.titouz.gamewatch.emulateur.controller.ControlController;

public class MainFrame extends JFrame{

	private static MainFrame instance;

	private MainFrame() {
	}

	public static synchronized MainFrame getInstance() {
		if (null == instance) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame init() {
		this.setMinimumSize(new Dimension(820, 520));
		this.setContentPane(MainPanel.getInstance().init());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
		//event
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					ControlController.getInstance().rightControl();
					break;
				case KeyEvent.VK_UP:
					ControlController.getInstance().upControl();
					break;
				case KeyEvent.VK_LEFT:
					ControlController.getInstance().leftControl();
					break;
				case KeyEvent.VK_DOWN:
					ControlController.getInstance().downControl();
					break;

				default:
					break;
				}
			}
		});
		
		return this;
	}
}
