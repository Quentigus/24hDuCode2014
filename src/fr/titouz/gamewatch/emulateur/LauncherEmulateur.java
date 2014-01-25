package fr.titouz.gamewatch.emulateur;

import fr.titouz.gamewatch.emulateur.controller.MainController;

public class LauncherEmulateur {

	public static void main (String[] args) {
		MainController.getInstance().init();
	}
}
