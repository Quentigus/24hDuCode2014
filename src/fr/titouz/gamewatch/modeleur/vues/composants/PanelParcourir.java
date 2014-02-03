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

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

public class PanelParcourir extends JPanel {
	
	private static final long serialVersionUID = 8546975059109314837L;
	private JPanel selection;
	private JButton parcourir;
	private JLabel label;
	
	public PanelParcourir(ActionListener pListener) {
		this.parcourir = new JButton("Parcourir ...");
		this.parcourir.addActionListener(pListener);

		this.selection = new JPanel();
		this.selection.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.selection.add(this.parcourir);
		
		this.label = new JLabel();

		this.add(this.selection);
		this.add(this.label);
			
		this.validate();
	}
	
	public void setText(String label) {
		this.label.setText(label);
	}
}
