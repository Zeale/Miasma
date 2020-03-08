package quarantine;

import java.awt.geom.Point2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.pathfinding.EntityNavigator;
import de.gurkenlabs.litiengine.pathfinding.astar.AStarPathFinder;
import de.gurkenlabs.litiengine.resources.Resources;

public class Character extends Creature {
	private final EntityNavigator en = new EntityNavigator(this,
			new AStarPathFinder(Game.world().environment().getMap()));

	public void goTo(Point2D point) {
		en.navigate(point);
	}

	public Character() {
		super("Mega-Shlong");
		Resources.spritesheets().loadFrom("rsc/sprites/sprites.info");
		setSpritePrefix("megaman");
	}

}
