/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf;
    private int N;
    private boolean node[];
    private int top;
    private int bottom;
    private int openNodes;

    //n^2
    //initialize n by n grid
    //all nodes blocked
    public Percolation(int n) {
        uf= new WeightedQuickUnionUF(n * n + 2);
        N = n;
        node = new boolean[n * n + 2];
        openNodes = 0;
        top = 0;
        bottom = n * n + 1;
        node[top] = true;
        node[bottom] = true;
        for (int i = 1; i <= n; i++) {
            uf.union(top, i);
        }

    }

  /*0
    1  2  3  4  5
    6  7  8  9  10
    11 12 13 14 15
    16 17 18 19 20
    21 22 23 24 25
    26*/

    //open a node if blocked
    //union to surrounding open nodes
    public void open(int row, int col) {
        int p = getNode(row, col);
        if (!node[p]) {
            node[p] = true;
            int left = p - 1,
                    right = p + 1,
                    up = p - N,
                    down = p + N;
            connectSurrounding(p, left, right, up, down);
            openNodes++;
        }
    }

    public boolean valid(int i) {
        return i > 0 && i < N * N;
    }

    public int getNode(int row, int col) {
        return col + (row - 1) * N;
    }

    public void connectSurrounding(int p, int... d) {
        if (node[d[0]] && d[0] % N != 0) {
            uf.union(p, p - 1);
        }
        if (node[d[1]] && p % N != 0) {
            uf.union(p, p + 1);
        }
        if (valid(d[2])) {
            if (node[d[2]] && d[2] > -1) {
                uf.union(p, p - N);
            }
        }
        if (valid(d[3])) {
            if (node[d[3]] && d[3] < N * N) {
                uf.union(p, p + N);
            }
        }
    }

    //check if open
    public boolean isOpen(int row, int col) {
        return node[getNode(row, col)];
    }

    //check if connected to top
    public boolean isFull(int row, int col) {
        return uf.connected(top, getNode(row, col)) && node[getNode(row, col)];
    }

    //return total open, including full
    public int numberOfOpenSites() {
        return openNodes;
    }

    //check top connected to bottom
    public boolean percolates() {
        for (int i = 0; i < N; i++) {
            if(uf.connected(top, N * N - i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
