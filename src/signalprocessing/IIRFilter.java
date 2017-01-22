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
    
    private static double getButterworthValue(double w, double w0, int n) {
        return 1.0 / Math.sqrt(1 + Math.pow(w / w0, 2 * n));
    }
}
