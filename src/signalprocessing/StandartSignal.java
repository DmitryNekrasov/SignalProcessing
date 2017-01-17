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
abstract public class StandartSignal {
    
    protected final double A;
    protected final double T;
    private final int N;
    
    public StandartSignal(double A, double T, int N) {
        this.A = A;
        this.T = T;
        this.N = N;
    }
    
    final public List<Double> getSignal() {
        List<Double> signal = new ArrayList<>();
        double step = (double) T / N;
        for (int i = 0; i < N; i++) {
            double value = getFunctionValue(step * i);
            signal.add(value);
        }
        return signal;
    }
    
    final protected double getModX(double x) {
        int n = (int) ((Math.abs(x) + T / 2) / T);
        return x - Math.signum(x) * n * T;
    }
    
    abstract protected double getFunctionValue(double x);
}
