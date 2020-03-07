package quarantine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

public class HomefrontScreen extends GameScreen {
	private final Environment environment = Game.world().loadEnvironment("rsc/tilemaps/Start.tmx");
}
