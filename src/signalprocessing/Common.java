/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.util.List;
import org.knowm.xchart.XYChart;

/**
 *
 * @author nekrasov
 */
public class Common {
    
    public static void updateChart(XYChart chart, List<Double> x, List<Double> y, String seriesName) {
        chart.updateXYSeries(seriesName, x, y, null);
    }
    
}
