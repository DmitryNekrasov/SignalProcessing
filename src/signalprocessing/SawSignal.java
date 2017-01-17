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
public class SawSignal extends StandartSignal {

    public SawSignal(double A, double T, int N) {
        super(A, T, N);
    }

    @Override
    protected double getFunctionValue(double x) {
        return getModX(x) * 2 * A / T;
    }
    
}
