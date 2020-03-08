package quarantine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Entity;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.graphics.AmbientLight;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.DropdownListField;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;

public class HomefrontScreen extends GameScreen {
	private static final Font DAY_COUNT_FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 32f);
	private final Environment environment = Game.world().loadEnvironment("rsc/tilemaps/Start.tmx");
	private final AmbientLight lighting = new AmbientLight(environment, Color.blue);
	private final Entity nathanIsAMegaShlong = new RandoCharacter();
	{

		String[] content = { "Yorick loves Java", "Audrey is cool", "Dillon is awesome", "Nathan is the coolest" };
		DropdownListField dropDown = new DropdownListField(50, 30, 250, 250, content, content.length);
		dropDown.setHeight(150);
		getComponents().add(dropDown);

		DropdownListField dropDown2 = new DropdownListField(350, 30, 250, 250, content, content.length);
		dropDown2.setHeight(150);
		getComponents().add(dropDown2);

		nathanIsAMegaShlong.setVisible(true);
		environment.add(nathanIsAMegaShlong);
		Spawnpoint enter = environment.getSpawnpoint("hospital");
		if (enter != null)
			enter.spawn(nathanIsAMegaShlong);
		setNight(false);
	}

	private int dayCount = 1;

	public void setNight(boolean night) {
		lighting.setAlpha(night ? 50 : 0);
	}

	private void cycleNight() {
		if (!t)
			dayCount++;
		setNight(t);
	}

	private boolean t = false;

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		if (t ^ (t = ((Game.loop().getTicks() / Game.loop().getTickRate()) / 150 & 1) == 1))
			cycleNight();
		lighting.render(g);

		String txt = "Day -" + dayCount;
		g.setFont(DAY_COUNT_FONT);
		g.setColor(Color.white);
		TextRenderer.render(g, txt, 0, Utils.getTxtBounds(txt, DAY_COUNT_FONT).getHeight());
	}

}
