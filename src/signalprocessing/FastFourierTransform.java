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
public class FastFourierTransform {
    
    private Complex[] result;
    
    public FastFourierTransform(List<Double> signal) {
        if (isPow2(signal.size())) {
            Complex[] x = generateComplexArray(signal);
            result = divideBySize(fft(x));
        } else {
            throw new RuntimeException("Размер сигнала не является степенью двойки");
        }
    }
    
    public List<Double> getModuleList() {
        List<Double> module = new ArrayList<>();
        
        for (Complex value : result) {
            double x = value.getReal();
            double y = value.getImaginary();
            module.add(Math.sqrt(x * x + y * y));
        }
        
        return module;
    }
    
    private Complex[] generateComplexArray(List<Double> signal) {
        Complex[] x = new Complex[signal.size()];
        int ptr = 0;
        for (double value : signal) {
            x[ptr++] = new Complex(value);
        }
        return x;
    }
    
    private Complex[] divideBySize(Complex[] x) {
        Complex[] X = new Complex[x.length];
        for (int i = 0, ei = x.length; i < ei; i++) {
            X[i] = x[i].divide((double) ei);
        }
        return X;
    }
    
    private Complex[] fft(Complex[] x) {
        Complex[] X;
        int n = x.length;
        if (n == 2) {
            X = new Complex[2];
            X[0] = x[0].add(x[1]);
            X[1] = x[0].subtract(x[1]);
        } else {
            Complex[] xEven = new Complex[n / 2];
            Complex[] xOdd = new Complex[n / 2];
            for (int i = 0; i < n / 2; i++) {
                xEven[i] = x[2 * i];
                xOdd[i] = x[2 * i + 1];
            }
            Complex[] XEven = fft(xEven);
            Complex[] XOdd = fft(xOdd);
            X = new Complex[n];
            for (int i = 0; i < n / 2; i++) {
                X[i] = XEven[i].add(getW(i, n).multiply(XOdd[i]));
                X[i + n / 2] = XEven[i].subtract(getW(i, n).multiply(XOdd[i]));
            }
        }
        
        return X;
    }
    
    private Complex getW(int k, int n) {
        if (k % n == 0) {
            return new Complex(1);
        }
        double arg = -2 * Math.PI * k / n;
        return new Complex(Math.cos(arg), Math.sin(arg));
    }
    
    private boolean isPow2(int x) {
        return (x & (x - 1)) == 0;
    }
    
}
