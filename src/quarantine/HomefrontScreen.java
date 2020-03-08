package quarantine;

import java.awt.Color;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.graphics.AmbientLight;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

public class HomefrontScreen extends GameScreen {
	private final Environment environment = Game.world().loadEnvironment("rsc/tilemaps/Start.tmx");
	private final AmbientLight lighting = new AmbientLight(environment, Color.blue);

	{
		setNight(false);
	}

	public void setNight(boolean night) {
		lighting.setAlpha(night ? 50 : 0);
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		lighting.render(g);
	}

}
