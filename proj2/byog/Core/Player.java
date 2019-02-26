package byog.Core;

import byog.TileEngine.TERenderer;
import edu.princeton.cs.introcs.StdDraw;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;


public class Player {

    private TETile[][] tile;
    private Position p;

    public Player(TETile[][] tiles, Position p) {
        tile = tiles;
        this.p = p;
        tile[p.getX()][p.getY()] = Tileset.SAND;
    }

    public void move() {
        if (StdDraw.hasNextKeyTyped()) {
            direction(StdDraw.nextKeyTyped());
        }
    }

    public void direction(char key) {
        char direction = key;
        switch (direction) {
            case 'w': moveUp();
                break;
            case 'a': moveLeft();
                break;
            case 's': moveDown();
                break;
            case 'd': moveRight();
                break;
        }
    }

    public void moveUp() {
        if (check(p.getX(), p.getY() + 1)) {
            tile[p.getX()][p.getY() + 1] = Tileset.SAND;
            tile[p.getX()][p.getY()] = Tileset.FLOOR;
            p = new Position(p.getX(), p.getY() + 1);
        }
    }

    public void moveLeft() {
        if (check(p.getX() - 1, p.getY())) {
            tile[p.getX() - 1][p.getY()] = Tileset.SAND;
            tile[p.getX()][p.getY()] = Tileset.FLOOR;
            p = new Position(p.getX() - 1, p.getY());
        }
    }

    public void moveDown() {
        if (check(p.getX(), p.getY() - 1)) {
            tile[p.getX()][p.getY() - 1] = Tileset.SAND;
            tile[p.getX()][p.getY()] = Tileset.FLOOR;
            p = new Position(p.getX(), p.getY() - 1);
        }

    }

    public void moveRight() {
        if (check(p.getX() + 1, p.getY())) {
            tile[p.getX() + 1][p.getY()] = Tileset.SAND;
            tile[p.getX()][p.getY()] = Tileset.FLOOR;
            p = new Position(p.getX() + 1, p.getY());
        }

    }

    public boolean check(int x, int y) {
        if (tile[x][y] == Tileset.FLOOR) {
            return true;
        }
        return false;
    }

}
