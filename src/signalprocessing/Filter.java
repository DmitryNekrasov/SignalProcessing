/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nekrasov
 */
public class Filter {
    
    private int N;
    private double fc;
    private List<Double> impulseResponse;
    private List<Double> transformation;
    private List<Double> frequencyResponse;
    private List<Double> logFrequencyResponse;

    public Filter(int N, double fc) {
        this.N = N;
        this.fc = fc;
        initImpulseResponse();
    }
    
    public List<Double> getImpulseResponse() {
        return impulseResponse;
    }
    
    private void initImpulseResponse() {
        impulseResponse = new ArrayList<>();
        int M = N - 1;
        for (int i = 0; i < N; i++) {
            double value;
            if (i == M / 2) {
                value = 2 * fc;
            } else {
                value = Math.sin(2 * Math.PI * fc * (i - M / 2)) / (Math.PI * (i - M / 2));
            }
            impulseResponse.add(value);
        }
    }
}
