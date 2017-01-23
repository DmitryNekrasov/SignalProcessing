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
public class DiscreteFourierTransform extends FourierTransform {

    public DiscreteFourierTransform(List<Double> signal, double step) {
        Complex[] x = generateComplexArray(signal);
        transformResult = dft(x, step);
    }

    @Override
    public List<Double> getIftList() {
        throw new UnsupportedOperationException("Обратное преобразование Фурье в классе DiscreteFourierTransform не реализовано");
    }
    
    private Complex[] dft(Complex[] x, double step) {
        int n = x.length;
        int size = (int) (n / step);
        Complex[] res = new Complex[size];
        for (int i = 0; i < size; i++) {
            Complex sum = Complex.ZERO;
            for (int k = 0; k < n; k++) {
                sum = sum.add(getW(k * i * step, n, false).multiply(x[k]));
            }
            res[i] = sum;
        }
        return res;
    }
}
