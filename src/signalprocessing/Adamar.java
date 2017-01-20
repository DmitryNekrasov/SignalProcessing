/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.Arrays;

/**
 *
 * @author nekrasov
 */
public class Adamar {
    
    private final int N;
    private final int[][] W;
    
    public Adamar(int N, boolean isWalsh) {
        this.N = N;
        W = new int[N][N];
        if (isWalsh) {
            genWalsh();
        }
    }
    
    public int getW(int u, int v) {
        return W[u][v];
    }
    
    private void genWalsh() {
        int n = (int) log2(N);
        int[] r = new int[n];
        for (int u = 0; u < N; u++) {
            int mask = 1 << (n - 1);
            r[0] = (u & mask) == 0 ? 0 : 1;
            for (int i = 1; i < n; i++) {
                r[i] = (u & mask) == 0 ? 0 : 1;
                mask >>= 1;
                r[i] += (u & mask) == 0 ? 0 : 1;
                r[i] %= 2;
            }
            for (int v = 0; v < N; v++) {
                int sum = 0;
                int vTemp = v;
                for (int i = 0; i < n; i++) {
                    sum += r[i] * (vTemp & 1);
                    vTemp >>= 1;
                }
                W[u][v] = sum % 2 == 0 ? 1 : -1;
            }
        }
    }
    
    private double log2(double value) {
        return Math.log(value) / Math.log(2);
    }
    
    private void printW() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(W[i]));
        }
    }
}
