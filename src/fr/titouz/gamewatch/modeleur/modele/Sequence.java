package fr.titouz.gamewatch.modeleur.modele;

import java.io.Serializable;

public class Sequence implements Serializable {

	private static final long serialVersionUID = 5596002822836246892L;
	private Sprite initial;
	private Sprite destination;
	private String condition;
	
	public Sequence(Sprite pInitial, Sprite pDestination, String pCondition) {
		this.initial = pInitial;
		this.destination = pDestination;
		this.condition = pCondition;
	}

	public Sprite getInitial() {
		return initial;
	}

	public Sprite getDestination() {
		return destination;
	}

	public String getCondition() {
		return condition;
	}
}
