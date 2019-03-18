/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

package percolation;

import edu.princeton.cs.algs4.StdRandom;
import java.util.List;
import java.util.ArrayList;

public class PercolationStats {

    private List<Double> list;

    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new java.lang.IllegalArgumentException();
        }
        list = new ArrayList<>();
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);
                p.open(x, y);
            }
            list.add((double) p.numberOfOpenSites() / (n*n));
        }
        System.out.println("mean = " + mean());
        System.out.println("stddev = " + stddev());
        System.out.println("95% confidence interval = " + confidenceLo() + ", " + confidenceHi());
    }

    public double mean() {
        double sum = 0;
        for (double d : list) {
            sum += d;
        }
        return sum / list.size();
    }

    public double stddev() {
        double partialSum = 0;
        for (double d : list) {
            partialSum += Math.pow(d - mean(), 2);
        }
        return Math.sqrt(partialSum / (list.size() - 1));
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(list.size());
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(list.size());
    }

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(200, 100);
    }


}
