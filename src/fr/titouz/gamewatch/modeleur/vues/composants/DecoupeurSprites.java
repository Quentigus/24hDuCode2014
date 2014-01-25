package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class DecoupeurSprites extends JPanel {

	private JButton boutChoixIm;
	
	private JScrollPane jsp;

	/**
	 * Default constructor of
	 * <code>DecoupeurSprites</code>.
	 */
	public DecoupeurSprites() {
		this.setLayout(new BorderLayout());

		this.boutChoixIm = new JButton("Choix Image");

		boutChoixIm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choisirImage();
			}
		});

		this.add(boutChoixIm, BorderLayout.NORTH);
	}

	private void choisirImage() {
		System.out.println("charg");
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			chargImage(chooser.getSelectedFile().getPath());
		}
		/*
		 setSize(300, 250);
		 setVisible(true);*/
	}

	private void chargImage(String imgPath) {
		this.validate();
		System.out.println(this.isValid());
		System.out.println(imgPath);
		jsp = new JScrollPane(new JLabel(new ImageIcon(imgPath)));
		this.remove(jsp);
		//this.add(jsp, BorderLayout.CENTER);
		System.out.println(this.isValid());
		this.validate();
		
		System.out.println(this.isValid());
		this.repaint();
		/*
		 setSize(300, 250);
		 setVisible(true);*/
	}
}