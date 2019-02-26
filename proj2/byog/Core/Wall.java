package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class Wall {

    private TETile[][] tile;
    private int width;
    private int height;

    public Wall(TETile[][] tiles, int width, int height) {
        tile = tiles;
        this.width = width;
        this.height = height;
        createWall(tile);
    }

    public void createWall(TETile[][] tiles) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tiles[x][y] == Tileset.NOTHING && checkFloor(tiles, x, y)) {
                    tiles[x][y] = Tileset.WALL;
                }
            }
        }
    }

    //create situations for border tiles
    public boolean checkFloor(TETile[][] tiles, int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i > -1 && j > -1 && i < width && j < height) {
                    if (tiles[i][j] == Tileset.FLOOR && i != x && j != y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
