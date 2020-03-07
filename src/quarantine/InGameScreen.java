package quarantine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

public class InGameScreen extends GameScreen{

	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.WHITE);
		//Point2D center = Game.window().getCenter();
		int winWidth = Game.window().getWidth();
		Rectangle2D rect = new Rectangle2D.Double(40,20,winWidth-95, 40);
		g.setColor(Color.WHITE);
		ShapeRenderer.render(g, rect);
		
	}
}
