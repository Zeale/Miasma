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

	private boolean t = false;

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		if (t ^ (t = ((Game.loop().getTicks() / Game.loop().getTickRate()) / 150 & 1) == 1))
			setNight(t);
		lighting.render(g);
	}

}
