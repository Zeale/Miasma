package quarantine;

import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.resources.Resources;

public class Character extends Creature {

	public Character() {
		super("Mega-Shlong");
		Resources.spritesheets().loadFrom("rsc/sprites/sprites.info");
		setSpritePrefix("megaman");
	}

}
