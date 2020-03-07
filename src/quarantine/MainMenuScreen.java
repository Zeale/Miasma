package quarantine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class MainMenuScreen extends Screen {

	protected MainMenuScreen() {
		super("main-menu");
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setFont(Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 72f));
		g.setColor(Color.RED);
		Point2D center = Game.window().getCenter();
		double x = center.getX(), y = center.getY() / 3 * 2;
		TextRenderer.render(g, "MIASMA", x, y);
	}

}
