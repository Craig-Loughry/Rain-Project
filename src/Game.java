import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;

public class Game extends JPanel {

	public static void main(String[] args) throws InterruptedException {

		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.setVisible(true);
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("Raining Multiple Squares");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		while (true) {
			game.update();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 700;
	Drops[] squareArray = new Drops[100];

	public Game() {
		for (int i = 0; i < squareArray.length; i++)
			squareArray[i] = new Drops();

	}

	public void paint(Graphics graphics) {

		// makes background black
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		graphics.setColor(Color.GRAY);
		graphics.fillOval(0, -10, 2000, 100);
		graphics.setColor(Color.red);
		graphics.fillOval(-60, 0, 800, 50);
		graphics.setColor(Color.GRAY);
		graphics.fillOval(0, 0, 300, 100);
		graphics.fillOval(400, 0, 500, 100);
		graphics.fillOval(700, 0, 300, 100);
		graphics.setColor(Color.green);
		graphics.fillRect(0, 650, 1200, 200);

		for (Drops aSquareArray : squareArray) {
			aSquareArray.paint(graphics);
		}
	}

	public void update() {
		for (Drops aSquareArray : squareArray)
			aSquareArray.update();
	}

}
