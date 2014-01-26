package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class ScrollPaneSelection extends JScrollPane {

	private JPanel panelSprites;

	private PanelImagePeignable pan;

	private BufferedImage img;
	
	/**
	 * Default constructor of
	 * <code>ScrollPaneSelection</code>.
	 */
	public ScrollPaneSelection(PanelImagePeignable pan, JPanel panelSprites) {
		super(pan);
		this.img = pan.getImage();
		//this.add(lab);
		this.pan = pan;
		this.panelSprites = panelSprites;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cliqueSouris(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				relacheSouris(e);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				setCursor(Cursor.getDefaultCursor());
			}
			
			
			
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				dragSouris(e);
			}
			

			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				dragSouris(e);
			}
		});


	}

	private void cliqueSouris(MouseEvent e) {
		pan.setPtClick(e.getPoint());
		pan.setPtDrag(e.getPoint());

		this.repaint();

	}

	private void relacheSouris(MouseEvent e) {
		System.out.println("relache");
		BufferedImage sub = pan.getSubImage();
		if(sub != null){
			this.repaint();
			this.panelSprites.add(new BoutonSprite(sub));
			this.panelSprites.revalidate();
			this.panelSprites.repaint();
		}
	}

	private void dragSouris(MouseEvent e) {
		pan.setPtDrag(e.getPoint());
		this.repaint();
	}

	public PanelImagePeignable getPan() {
		return pan;
	}
}