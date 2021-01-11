package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {
    private Timer t = new Timer(100, this);
    public String state;

    private Snake snake;
    private Food food;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "START";

        game = g;
        snake = g.getPlayer();
        food = g.getFood();

        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);

        if (state.equals("START")) {
            g2.setColor(Color.WHITE);
            g2.drawString("Press Any Key", Game.width / 2 * Game.dimension - 40,
                    Game.height / 2 * Game.dimension - 20);
        } else if (state.equals("RUNNING")) {
            g2.setColor(Color.RED);
            g2.fillRect(food.getX() * Game.dimension, food.getY() * Game.dimension, Game.dimension,
                    Game.dimension);

            g2.setColor(Color.GREEN);
            for (Rectangle body : snake.getBody()) {
                g2.fill(body);
            }
        } else {
            g2.setColor(Color.WHITE);
            g2.drawString("Your Score: " + (snake.getBody().size() - 3),
                    Game.width / 2 * Game.dimension - 40,
                    Game.height / 2 * Game.dimension - 20);
            g2.setColor(Color.WHITE);
            g2.drawString("RESTART", Game.width / 2 * Game.dimension - 30,
                    Game.height / 2 * Game.dimension);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }
}
