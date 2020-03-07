package quarantine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.FreeFlightCamera;

public class Miasma {
	public static void main(String[] args) {
		Game.info().setName("Miasma");
		Game.info().setVersion("v0b0-nightly");
		Game.info().setDescription("An homage to the Corona virus.");

		Game.init();

		FreeFlightCamera cam = new FreeFlightCamera();
		cam.setClampToMap(true);
		Game.world().setCamera(cam);

		Game.screens().add(new MainMenuScreen());

		Game.start();
	}
}
