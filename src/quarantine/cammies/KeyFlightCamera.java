package quarantine.cammies;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.input.Input;

public class KeyFlightCamera extends Camera {
	private static final double DEFAULT_SCROLL_PIXELS_PER_SECOND = 400;
	private static final double DEFAULT_SCROLL_PADDING = 20;

	private double velocity;
	private double scrollPadding;

	public KeyFlightCamera() {
		this(0, 0);
	}

	public KeyFlightCamera(double x, double y) {
		this(new Point2D.Double(x, y));
	}

	public KeyFlightCamera(final Point2D focus) {
		this.setFocus(focus);
		this.velocity = DEFAULT_SCROLL_PIXELS_PER_SECOND;
		this.scrollPadding = DEFAULT_SCROLL_PADDING;
		this.setClampToMap(true);

		Game.loop().attach(this);
	}

	public double getVelocity() {
		return this.velocity;
	}

	public double getScrollPadding() {
		return this.scrollPadding;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public void setScrollPadding(double scrollPadding) {
		this.scrollPadding = scrollPadding;
	}

	@Override
	public void update() {
		this.handleFreeFlightCamera();
	}

	private void handleFreeFlightCamera() {
		if (Game.world().environment() == null || Game.world().environment().getMap() == null)
			return;

		final double scrollSpeed = this.getVelocity() / (double) Game.loop().getTickRate()
				* Game.config().input().getMouseSensitivity();

		double x = this.getFocus().getX();
		double y = this.getFocus().getY();

		double deltaY = 0, deltaX = 0;
		if (Input.keyboard().isPressed(KeyEvent.VK_W) || Input.keyboard().isPressed(KeyEvent.VK_UP))
			deltaY -= scrollSpeed;
		if (Input.keyboard().isPressed(KeyEvent.VK_S) || Input.keyboard().isPressed(KeyEvent.VK_DOWN))
			deltaY += scrollSpeed;

		if (Input.keyboard().isPressed(KeyEvent.VK_A) || Input.keyboard().isPressed(KeyEvent.VK_LEFT))
			deltaX -= scrollSpeed;
		if (Input.keyboard().isPressed(KeyEvent.VK_D) || Input.keyboard().isPressed(KeyEvent.VK_RIGHT))
			deltaX += scrollSpeed;

		x += deltaX;
		y += deltaY;

		this.setFocus(new Point2D.Double(x, y));
	}
}
