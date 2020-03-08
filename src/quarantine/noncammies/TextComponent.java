package quarantine.noncammies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.resources.Resources;

public class TextComponent extends GuiComponent {
	private static final Font FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 32f);
	private String text;

	public TextComponent(int x, int y, String text) {
		super(x, y);
		this.text = text;
	}

	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.setFont(FONT);
		TextRenderer.render(g, this.text, getX(), getY());
	}
	
	public void changeText(String text) {
		this.text = text;
	}
}
