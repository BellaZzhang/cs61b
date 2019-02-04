package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] tiles = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }

        Position p = new Position(5, 10, 3);
        tessalation(tiles, p, new int[]{3, 4, 5, 4, 3});

        ter.renderFrame(tiles);
    }

    //Creates a hexagon of side length s
    public static void addHexagon(TETile[][] tiles, Position p) {
        //calculate middle length s + 2(s - 1)
        //create a TETile[][] tile of rectangle middle length and height s
        //fill up tile by line
        //instance variables for empty and filled up squares
        //method for flipped
        //insert flipped tile below
        Hexagon hex = new Hexagon(tiles, 3, p);
    }

    public static void tessalation(TETile[][] tiles, Position p, int[] rows) {
        //start in bottom left
        //snake position values
        //3 - 4 - 5 - 4 - 3
        for (int a = 0; a < rows.length; a++) {
            if (rows[a] == 3) {
                for (int i = 0; i < rows[a]; i++) {
                    addHexagon(tiles, p);
                    if (rows[a] - 1 == i) {
                        p = p.topRight();
                    } else {
                        p = p.top();
                    }
                }
            }
            if (rows[a] == 4) {
                for (int i = 0; i < rows[a]; i++) {
                    addHexagon(tiles, p);
                    if (rows[a] - 1 == i) {
                        if (a < 2) {
                            p = p.bottomRight();
                        }
                        if (a >= 2) {
                            p = p.topRight();
                        }
                    }else {
                        p = p.bottom();
                    }
                }
            }
            if (rows[a] == 5) {
                for (int i = 0; i < rows[a]; i++) {
                    addHexagon(tiles, p);
                    if (rows[a] - 1 == i) {
                        p = p.bottomRight();
                    } else {
                        p = p.top();
                    }
                }
            }
        }

    }

}
