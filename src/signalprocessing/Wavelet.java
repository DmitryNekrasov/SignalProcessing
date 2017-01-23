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
public class Wavelet {
    
    public static double[][] getHaarMatrix(int n) {
        double[][] a = new double[n][n];
        double value = 1.0 / Math.sqrt(2);
        for (int i = 0, ei = n / 2; i < ei; i++) {
            a[i][i * 2] = value;
            a[i][i * 2 + 1] = value;
            a[i + ei][i * 2] = value;
            a[i + ei][i * 2 + 1] = -value;
        }
        return a;
    }
    
}
