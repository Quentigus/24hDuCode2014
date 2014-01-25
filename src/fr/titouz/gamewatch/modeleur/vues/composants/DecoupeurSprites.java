package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
	
	private ScrollPaneSelection jsp;
	
	private JPanel panelSprites;

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
		this.panelSprites = new JPanel(new FlowLayout());
		this.add (panelSprites,BorderLayout.WEST);
		panelSprites.add(new JButton());
		
	}

	private void choisirImage() {
		System.out.println("charg");
		JFileChooser chooser = new JFileChooser(new File("C:/Users/Bastien/Documents/NetBeansProjects/24hDuCode2014/ressources"));
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
		try {
			System.out.println(imgPath);
			jsp = new ScrollPaneSelection(ImageIO.read(new File(imgPath)),panelSprites);
			this.add(jsp, BorderLayout.CENTER);
			this.validate();
			this.repaint();
			/*
			 setSize(300, 250);
			 setVisible(true);*/
		} catch (IOException ex) {
			Logger.getLogger(DecoupeurSprites.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}