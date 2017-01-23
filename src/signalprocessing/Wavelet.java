/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nekrasov
 */
public class Wavelet {
    
    public static List<Double> getHaarTransform(List<Double> signal) {
        List<Double> result = new ArrayList<>(signal);
        int n = signal.size();
        while (n >= 2) {
            double[][] matrix = getHaarMatrix(n);
            multiply(matrix, result.subList(0, n));
            n /= 2;
        }
        
        return result;
    }
    
    public static List<Double> getHaarInverseTransform(List<Double> signal) {
        List<Double> result = new ArrayList<>(signal);
        int n = 2;
        while (n <= signal.size()) {
            double[][] matrix = getTransformMatrix(getHaarMatrix(n));
            multiply(matrix, result.subList(0, n));
            n *= 2;
        }
        return result;
    }
    
    private static double[][] getHaarMatrix(int n) {
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
    
    private static double[][] getTransformMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
    
    private static void multiply(double[][] matrix, List<Double> vector) {
        int n = vector.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += matrix[i][j] * vector.get(j);
            }
        }
        for (int i = 0; i < n; i++) {
            vector.set(i, result[i]);
        }
    }
}
