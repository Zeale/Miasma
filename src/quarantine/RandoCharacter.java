package quarantine;

import java.awt.geom.Point2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.pathfinding.EntityNavigator;
import de.gurkenlabs.litiengine.pathfinding.astar.AStarPathFinder;
import de.gurkenlabs.litiengine.resources.Resources;

public class RandoCharacter extends Creature {

	private final String type = (/* Math.random() >= 0.5 ? "Jeremy" : */"Martha");

	private final EntityNavigator en = new EntityNavigator(this,
			new AStarPathFinder(Game.world().environment().getMap()));

	static {
		Resources.spritesheets().loadFrom("rsc/sprites/Martha/sprites.info");
	}

	public void goTo(Point2D point) {
		en.navigate(point);
	}

	private static int count;

	public RandoCharacter() {
		super("RandoCharacter-" + count++);
		setSpritePrefix(type + "_Blonde");
		Input.mouse().onClicked(event -> en.navigate(Input.mouse().getMapLocation()));
		setCollision(true);
		setCollisionBoxHeight(32);
		setCollisionBoxWidth(32);
	}

}
