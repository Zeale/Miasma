package quarantine;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.Camera;
import quarantine.cammies.KeyFlightCamera;

public class Miasma {

	private static HomefrontScreen HOME_FRONT_SCREEN;

	public static HomefrontScreen homeFrontScreen() {
		return HOME_FRONT_SCREEN == null ? HOME_FRONT_SCREEN = new HomefrontScreen() : HOME_FRONT_SCREEN;
	}

	public static void main(String[] args) {
		Game.info().setName("Miasma");
		Game.info().setVersion("v0b0-nightly");
		Game.info().setDescription("An homage to the Corona virus.");

		Game.init();
		homeFrontScreen();// Load the main game screen.

		Camera cam = new KeyFlightCamera();
		cam.setClampToMap(true);
		Game.world().setCamera(cam);

		Game.screens().add(new MainMenuScreen());

		Game.start();
	}
}
