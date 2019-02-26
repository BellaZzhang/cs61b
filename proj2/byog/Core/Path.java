package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class Path {

    private TETile[][] tile;
    private Room r1;
    private Room r2;
    private int h = 0;

    public Path(TETile[][] tiles, Room r1, Room r2) {
        tile = tiles;
        this.r1 = r1;
        this.r2 = r2;
        createPath(tile);
    }

    public void createPath(TETile[][] tiles) {
        if (r1.centreX() < r2.centreX()) {
            pathX(tiles, r1);
        }
        if (r2.centreX() < r1.centreX()) {
            pathX(tiles, r2);
        }
        if (r1.centreY() < r2.centreY()) {
            pathY(tiles, r1);
        }
        if (r2.centreY() < r1.centreY()) {
            pathY(tiles, r2);
        }

    }

    public void pathX(TETile[][] tiles, Room r) {
        for (int x = 0; x < Math.abs(r1.centreX() - r2.centreX()); x++) {
            tiles[x + r.centreX()][r.centreY()] = Tileset.FLOOR;
            h = x + r.centreX();
        }
    }

    public void pathY(TETile[][] tiles, Room r) {
        for (int y = 0; y < Math.abs(r1.centreY() - r2.centreY()); y++) {
            tiles[h][y + r.centreY()] = Tileset.FLOOR;
        }
    }

}
