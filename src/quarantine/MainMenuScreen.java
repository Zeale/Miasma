package quarantine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class MainMenuScreen extends Screen {

	protected MainMenuScreen() {
		super("main-menu");
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.red);
		Utils.centerString(g, new Rectangle(0, 0, Game.window().getWidth(), Game.window().getHeight() * 2 / 3),
				"MIASMA", Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 72f));
	}

}
