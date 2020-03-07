package quarantine;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Utils {
	/**
	 * This method centers a <code>String</code> in a bounding
	 * <code>Rectangle</code>.
	 * 
	 * @param g    - The <code>Graphics</code> instance.
	 * @param r    - The bounding <code>Rectangle</code>.
	 * @param s    - The <code>String</code> to center in the bounding rectangle.
	 * @param font - The display font of the <code>String</code>
	 * 
	 * @see java.awt.Graphics
	 * @see java.awt.Rectangle
	 * @see java.lang.String
	 */
	public static void centerString(Graphics g, Rectangle r, String s, Font font) {
		FontRenderContext frc = new FontRenderContext(null, true, true);

		Rectangle2D r2D = font.getStringBounds(s, frc);
		int rWidth = (int) Math.round(r2D.getWidth());
		int rHeight = (int) Math.round(r2D.getHeight());
		int rX = (int) Math.round(r2D.getX());
		int rY = (int) Math.round(r2D.getY());

		int a = (r.width / 2) - (rWidth / 2) - rX;
		int b = (r.height / 2) - (rHeight / 2) - rY;

		g.setFont(font);
		g.drawString(s, r.x + a, r.y + b);
	}
}
