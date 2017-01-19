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
    private final int M;
    private final double fc;
    private final double step;
    
    private List<Double> impulseResponse;
    private List<Double> frequencyResponse;
    private List<Double> logFrequencyResponse;

    public static enum Name {
        Rectangular,
        Hamming,
        Bartlett,
        Hanning,
        Blackman
    }
    
    public Filter(int N, double fc, double step, Name name, boolean isHigh) {
        this.N = N;
        M = N - 1;
        this.fc = fc;
        this.step = step;
        initImpulseResponse(name, isHigh);
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
    
    private void initImpulseResponse(Name name, boolean isHigh) {
        impulseResponse = new ArrayList<>();
        double[] w = getW(M, name);
        for (int i = 0; i < M; i++) {
            double value;
            if (i == M / 2) {
                value = isHigh ? 1 - 2 * fc : 2 * fc;
            } else {
                value = (isHigh ? -1 : 1) * Math.sin(2 * Math.PI * fc * (i - M / 2)) / (Math.PI * (i - M / 2));
            }
            impulseResponse.add(value * w[i]);
        }
    }
    
    private double[] getW(int size, Name name) {
        double[] w = new double[size];
        switch (name) {
            case Rectangular:
                for (int i = 0; i < size; i++) {
                    w[i] = 1;
                }
                break;
            case Hamming:
                for (int i = 0; i < size; i++) {
                    w[i] = getHammingValue(i);
                }
                break;
            case Bartlett:
                for (int i = 0; i < size; i++) {
                    w[i] = getBartlettValue(i);
                }
                break;
            case Hanning:
                for (int i = 0; i < size; i++) {
                    w[i] = getHanningValue(i);
                }
                break;
            default:
                for (int i = 0; i < size; i++) {
                    w[i] = getBlackmanValue(i);
                }
        }
        return w;
    }
    
    private double getHammingValue(int i) {
        return 0.54 - 0.46 * Math.cos(2 * Math.PI * i / M);
    }
    
    private double getBartlettValue(int i) {
        return 1 - (double) (2 * Math.abs(i - M / 2)) / M;
    }
    
    private double getHanningValue(int i) {
        return 0.5 - 0.5 * Math.cos(2 * Math.PI * i / M);
    }
    
    private double getBlackmanValue(int i) {
        return 0.42 - 0.5 * Math.cos(2 * Math.PI * i / M) + 0.08 * Math.cos(4 * Math.PI * i / M);
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
