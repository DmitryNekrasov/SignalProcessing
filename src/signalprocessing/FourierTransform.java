/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.complex.Complex;

/**
 *
 * @author nekrasov
 */
abstract public class FourierTransform {
    
    protected Complex[] transformResult;
    protected Complex[] inverseTransformResult;
    
    final void filterMin(int min) {
        filterMinMax(min, transformResult.length / 2);
    }
    
    final void filterMax(int max) {
        filterMinMax(0, max);
    }
    
    final void filterMinMax(int min, int max) {
        int n = transformResult.length;
        for (int i = min; i < max; i++) {
            transformResult[i] = null;
            transformResult[i] = new Complex(0);
        }
        for (int i = n - max - 1; i < n - min; i++) {
            transformResult[i] = null;
            transformResult[i] = new Complex(0);
        }
    }
    
    final protected Complex[] generateComplexArray(List<Double> signal) {
        Complex[] x = new Complex[signal.size()];
        int ptr = 0;
        for (double value : signal) {
            x[ptr++] = new Complex(value);
        }
        return x;
    }
    
    final protected Complex getW(double k, int n, boolean invert) {
        double arg = 2 * Math.PI * k / n * (invert ? -1 : 1);
        return new Complex(Math.cos(arg), Math.sin(arg));
    }
    
    final public List<Double> getModuleList() {
        List<Double> module = new ArrayList<>();
        for (Complex value : transformResult) {
            double x = value.getReal();
            double y = value.getImaginary();
            module.add(Math.sqrt(x * x + y * y));
        }
        return module;
    }
    
    abstract public List<Double> getIftList();
}
