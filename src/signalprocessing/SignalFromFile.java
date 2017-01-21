/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.io.*;
import java.util.*;

/**
 *
 * @author ScanNorOne
 */
public class SignalFromFile {

    private List<Double> signal;
    
    private BufferedReader in;
    private StringTokenizer st;
    
    public SignalFromFile(String fileName) {
        try {
            in = new BufferedReader(new FileReader(new File(fileName)));
            st = new StringTokenizer("");
            readSignal();
            in.close();
        } catch (IOException ex) {
            System.err.println("Не удалось открыть файл с сигналом");
        }
    }
    
    public List<Double> getSignal() {
        int highestOneBit = Integer.highestOneBit(signal.size());
        return signal.subList(0, highestOneBit);
    }
    
    private void readSignal(){
        try {
            signal = new ArrayList<>();
            while (!EOF()) {
                double value = nextDouble();
                signal.add(value);
            }
        } catch (IOException ex) {
            System.err.println("Не удалось прочитать файл с сигналом");
        }
    }
    
    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
    
    private String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    
    private boolean EOF() throws IOException {
        while (!st.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return true;
            }
            st = new StringTokenizer(s);
        }
        return false;
    }
}
