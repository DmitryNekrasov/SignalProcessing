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
public class FastFourierTransform extends FourierTransform {
    
    public FastFourierTransform(List<Double> signal) {
        Complex[] x = generateComplexArray(signal);
        if (isPow2(signal.size())) {
            transformResult = fft(x, false);
        } else {
            transformResult = fftRandomN(x, false);
        }
    }
    
    @Override
    public List<Double> getIftList() {
        if (isPow2(transformResult.length)) {
            inverseTransformResult = fft(transformResult, true);
        } else {
            inverseTransformResult = fftRandomN(transformResult, true);
        }
        List<Double> ret = new ArrayList<>();
        for (Complex value : inverseTransformResult) {
            ret.add(value.getReal());
        }
        return ret;
    }
    
    private Complex[] divideBySize(Complex[] x) {
        Complex[] X = new Complex[x.length];
        for (int i = 0, ei = x.length; i < ei; i++) {
            X[i] = x[i].divide((double) ei);
        }
        return X;
    }
    
    private Complex[] multiplyBySize(Complex[] x) {
        Complex[] X = new Complex[x.length];
        for (int i = 0, ei = x.length; i < ei; i++) {
            X[i] = x[i].multiply((double) ei);
        }
        return X;
    }
    
    private Complex[] fftRandomN(Complex[] x, boolean invert) {
        int N = x.length;
        int[] tmpMLArray = getML(N);
        int M = tmpMLArray[0];
        int L = tmpMLArray[1];
        
        Complex[] partialResult = new Complex[N];
        for (int i = 0; i < M; i++) {
            Complex[] tmpF = new Complex[L];
            for (int j = 0; j < L; j++) {
                tmpF[j] = x[i + j * M];
            }
            tmpF = fft(tmpF, invert);
            for (int j = 0; j < L; j++) {
                partialResult[i + j * M] = tmpF[j];
            }
        }
        
        Complex[] F = new Complex[N];
        for (int s = 0; s < M; s++) {
            for (int r = 0; r < L; r++) {
                F[r + s * L] = new Complex(0);
                for (int m = 0; m < M; m++) {
                    double arg = 2 * Math.PI * m * (r + s * L) / N * (invert ? -1 : 1);
                    Complex factor = new Complex(Math.cos(arg), Math.sin(arg));
                    Complex newF = F[r + s * L].add(partialResult[m + r * M].multiply(factor));
                    F[r + s * L] = newF;
                }
            }
        }
        
        if (invert) {
            for (int i = 0; i < N; i++) {
                F[i] = F[i].divide(M);
            }
        }
        
        return F;
    }
    
    private int[] getML(int n) {
        int m = 3;
        int l;
        while (true) {
            if (n % m == 0) {
                l = n / m;
                if (isPow2(l)) {
                    break;
                }
            }
            m++;
        }
        return new int[] {m, l};
    }
    
    private Complex[] fft(Complex[] x, boolean invert) {
        Complex[] X;
        int n = x.length;
        if (n == 2) {
            X = new Complex[2];
            X[0] = x[0].add(x[1]).divide(invert ? 2 : 1);
            X[1] = x[0].subtract(x[1]).divide(invert ? 2 : 1);
        } else {
            Complex[] xEven = new Complex[n / 2];
            Complex[] xOdd = new Complex[n / 2];
            for (int i = 0; i < n / 2; i++) {
                xEven[i] = x[2 * i];
                xOdd[i] = x[2 * i + 1];
            }
            Complex[] XEven = fft(xEven, invert);
            Complex[] XOdd = fft(xOdd, invert);
            X = new Complex[n];
            for (int i = 0; i < n / 2; i++) {
                X[i] = XEven[i].add(getW(i, n, invert).multiply(XOdd[i]));
                X[i + n / 2] = XEven[i].subtract(getW(i, n, invert).multiply(XOdd[i]));
                if (invert) {
                    X[i] = X[i].divide(2);
                    X[i + n / 2] = X[i + n / 2].divide(2);
                }
            }
        }
        
        return X;
    }
    
    private boolean isPow2(int x) {
        return (x & (x - 1)) == 0;
    }
    
}
