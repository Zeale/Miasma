package quarantine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.IKeyboard.KeyPressedListener;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;

public class MainMenuScreen extends Screen {
	private static final Color UNSELECTED_COLOR = Color.red, SELECTED_COLOR = new Color(0xFFD000);
	private static final Font TITLE_FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 72f),
			SEL_FONT = Resources.fonts().get("rsc/fonts/Pixel LCD-7.ttf", 30f);

	private boolean startSelected = true;

	private final KeyPressedListener keyListener = event -> {
		if (event.getKeyCode() == KeyEvent.VK_UP || event.getKeyCode() == KeyEvent.VK_W)
			startSelected = true;
		else if (event.getKeyCode() == KeyEvent.VK_DOWN || event.getKeyCode() == KeyEvent.VK_S)
			startSelected = false;
		else if (event.getKeyCode() == KeyEvent.VK_ENTER)
			select();
	};

	{
		Input.keyboard().onKeyPressed(keyListener);
	}

	protected MainMenuScreen() {
		super("main-menu");
	}

	@Override
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(UNSELECTED_COLOR);
		Utils.centerString(g, new Rectangle(0, 0, Game.window().getWidth(), Game.window().getHeight() * 2 / 3),
				"MIASMA", TITLE_FONT);

		Rectangle startBox = new Rectangle(0, (int) (2d / 3 * Game.window().getHeight()), Game.window().getWidth(), 40);
		Rectangle exitBox = new Rectangle(0, (int) (2d / 3 * Game.window().getHeight() + 60), Game.window().getWidth(),
				40);

		if (startSelected)
			g.setColor(SELECTED_COLOR);
		Utils.centerString(g, startBox, "Start", SEL_FONT);
		g.setColor(UNSELECTED_COLOR);
		if (!startSelected)
			g.setColor(SELECTED_COLOR);
		Utils.centerString(g, exitBox, "Exit", SEL_FONT);
	}

	private void select() {
		if (startSelected) {
			dispose();
		} else {
			Game.window();// CLOSE GAME
		}
	}

	public void dispose() {
		Input.keyboard().removeKeyPressedListener(keyListener);
	}

}
