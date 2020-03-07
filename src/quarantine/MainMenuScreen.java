package quarantine;

import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.resources.Resources;

public class MainMenuScreen extends Screen {

	private final Environment env = Game.world().loadEnvironment("rsc/tilemaps/Start.tmx");
	{
		env.getMap().getTilesets().add(Resources.tilesets().get("rsc/tilesets/Miasma City-1.tsx"));
	}

	protected MainMenuScreen() {
		super("main-menu");
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
	}

}
