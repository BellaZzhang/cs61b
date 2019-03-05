package hw2;

import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {

    private int mean[];
    private int T;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        this.T = T;
        mean = new int[T];
        for (int i = 0; i < T; i++) {
            pf.start();
            mean[i] = pf.percolationThreshhold();
        }
    }

    public double mean() {
        System.out.println(StdStats.mean(mean));
        return StdStats.mean(mean);
    }

    public double stddev() {
        System.out.println(StdStats.stddev(mean));
        return StdStats.stddev(mean);
    }

    public double confidenceLow() {
        double lowC = mean() - (1.96 * Math.sqrt(stddev()))/Math.sqrt(T);
        System.out.println(lowC);
        return lowC;
    }

    public double confidenceHigh() {
        double highC = mean() + (1.96 * Math.sqrt(stddev()))/Math.sqrt(T);
        System.out.println(highC);
        return highC;
    }

}
