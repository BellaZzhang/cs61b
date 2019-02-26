package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

//create floor first
//rooms (at least 2x2)
//connect doors by closeness through paths(must be to other rooms)
//calculate distance between doors(must decrease as path builds)
//paths (1x1 tile size only)
//paths must be connected to at least one other floor horizontally or vertically

public class GenerateWorld {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 40;
    private List<Room> list;
    private Player player;

    public GenerateWorld(int seed) {
        Random random = new Random();
        int number = random.nextInt(5) + 5;
        list = new ArrayList<>();
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] tiles = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
        createRooms(tiles, number, seed);
        createPaths(tiles, number);
        createWalls(tiles);
        createPlayer(tiles, random);
        ter.renderFrame(tiles);
        while (true) {
            player.move();
            ter.renderFrame(tiles);
        }
    }

    public void createRooms(TETile[][] tiles, int number, int seed) {
        Random random;
        for (int i = 0; i < number; i++) {
            if (seed == 0) {
                random = new Random();
            } else {
                random = new Random(seed);
            }
            int width = random.nextInt(7) + 2;
            int height  = random.nextInt(7) + 2;
            Position p = new Position(random.nextInt(57) + 2, random.nextInt(37) + 2);
            while(!roomOutOfBounds(p, width, height)) {
                p = new Position(random.nextInt(57) + 2, random.nextInt(37) + 2);
            }
            Room r = new Room(tiles, width, height, p);
            list.add(r);
        }
    }

    public boolean roomOutOfBounds(Position p, int width, int height) {
        if (p.getX() + width >= WIDTH) {
            return false;
        } if (p.getY() + height >= HEIGHT) {
            return false;
        }
        return true;
    }

    public void createPaths(TETile[][] tiles, int number) {
        for (int i = 0; i < number - 1; i++) {
            new Path(tiles, list.get(i), list.get(i + 1));
        }
    }

    public void createWalls(TETile[][] tiles) {
        new Wall(tiles, WIDTH, HEIGHT);
    }

    public void createPlayer(TETile[][] tiles, Random random) {
        while (true) {
            Position p = new Position(random.nextInt(57) + 2, random.nextInt(37) + 2);
            if (tiles[p.getX()][p.getY()] == Tileset.FLOOR) {
                player = new Player(tiles, p);
                break;
            }
        }
    }

}
