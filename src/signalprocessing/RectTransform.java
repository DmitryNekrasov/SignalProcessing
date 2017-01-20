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
public class RectTransform {
    
    private final boolean isWalsh;
    private final boolean inverse;
    private final List<Double> transformation;

    public RectTransform(List<Double> signal, boolean isWalsh, boolean inverse) {
        this.isWalsh = isWalsh;
        this.inverse = inverse;
        transformation = transform(signal);
    }
    
    public List<Double> getAmplitude() {
        List<Double> result = new ArrayList<>();
        for (int i = 0, ei = transformation.size() / 2; i < ei; i++) {
            double value = Math.sqrt(transformation.get(i + 1) * transformation.get(i + 1) + 
                    transformation.get(i + 2) * transformation.get(i + 2));
            result.add(value);
        }
        return result;
    }
    
    public List<Double> getTransformation() {
        return transformation;
    }
    
    private List<Double> transform(List<Double> signal) {
        int n = signal.size();
        Adamar adamar = new Adamar(n, isWalsh);
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += signal.get(j) * adamar.getW(i, j);
            }
            if (inverse) {
                sum /= n;
            }
            result.add(sum);
        }
        return result;
    }
}
