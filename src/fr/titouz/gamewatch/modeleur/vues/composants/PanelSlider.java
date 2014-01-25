package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class PanelSlider extends JPanel {
	
	private static final long serialVersionUID = 8546975059109314837L;
	private JSlider slider;
	private JLabel label;
	private ChangeListener listener;
	
	public PanelSlider(String pLabel, ChangeListener pListener) {
		this(pLabel, 0, 100, 0, pListener);
	}
	
	public PanelSlider(String pLabel, int pMin, int pMax, int pValeur, ChangeListener pListener) {
		this.listener = pListener;
		this.label = new JLabel(pLabel);
				
		this.slider = new JSlider(pMin, pMax, pValeur);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(this.label);
		this.add(this.slider);
		this.slider.addChangeListener(listener);
	}

	public int getValue() {
		return this.slider.getValue();
	}

	public JSlider getSlider() {
		return slider;
	}
}
