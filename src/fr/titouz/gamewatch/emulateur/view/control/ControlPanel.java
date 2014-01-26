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

package fr.titouz.gamewatch.emulateur.view.control;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ControlPanel extends JPanel{

	private static ControlPanel instance;

	private ControlPanel() {
	}

	public static synchronized ControlPanel getInstance() {
		if (null == instance) {
			instance = new ControlPanel();
		}
		return instance;
	}
	
	public ControlPanel init() {
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10,10,10,10));
		this.setMinimumSize(new Dimension(600,150));
		this.setPreferredSize(new Dimension(600,150));
		this.setMaximumSize(new Dimension(600,150));
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(ControlList.getInstance().init()), BorderLayout.CENTER);
		return this;
	}
}
