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
public class TriangleSignal extends StandartSignal {

    public TriangleSignal(double A, double T, int N) {
        super(A, T, N);
    }

    @Override
    protected double getFunctionValue(final double x) {
        return -Math.abs(4 * A * getModX(x) / T) + A;
    }
    
}
