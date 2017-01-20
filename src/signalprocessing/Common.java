/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.XYChart;

/**
 *
 * @author nekrasov
 */
public class Common {
    
    public static void updateSignalChart(XYChart chart, List<Double> signal, double sampleRate, String seriesName) {
        int fragmentSize = signal.size();
        
        List<Double> x = new ArrayList<>();
        double step = 1.0 / sampleRate;
        for (int i = 0; i < fragmentSize; i++) {
            x.add(i * step);
        }
        
        Common.updateChart(chart, x, signal, seriesName);
    }
    
    public static void updateChart(XYChart chart, List<Double> x, List<Double> y, String seriesName) {
        chart.updateXYSeries(seriesName, x, y, null);
    }
    
}
