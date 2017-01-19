/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

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
    
    abstract public List<Double> getModuleList();
    abstract public List<Double> getIftList();
}
