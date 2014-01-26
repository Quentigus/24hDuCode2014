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

package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class EmulateurTitleLabel extends JLabel{

	private static EmulateurTitleLabel instance;
	private final String title = "Titz & Watch";

	private EmulateurTitleLabel() {
	}

	public static synchronized EmulateurTitleLabel getInstance() {
		if (null == instance) {
			instance = new EmulateurTitleLabel();
		}
		return instance;
	}
	
	public EmulateurTitleLabel init() {
		this.setPreferredSize(new Dimension(100,100));
		this.setOpaque(false);
		this.setText(this.title);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		return this;
	}
	
}
