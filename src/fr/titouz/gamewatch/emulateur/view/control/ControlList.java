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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.controller.ControlController;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class ControlList extends JList<String>{
	
	private static ControlList instance;
	private String[] games;
	
	private ControlList() {
	}

	public static synchronized ControlList getInstance() {
		if (null == instance) {
			instance = new ControlList();
		}
		return instance;
	}
	
	public ControlList init() {
		this.games = ControlController.getInstance().getListGames();
		this.setListData(this.games);
		this.setCellRenderer(new WatchRenderCell());
		this.setBackground(new Color(183,183,148));
		
		//event
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					ControlController.getInstance().enterListControl(instance.getSelectedValue());
				}
			}
		});
		
		return this;
	}
	
	
	private class WatchRenderCell extends JLabel implements ListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			
			setText(value.toString());
			setOpaque(true);
			if(isSelected || cellHasFocus) {
				setForeground(new Color(183,183,148));
				setBackground(new Color(87,87,87));
			}
			else {
				setBackground(new Color(183,183,148));
				setForeground(new Color(87,87,87));
			}
			this.setPreferredSize(new Dimension(500,45));
			this.validate();this.repaint();
			
			return this;
		}
		
	}

}
