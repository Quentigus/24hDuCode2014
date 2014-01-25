package fr.titouz.gamewatch.emulateur.controller;

import fr.titouz.gamewatch.emulateur.view.MainFrame;

public class MainController {
	
	private static MainController instance;

	private MainController() {
	}

	public static synchronized MainController getInstance() {
		if (null == instance) {
			instance = new MainController();
		}
		return instance;
	}
	
	public MainController init() {
		
		MainFrame.getInstance().init();
		
		return this;
	}

}
