package quarantine.noncammies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.resources.Resources;

public class BoxComp extends GuiComponent {

	private static final Image CLOSE_BUTTON = Resources.images().get("rsc/graphics/gui/BoxCompCloseButton.png");

	public BoxComp(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(0xA8808080, true));
		g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		super.render(g);
		ImageRenderer.render(g, CLOSE_BUTTON, getX() + getWidth() - CLOSE_BUTTON.getWidth(null), getY());
	}

}
