package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class PanelImagePeignable extends PanelImage {

	private Point ptClick;

	private Point ptDrag;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (ptDrag != null) {
			g2d.drawLine((int) ptDrag.getX() - 1, 0, (int) ptDrag.getX() - 1, this.getHeight());
			g2d.drawLine(0, (int) ptDrag.getY() - 1, this.getWidth(), (int) ptDrag.getY() - 1);
		}
		if (ptClick != null) {

			int origX;
			int origY;
			int width;
			int heigth;

			if (ptClick.getX() < ptDrag.getX() && ptClick.getY() < ptDrag.getY()) {
				origX = (int) ptClick.getX();
				origY = (int) ptClick.getY();
				width = (int) (ptDrag.getX() - ptClick.getX());
				heigth = (int) (ptDrag.getY() - ptClick.getY());
			}
			else if (ptClick.getX() < ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				origX = (int) ptClick.getX();
				origY = (int) ptDrag.getY();
				width = (int) (ptDrag.getX() - ptClick.getX());
				heigth = (int) (ptClick.getY() - ptDrag.getY());
			}
			else if (ptClick.getX() >= ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				origX = (int) ptDrag.getX();
				origY = (int) ptDrag.getY();
				width = (int) (ptClick.getX() - ptDrag.getX());
				heigth = (int) (ptClick.getY() - ptDrag.getY());
			}
			else {
				origX = (int) ptDrag.getX();
				origY = (int) ptClick.getY();
				width = (int) (ptClick.getX() - ptDrag.getX());
				heigth = (int) (ptDrag.getY() - ptClick.getY());
			}

			float dash1[] = {10.0f};
			BasicStroke dashed =
					new BasicStroke(1.0f,
					BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER,
					10.0f, dash1, 0.0f);
			g2d.setColor(Color.black);
			g2d.setStroke(dashed);

			g2d.drawRect(origX, origY, width, heigth);
			//g2d.fillRect((int) (ptClick.getX()), (int) (ptClick.getY()), 50, 50);

		}
	}

	/**
	 * Default constructor of
	 * <code>PanelImagePeignable</code>.
	 */
	public PanelImagePeignable(BufferedImage img) {
		super(img);
	}

	public BufferedImage getSubImage() {
		BufferedImage sub = null;
		if (!(ptClick.getX() == ptDrag.getX() && ptClick.getY() == ptDrag.getY()) && ptClick.getX() > 0 && ptClick.getY() > 0 && ptDrag.getX() > 0 && ptDrag.getY() > 0) {
			if (ptClick.getX() < ptDrag.getX() && ptClick.getY() < ptDrag.getY()) {
				sub = image.getSubimage((int) ptClick.getX(), (int) ptClick.getY(), (int) (ptDrag.getX() - ptClick.getX()), (int) (ptDrag.getY() - ptClick.getY()));
			}
			else if (ptClick.getX() < ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				sub = image.getSubimage((int) ptClick.getX(), (int) ptDrag.getY(), (int) (ptDrag.getX() - ptClick.getX()), (int) (ptClick.getY() - ptDrag.getY()));
			}
			else if (ptClick.getX() >= ptDrag.getX() && ptClick.getY() >= ptDrag.getY()) {
				sub = image.getSubimage((int) ptDrag.getX(), (int) ptDrag.getY(), (int) (ptClick.getX() - ptDrag.getX()), (int) (ptClick.getY() - ptDrag.getY()));
			}
			else {
				sub = image.getSubimage((int) ptDrag.getX(), (int) ptClick.getY(), (int) (ptClick.getX() - ptDrag.getX()), (int) (ptDrag.getY() - ptClick.getY()));
			}
			ptClick = null;
			ptDrag = null;
		}
		return sub;
	}

	public void setPtClick(Point ptClick) {
		this.ptClick = ptClick;
	}

	public void setPtDrag(Point ptDrag) {
		this.ptDrag = ptDrag;
	}
}