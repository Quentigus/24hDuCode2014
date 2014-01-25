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
