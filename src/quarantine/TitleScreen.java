package quarantine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class TitleScreen extends Screen {

	private final BufferedImage title = Resources.images().get("rsc/title/title.png");
	private final long start = Game.time().now();

	protected TitleScreen() {
		super("title");
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		ImageRenderer.render(g, title, Game.window().getCenter().getX() - title.getWidth() / 2,
				Game.window().getCenter().getY() - title.getHeight() / 2);
		if (Game.time().since(start) > 2000)
			;
	}

}
