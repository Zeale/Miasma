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
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;
import quarantine.noncammies.BoxComp;
import quarantine.noncammies.TextComponent;

public class HomefrontScreen extends GameScreen {
	private static final Font DAY_COUNT_FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 32f);
	private final Environment environment = Game.world().loadEnvironment("rsc/tilemaps/Start.tmx");
	private final AmbientLight lighting = new AmbientLight(environment, Color.blue);
	private final BoxComp comp = new BoxComp(50, 50, 1200, 700);
	private final Entity nathanIsAMegaShlong = new RandoCharacter();
	{
		comp.getComponents().add(new TextComponent(100,100, "Task 1"));
		getComponents().add(comp);
		
		comp.getComponents().add(new TextComponent(100, 200, "Task 2"));
		
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

	public void dispose() {
		comp.dispose();
	}

}
