package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[] opened;
    private int top;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF uf;
    private int openSites = 0;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        size = N;
        top = N * N;
        bottom = top + 1;
        uf = new WeightedQuickUnionUF(top + 2);
        opened = new boolean[N * N + 2];
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        int index = gridToIndex(row, col),
                left = index - 1,
                right = index + 1,
                up = index - size,
                down = index + size;
        opened[index] = true;
        if (row == 0) {
            uf.union(index, top);
        }
        openSites++;
        connectIfOpened(index, left, right, up, down);
    }

    public void connectIfOpened(int index, int... others) {
        if (index % size == 0) {
            for (int i = 1; i < 4; i++) {
                if (checkIndex(others[i])) {
                    if (opened[others[i]]) {
                        uf.union(index, others[i]);
                    }
                }
            }
        }
        if ((index + 1) % size == 0) {
            for (int i = 2; i < 4; i++) {
                if (checkIndex(others[i])) {
                    if (opened[others[i]]) {
                        uf.union(index, others[i]);
                    }
                }
            }
            if (checkIndex(others[0])) {
                if (opened[others[0]]) {
                    uf.union(index, others[0]);
                }
            }
        }
        if (index % size != 0 && (index + 1) % size != 0) {
            for (int i = 0; i < 4; i++) {
                if (checkIndex(others[i])) {
                    if (opened[others[i]]) {
                        uf.union(index, others[i]);
                    }
                }
            }
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return opened[gridToIndex(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return uf.connected(gridToIndex(row, col), top);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int i = size * (size - 1); i < top; i++) {
            if (uf.connected(top, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIndex(int index) {
        return index > -1 && index < (top + 2);
    }

    public int gridToIndex(int x, int y) {
        return y + x * size;
    }

    // use for unit testing (not required)
    public static void main(String[] args) {

    }


}
