import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Drops extends JPanel {

    private int squareXLocation;
    private int squareSize;
    private int squareYLocation = -squareSize;
    private int fallSpeed = 0;
    Random rand = new Random();


    public int generateRandomXLocation(){
        return squareXLocation = rand.nextInt(Game.WINDOW_WIDTH - squareSize);
    }

    public int generateRandomSquareSize(){
        return squareSize = rand.nextInt(100);
    }


    public int generateRandomFallSpeed(){
        return fallSpeed = rand.ints(10, 20, 60).findFirst().getAsInt();
    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(squareXLocation,squareYLocation,squareSize,squareSize);
    }

    public Drops(){
        generateRandomXLocation();
        generateRandomSquareSize();
        generateRandomFallSpeed();
    }
    public void update(){
        if(squareYLocation >= Game.WINDOW_HEIGHT){
            generateRandomXLocation();
            generateRandomFallSpeed();
            generateRandomSquareSize();
            squareYLocation = -squareSize;
        }
        
        if(squareYLocation <= Game.WINDOW_HEIGHT){
            squareYLocation += fallSpeed;
        }
    }
        public void paintComponent(Graphics g) {
        	   super.paintComponent(g);
        	   Graphics2D g2d = (Graphics2D)g;
        	   // Assume x, y, and diameter are instance variables.
        	   Ellipse2D.Double circle = new Ellipse2D.Double(TOP_ALIGNMENT, BOTTOM_ALIGNMENT, WIDTH, WIDTH);
        	   g2d.fill(circle);
        	}
    }
