/* Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
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
		this.label = new JLabel(pLabel + " :");
				
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
