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
 * @author ScanNorOne
 */
public class IIRFilter {
    
    private static final double w0 = 1;
    
    public static List<Double> getButterworthFR(int n, int m) {
        List<Double> result = new ArrayList<>();
        double step = Math.PI / m;
        for (int i = 0; i < m; i++) {
            double value = getButterworthValue(step * i, w0, n);
            result.add(value);
        }
        return result;
    }
    
    public static List<Double> getChebyshevOneFR(int n, int m, double e) {
        List<Double> result = new ArrayList<>();
        double step = Math.PI / m;
        for (int i = 0; i < m; i++) {
            double value = getChebyshevOneValue(step * i, w0, e, n);
            result.add(value);
        }
        return result;
    }
    
    public static List<Double> getChebyshevTwoFR(int n, int m, double e) {
        List<Double> result = new ArrayList<>();
        double step = Math.PI / m;
        for (int i = 0; i < m; i++) {
            double value = getChebyshevTwoValue(step * i, w0, e, n);
            result.add(value);
        }
        return result;
    }
    
    private static double getButterworthValue(double w, double w0, int n) {
        return 1.0 / Math.sqrt(1 + Math.pow(w / w0, 2 * n));
    }
    
    private static double getChebyshevOneValue(double w, double w0, double e, int n) {
        double t = getT(n, w / w0);
        return 1.0 / Math.sqrt(1 + e * e * t * t);
    }
    
    private static double getChebyshevTwoValue(double w, double w0, double e, int n) {
        double t = getT(n, w0 / w);
        return 1.0 / Math.sqrt(1 + 1.0 / (e * e * t * t));
    }
    
    private static double getT(int n, double x) {
        double[] t = new double[n + 1];
        t[0] = 1;
        t[1] = x;
        for (int i = 2; i <= n; i++) {
            t[i] = 2 * x * t[i - 1] - t[i - 2];
        }
        return t[n];
    }
}
