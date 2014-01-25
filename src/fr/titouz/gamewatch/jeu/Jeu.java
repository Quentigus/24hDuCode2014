/*Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
 * (25/01/2014)
 * This file is part of Titz & Watch.
 * 
 * Titz & Watch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Titz & Watch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Titz & Watch.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package fr.titouz.gamewatch.jeu;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Cette classe représente un game & watch.
 */
public class Jeu {
	private List<Sequence> sequences;
	private ContextJeu context;
	private boolean continuer;
	private Thread threadJeu;
	private List<TourDeJeuListener> ecouteurs;
	
	/**
	 * Crée un jeu.
	 */
	public Jeu() {
		context = new ContextJeu();
		sequences = new LinkedList<Sequence>();
		ecouteurs = new LinkedList<TourDeJeuListener>();
		threadJeu = createThreadJeu();
	}

	public List<Sequence> getSequences() {
		return sequences;
	}

	public ContextJeu getContext() {
		return context;
	}
	
	/**
	 * Ajoute un écouteur de tour de jeu.
	 * 
	 * @param l l'écouteur de tour de jeu.
	 */
	public void addTourDeJeuListener(TourDeJeuListener l) {
		ecouteurs.add(l);
	}
	
	/**
	 * Retire un écouteur de tour de jeu.
	 * 
	 * @param l l'écouteur à retirer.
	 */
	public void removeTourDeJeuListener(TourDeJeuListener l) {
		ecouteurs.remove(l);
	}
	
	/**
	 * Joue un tour du jeu.
	 */
	public void jouerUnTour() {
		for(Sequence s: sequences) {
			s.suivant();
		}
	}
	
	/**
	 * Joue une partie.
	 */
	public void jouer() {
		threadJeu.start();
	}
	
	private Thread createThreadJeu() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				executeBoucle();
			}
		});
		return t;
	}

	private void executeBoucle() {
		long lastTime, currentTime;
		synchronized(this) {
			continuer = true;
		}
		while(continuer()) {
				lastTime = new Date().getTime();
				//tour
				jouerUnTour();
				for(TourDeJeuListener listener : ecouteurs) {
					listener.notifier();
				}
				
				currentTime = new Date().getTime();
			try {
				Thread.sleep(1000 - (currentTime - lastTime));
			} catch(InterruptedException e) {
				System.err.println("WARNING : thread de jeu interrompu.");
			}
		}
	}
	
	private synchronized boolean continuer() {
		return continuer;
	}
	
	public synchronized void stop() {
		continuer = false;
	}

}
