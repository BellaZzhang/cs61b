package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class Hexagon {

    private TETile[][] tile;
    private int s;
    private int line;
    private Position p;

    public Hexagon(TETile[][] tiles, int length, Position position) {
        tile = tiles;
        s = length;
        line = 0;
        p = position;
        createHexagon();
    }

    public void createHexagon() {
        TETile type = random();
        createBottom(s, type);
        line = 0;
        createTop(s, type);
    }

    public static int midLength(int s) {
        return s + 2 * (s - 1);
    }

    public void createBottom(int s, TETile type) {
        for (int y = 0; y < s; y++) {
            fillLine(tile, y, s, type);
            line++;
        }
    }

    public void createTop(int s, TETile type) {
        for (int y = s * 2 - 1; y > s - 1; y--) {
            fillLine(tile, y, s, type);
            line++;
        }
    }

    public void fillLine(TETile[][] tile, int y, int s, TETile type) {
        int a = 0;
        int b = 0;
        for (int x = 0; x < midLength(s); x++) {
            if (empty(s, line, a) && !fill(s, line, b)) {
                tile[x + p.xPos()][y + p.yPos()] = type;
                b++;
            }
            if (!empty(s, line, a)) {
                checkTile(tile, x + p.xPos(), y + p.yPos());
                a++;
            }
            if (empty(s, line, a) && fill(s, line, b)) {
                tile[x + p.xPos()][y + p.yPos()] = Tileset.NOTHING;
            }
        }
    }

    public TETile random() {
        Random random = new Random();
        int tile = random.nextInt(8);
        switch (tile) {
            case 0: return Tileset.WATER;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.WALL;
            case 3: return Tileset.FLOOR;
            case 4: return Tileset.GRASS;
            case 5: return Tileset.TREE;
            case 6: return Tileset.MOUNTAIN;
            case 7: return Tileset.SAND;
            default: return Tileset.SAND;
        }
    }

    public void checkTile(TETile[][] tile, int x, int y) {
        if (tile[x][y] != Tileset.NOTHING) {
            return;
        }
    }

    //return true if spaces supposed to be empty is filled
    public static boolean empty(int s, int line, int a) {
        return s - 1 - line - a == 0;
    }

    //return true if spaces to be filled is filled
    public static boolean fill(int s, int line, int b) {
        return s + 1 + line * 2 - b == 0;
    }


}
