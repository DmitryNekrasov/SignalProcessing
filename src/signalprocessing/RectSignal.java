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
public class RectSignal extends StandartSignal {

    private final double tau;
    
    public RectSignal(double A, double T, int N, double tau) {
        super(A, T, N);
        this.tau = tau;
    }

    @Override
    protected double getFunctionValue(final double x) {
        double modX = getModX(x);
        return modX > -tau / 2 && modX < tau / 2 ? A : 0;
    }
    
}
