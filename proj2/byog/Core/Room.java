package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class Room {

    private TETile[][] tile;
    private int width;
    private int height;
    private Position p;

    public Room(TETile[][] tiles, int width, int height, Position p) {
        tile = tiles;
        this.width = width;
        this.height = height;
        this.p = p;
        createRoom(tile);
    }

    public void createRoom(TETile[][] tiles) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x + p.getX()][y + p.getY()] = Tileset.FLOOR;
            }
        }
    }

    public int centreX() {
        return (width / 2) + p.getX();
    }

    public int centreY() {
        return (height / 2) + p.getY();
    }



}
