package fr.titouz.gamewatch.emulateur.controller;

import java.io.File;
import java.util.List;

import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;
import fr.titouz.gamewatch.tools.Repertoire;

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
		List<String> list = Repertoire.getListeFichiers();
		String[] games = new String[list.size()];
		list.toArray(games);
		
		return games;
	}

	public void enterListControl(String selectedValue) {
		if(selectedValue != null && !MainController.getInstance().isGameOn()) {
			String url = "C:\\"+selectedValue.replaceAll(" ", "_")+".titz";
			chargerJeu(url);
			MainController.getInstance().launchGame();
			CenterPanel.getInstance().changerEcranToGame();
		}
		
	}
	
	private void chargerJeu(String url) {
		File f = new File(url);
		
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
