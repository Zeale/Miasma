package quarantine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

public class Miasma {
	public static void main(String[] args) {
		Game.info().setName("Miasma");
		Game.info().setVersion("v0b0-nightly");
		Game.info().setDescription("An homage to the Corona virus.");

		Game.init();

		Game.graphics().setBaseRenderScale(2);
		
		Game.screens().add(new MainMenuScreen());

		Game.start();
	}
}

class TestScreen extends GameScreen {

}