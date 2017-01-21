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
    
    private final boolean inverse;
    private final Adamar adamar;
    private final List<Double> transformation;

    public RectTransform(List<Double> signal, Adamar adamar, boolean inverse) {
        this.inverse = inverse;
        this.adamar = adamar;
        transformation = transform(signal);
    }
    
    public List<Double> getAmplitude() {
        List<Double> result = new ArrayList<>();
        result.add(transformation.get(0));
        for (int i = 0, ei = transformation.size() / 2 - 1; i < ei; i++) {
            double value = Math.sqrt(transformation.get(i * 2 + 1) * transformation.get(i * 2 + 1) + 
                    transformation.get(i * 2 + 2) * transformation.get(i * 2 + 2));
            result.add(value);
        }
        result.add(transformation.get(transformation.size() / 2));
        return result;
    }
    
    public List<Double> getPhase() {
        List<Double> result = new ArrayList<>();
        result.add(0.0);
        for (int i = 0, ei = transformation.size() / 2 - 1; i < ei; i++) {
            double value = Math.atan2(transformation.get(i * 2 + 1), transformation.get(i * 2 + 2));
            result.add(value);
        }
        result.add(Math.PI / 2);
        return result;
    }
    
    public List<Double> getTransformation() {
        return transformation;
    }
    
    final void filterMinMax(int min, int max) {
        int n = transformation.size();
        for (int i = min; i < max; i++) {
            transformation.set(i, 0.0);
        }
        for (int i = n - max - 1; i < n - min; i++) {
            transformation.set(i, 0.0);
        }
    }
    
    private List<Double> transform(List<Double> signal) {
        int n = signal.size();
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
