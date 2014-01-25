package fr.titouz.gamewatch.emulateur.controller;

import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;

public class ControlController {

	private static ControlController instance;

	private ControlController() {
	}

	public static synchronized ControlController getInstance() {
		if (null == instance) {
			instance = new ControlController();
		}
		return instance;
	}
	
	public String[] getListGames() {
		String[] list = {"Mario","Donkey Kong","Jongleur", "Saut d'eau"};
		System.out.println(list);
		return list;
	}

	public void enterListControl(String selectedValue) {
		System.out.println(selectedValue);
		GameTitlePanel.getInstance().setGameOver();
		
	}
	
	public void rightControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("right");
		}
	}
	
	public void leftControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("left");
		}
	}

	public void upControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("up");
		}
	}
	
	public void downControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("down");
		}
	}
}
