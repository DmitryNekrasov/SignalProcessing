/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

/**
 *
 * @author nekrasov
 */
public class Filter {
    
    private int N;
    private double fc;
    private double[] h;

    public Filter(int N, double fc) {
        this.N = N;
        this.fc = fc;
        initH();
    }
    
    private void initH() {
        h = new double[N];
        int M = N - 1;
        for (int i = 0; i < N; i++) {
            if (i == M / 2) {
                h[i] = 2 * fc;
            } else {
                h[i] = Math.sin(2 * Math.PI * fc * (i - M / 2)) / (Math.PI * (i - M / 2));
            }
        }
    }
}
