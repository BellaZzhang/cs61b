package byog.lab5;

public class Position {

    private int x;
    private int y;
    private int size;

    public Position(int x, int y, int s) {
        this.x = x;
        this.y = y;
        size = s;
    }

    public Position top() {
        return new Position(x, y + size * 2, size);
    }

    public Position bottom() {
        return new Position(x, y - size * 2, size);
    }

    public Position topRight() {
        return new Position(x + size * 2 - 1, y + size, size);
    }

    public Position bottomRight() {
        return new Position(x + size * 2 - 1, y - size, size);
    }

    public int xPos() {
        return x;
    }

    public int yPos() {
        return y;
    }
}
