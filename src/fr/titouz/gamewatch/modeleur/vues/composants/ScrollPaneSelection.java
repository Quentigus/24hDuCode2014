package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
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

	private Point ptClick;

	private Point ptDrag;

	private JPanel panelSprites;

	private JLabel lab;

	private BufferedImage img;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (ptClick != null) {
			g2d.setColor(Color.red);
			System.out.println("la");
			//g2d.fillRect((int) (ptClick.getX()), (int) (ptClick.getY()), (int) (ptDrag.getX() - ptClick.getX()), (int) (ptDrag.getY() - ptClick.getY()));
			g2d.fillRect((int) (ptClick.getX()), (int) (ptClick.getY()), 50, 50);
		}
	}

	/**
	 * Default constructor of
	 * <code>ScrollPaneSelection</code>.
	 */
	public ScrollPaneSelection(BufferedImage img, JPanel panelSprites) {
		super(new JLabel(new ImageIcon(img)));

		//this.add(lab);
		this.lab = new JLabel(new ImageIcon(img));
		this.img = img;
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
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				dragSouris(e);
			}
		});


	}

	private void cliqueSouris(MouseEvent e) {
		ptClick = e.getPoint();
		ptDrag = e.getPoint();
		System.out.println(ptClick);

		this.repaint();

	}

	private void relacheSouris(MouseEvent e) {
		System.out.println("relache");
		BufferedImage sub;
		if (!(ptClick.getX() == ptDrag.getX() && ptClick.getY() == ptDrag.getY())) {
			if (ptClick.getX() < ptDrag.getX() && ptClick.getY() < ptDrag.getY()) {
				sub = img.getSubimage((int) ptClick.getX(), (int) ptClick.getY(), (int) (ptDrag.getX() - ptClick.getX()), (int) (ptDrag.getY() - ptClick.getY()));
			}
			else if (ptClick.getX() < ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				sub = img.getSubimage((int) ptClick.getX(), (int) ptDrag.getY(), (int) (ptDrag.getX() - ptClick.getX()), (int) (ptClick.getY() - ptDrag.getY()));
			}
			else if (ptClick.getX() >= ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				sub = img.getSubimage((int) ptDrag.getX(), (int) ptDrag.getY(), (int) (ptClick.getX() - ptDrag.getX()), (int) (ptClick.getY() - ptDrag.getY()));
			}
			else {
				sub = img.getSubimage((int) ptDrag.getX(), (int) ptClick.getY(), (int) (ptClick.getX() - ptDrag.getX()), (int) (ptDrag.getY() - ptClick.getY()));
			}
			ptClick = null;
			ptDrag = null;
			this.repaint();
			this.panelSprites.add(new JButton(new ImageIcon(sub)));
			this.panelSprites.revalidate();
			this.panelSprites.repaint();
		}
	}

	private void dragSouris(MouseEvent e) {
		System.out.println(ptDrag);
		ptDrag = e.getPoint();
		System.out.println("----");
		System.out.println(ptClick);
		System.out.println(ptDrag);
		this.repaint();
	}
}