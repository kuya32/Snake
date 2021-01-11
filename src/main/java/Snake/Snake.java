package Snake;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    public ArrayList<Rectangle> body;
    private int w = Game.width;
    private int h = Game.height;
    private int d = Game.dimension;
    private String move;

    public Snake() {
        body = new ArrayList<>();

        Rectangle temp = new Rectangle(d, d);
        temp.setLocation(w / 2 * d, h / 2 * d);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        body.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        body.add(temp);

        move = "NOTHING";
    }

    public void move() {
        if (!move.equals("NOTHING")) {
            Rectangle firstBody = body.get(0);

            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

            switch (move) {
                case "UP":
                    temp.setLocation(firstBody.x, firstBody.y - Game.dimension);
                    break;
                case "DOWN":
                    temp.setLocation(firstBody.x, firstBody.y + Game.dimension);
                    break;
                case "LEFT":
                    temp.setLocation(firstBody.x - Game.dimension, firstBody.y);
                    break;
                case "RIGHT":
                    temp.setLocation(firstBody.x + Game.dimension, firstBody.y);
                    break;
            }
            body.add(0, temp);
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Rectangle firstBody = body.get(0);
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);

        switch (move) {
            case "UP":
                temp.setLocation(firstBody.x, firstBody.y - Game.dimension);
                break;
            case "DOWN":
                temp.setLocation(firstBody.x, firstBody.y + Game.dimension);
                break;
            case "LEFT":
                temp.setLocation(firstBody.x - Game.dimension, firstBody.y);
                break;
            case "RIGHT":
                temp.setLocation(firstBody.x + Game.dimension, firstBody.y);
                break;
        }
        body.add(0, temp);
    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return body.get(0).x;
    }

    public int getY() {
        return body.get(0).y;
    }

    public void up() {
        if (!move.equals("DOWN")) {
            move = "UP";
        }
    }
    public void down() {
        if (!move.equals("UP")) {
            move = "DOWN";
        }
    }

    public void left() {
        if (!move.equals("RIGHT")) {
            move = "LEFT";
        }
    }

    public void right() {
        if (!move.equals("LEFT")) {
            move = "RIGHT";
        }
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
