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
	private String url_fond = "ressources/right-arrow.png";
	private Image img;
	
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
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			this.img = ImagesHelper.getImage(this.url_fond);
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private class WatchRenderCell extends JLabel implements ListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			
			setText(value.toString());
			setOpaque(true);
			if(isSelected || cellHasFocus) {
				setForeground(Color.white);
				setBackground(new Color(87,87,87));
			}
			else {
				setBackground(Color.white);
				setForeground(new Color(87,87,87));
			}
			this.setPreferredSize(new Dimension(500,45));
			this.validate();this.repaint();
			
			return this;
		}
		
	}

}
