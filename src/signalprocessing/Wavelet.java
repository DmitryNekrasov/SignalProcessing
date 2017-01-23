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
    
    public static List<Double> getDaubechiesTransform(List<Double> signal) {
        List<Double> result = new ArrayList<>(signal);
        int n = signal.size();
        while (n >= 4) {
            double[][] matrix = getDaubechiesMatrix(n);
            multiply(matrix, result.subList(0, n));
            n /= 2;
        }
        return result;
    }
    
    public static List<Double> getDaubechiesInverseTransform(List<Double> signal) {
        List<Double> result = new ArrayList<>(signal);
        int n = 4;
        while (n <= signal.size()) {
            double[][] matrix = getTransformMatrix(getDaubechiesMatrix(n));
            multiply(matrix, result.subList(0, n));
            n *= 2;
        }
        return result;
    }
     
    public static List<Double> filterMinMax(List<Double> signal, int min, int max) {
        List<Double> result = new ArrayList<>(signal);
        for (int i = min, ei = Math.min(max, signal.size()); i < ei; i++) {
            result.set(i, 0.0);
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
    
    private static double[][] getDaubechiesMatrix(int n) {
        double[][] a = new double[n][n];
        double c0 = getC0();
        double c1 = getC1();
        double c2 = getC2();
        double c3 = getC3();
        for (int i = 0, ei = n / 2; i < ei; i++) {
            a[i][i * 2] = c0;
            a[i][i * 2 + 1] = c1;
            a[i][(i * 2 + 2) % n] = c2;
            a[i][(i * 2 + 3) % n] = c3;
            a[i + ei][i * 2] = c3;
            a[i + ei][i * 2 + 1] = -c2;
            a[i + ei][(i * 2 + 2) % n] = c1;
            a[i + ei][(i * 2 + 3) % n] = -c0;
        }
        return a;
    }
    
    private static double getC0() {
        return (1.0 + Math.sqrt(3.0)) / (4.0 * Math.sqrt(2.0));
    }
    
    private static double getC1() {
        return (3.0 + Math.sqrt(3.0)) / (4.0 * Math.sqrt(2.0));
    }
    
    private static double getC2() {
        return (3.0 - Math.sqrt(3.0)) / (4.0 * Math.sqrt(2.0));
    }
    
    private static double getC3() {
        return (1.0 - Math.sqrt(3.0)) / (4.0 * Math.sqrt(2.0));
    }
}
