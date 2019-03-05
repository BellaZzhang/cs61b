package hw2;

import java.util.Random;

public class PercolationFactory {

    private Random random;
    private int size;
    private Percolation p;
    private PercolationVisualizer pv;

    public Percolation make(int N) {
        size = N;
        return new Percolation(N);
    }

    public void start() {
        random = new Random();
        p = make(size);
        pv = new PercolationVisualizer();
        pv.draw(p, size);
        while (!p.percolates()) {
            openRandom();
        }

    }

    public void openRandom() {
        int Xpos = random.nextInt(size);
        int Ypos = random.nextInt(size);
        if (!p.isOpen(Xpos, Ypos)) {
            p.open(Xpos, Ypos);
        }
        pv.draw(p, size);
    }

    public int percolationThreshhold() {
        return p.numberOfOpenSites() / (size * size);
    }
}
