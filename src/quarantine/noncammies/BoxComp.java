package quarantine.noncammies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.IMouse.MouseClickedListener;
import de.gurkenlabs.litiengine.resources.Resources;
import quarantine.Utils;

public class BoxComp extends GuiComponent {
	private static final Rectangle BOX = new Rectangle(50, 50, 150, 50);
	private static final Font DOT_DOT_DOT_FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 32f);
	private static final Image CLOSE_BUTTON = Resources.images().get("rsc/graphics/gui/BoxCompCloseButton.png");

	public BoxComp(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	private boolean closed = true;
	private final MouseClickedListener clickListener = event -> {
		if (closed && BOX.contains(Input.mouse().getLocation())) {
			event.consume();
			closed = false;
		} else if (!(closed || getBoundingBox().contains(Input.mouse().getLocation()))
				|| new Rectangle((int) (getX() + getWidth() - CLOSE_BUTTON.getWidth(null)), (int) getY(),
						(int) CLOSE_BUTTON.getWidth(null), (int) CLOSE_BUTTON.getHeight(null))
								.contains(Input.mouse().getLocation())) {
			event.consume();
			closed = true;
		}
	};
	{
		Input.mouse().onClicked(clickListener);
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(new Color(0xA8808080, true));
		if (closed) {
			g.fillRect(50, 50, 150, 50);
			g.setColor(Color.white);
			Utils.centerString(g, BOX, ". . .", DOT_DOT_DOT_FONT);
		} else {
			g.fillRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
			super.render(g);
			ImageRenderer.render(g, CLOSE_BUTTON, getX() + getWidth() - CLOSE_BUTTON.getWidth(null), getY());
		}
	}

	public void dispose() {
		Input.mouse().removeMouseClickedListener(clickListener);
	}

}
