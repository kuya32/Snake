package Snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {
    public Snake player;
    public Food food;
    public Graphics graphics;

    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;

    public JFrame window;

    public Game() {
        window = new JFrame();

        player = new Snake();
        food = new Food(player);
        graphics = new Graphics(this);

        window.add(graphics);

        window.setTitle("Snake");
        window.setSize(width * dimension + 2, height * dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        graphics.state = "RUNNING";
    }

    public void update() {
        if (graphics.state.equals("RUNNING")) {
            if (checkFoodCollision()) {
                player.grow();
                food.randomSpawn(player);
            } else if (checkWallCollision() || checkSelfCollision()) {
                graphics.state = "END";
            } else {
                player.move();
            }
        }
    }

    public boolean checkWallCollision() {
        return player.getX() < 0 || player.getX() >= width * dimension || player.getY() < 0 ||
                player.getY() >= height * dimension;
    }

    public boolean checkFoodCollision() {
        return player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension;
    }

    public boolean checkSelfCollision() {
        for (int i = 1; i < player.getBody().size(); i++) {
            if (player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (graphics.state.equals("RUNNING")) {
            if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W &&
                    !player.getMove().equals("DOWN")) {
                player.up();
            } else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S && !player.getMove().equals("UP")) {
                player.down();
            } else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A && !player.getMove().equals("RIGHT")) {
                player.left();
            } else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D && !player.getMove().equals("LEFT")) {
                player.right();
            }
        } else {
            this.startGame();
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Snake getPlayer() {
        return player;
    }

    public void setPlayer(Snake player) {
        this.player = player;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }
}
