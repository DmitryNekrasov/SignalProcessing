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
public class Filter {
    
    private final int N;
    private final double fc;
    private final double step;
    private List<Double> impulseResponse;
    private List<Double> frequencyResponse;
    private List<Double> logFrequencyResponse;

    public Filter(int N, double fc, double step) {
        this.N = N;
        this.fc = fc;
        this.step = step;
        initImpulseResponse();
        initFrequencyResponse();
        initLogFrequencyResponse();
    }
    
    public List<Double> getImpulseResponse() {
        return impulseResponse;
    }
    
    public List<Double> getFrequencyResponse() {
        return frequencyResponse;
    }
    
    public List<Double> getLogFrequencyResponse() {
        return logFrequencyResponse;
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
    
    private void initFrequencyResponse() {
        FourierTransform dft = new DiscreteFourierTransform(impulseResponse, step);
        frequencyResponse = dft.getModuleList();
    }
    
    private void initLogFrequencyResponse() {
        logFrequencyResponse = new ArrayList<>();
        for (double value : frequencyResponse) {
            double logValue = 20 * Math.log10(value);
            logFrequencyResponse.add(logValue);
        }
    }
}
