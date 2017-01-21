/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XYChart;

/**
 *
 * @author nekrasov
 */
public class Lab02JFrame extends javax.swing.JFrame {

    private final String filePath = "c:\\Users\\nekrasov\\Desktop\\";
    
    final int SAW_INDEX = 3;
    
    XYChart signalChart, fftChart, iftChart;
    final String seriesName = "y(x)";
    
    Lab02SupportingJFrame supportingFrame;
    
    /**
     * Creates new form Lab02JFrame
     */
    public Lab02JFrame() {
        initComponents();
        
        signalChart = QuickChart.getChart("", "", "", seriesName, new double[1], new double[1]);
        fftChart = QuickChart.getChart("", "", "", seriesName, new double[1], new double[1]);
        iftChart = QuickChart.getChart("", "", "", seriesName, new double[1], new double[1]);
        
        setSawParamsEnabled(false);
        setFilterEnabled(false);
        
        supportingFrame = new Lab02SupportingJFrame();
        supportingFrame.setVisible(true);
        supportingFrame.setTitle("Фильтрация");
        
        filterButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        signalPanel = new javax.swing.JPanel();
        fftPanel = new javax.swing.JPanel();
        fragmentSizeTextField = new javax.swing.JTextField();
        fragmentSizeLabel = new javax.swing.JLabel();
        signalLabel = new javax.swing.JLabel();
        signalComboBox = new javax.swing.JComboBox<>();
        ALabel = new javax.swing.JLabel();
        ATextField = new javax.swing.JTextField();
        TLabel = new javax.swing.JLabel();
        NLabel = new javax.swing.JLabel();
        NTextField = new javax.swing.JTextField();
        TTextField = new javax.swing.JTextField();
        iftPanel = new javax.swing.JPanel();
        filterLabel = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox<>();
        minLabel = new javax.swing.JLabel();
        minTextField = new javax.swing.JTextField();
        maxLabel = new javax.swing.JLabel();
        maxTextField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        filterNLabel = new javax.swing.JLabel();
        filterNTextField = new javax.swing.JTextField();
        filterFcLabel = new javax.swing.JLabel();
        filterFcTextField = new javax.swing.JTextField();
        windowLabel = new javax.swing.JLabel();
        windowComboBox = new javax.swing.JComboBox<>();
        highFrequencyCheckBox = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("Старт");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout signalPanelLayout = new javax.swing.GroupLayout(signalPanel);
        signalPanel.setLayout(signalPanelLayout);
        signalPanelLayout.setHorizontalGroup(
            signalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        signalPanelLayout.setVerticalGroup(
            signalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout fftPanelLayout = new javax.swing.GroupLayout(fftPanel);
        fftPanel.setLayout(fftPanelLayout);
        fftPanelLayout.setHorizontalGroup(
            fftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fftPanelLayout.setVerticalGroup(
            fftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        fragmentSizeTextField.setText("131072");
        fragmentSizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fragmentSizeTextFieldActionPerformed(evt);
            }
        });

        fragmentSizeLabel.setText("Размер фрагмента:");

        signalLabel.setText("Сигнал:");

        signalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Музыка", "Песня", "Речь", "Пилообразный" }));
        signalComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signalComboBoxActionPerformed(evt);
            }
        });

        ALabel.setText("A:");

        ATextField.setText("10");

        TLabel.setText("T:");

        NLabel.setText("N:");

        NTextField.setText("65536");

        TTextField.setText("5");

        javax.swing.GroupLayout iftPanelLayout = new javax.swing.GroupLayout(iftPanel);
        iftPanel.setLayout(iftPanelLayout);
        iftPanelLayout.setHorizontalGroup(
            iftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        iftPanelLayout.setVerticalGroup(
            iftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        filterLabel.setText("Фильтр:");

        filterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Нижних частот", "Верхних частот", "Режекторный" }));
        filterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterComboBoxActionPerformed(evt);
            }
        });

        minLabel.setText("min:");

        minTextField.setText("100");

        maxLabel.setText("max:");

        maxTextField.setText("5000");

        filterButton.setText("Старт");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        filterNLabel.setText("N:");

        filterNTextField.setText("257");

        filterFcLabel.setText("fc:");

        filterFcTextField.setText("0.02267");
        filterFcTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterFcTextFieldActionPerformed(evt);
            }
        });

        windowLabel.setText("Окно:");

        windowComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Прямоугольное", "Хэмминга", "Бартлетта", "Хэннинга", "Блэкмана" }));

        highFrequencyCheckBox.setText("Высокочастотный фильтр");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ALabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ATextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(signalLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(signalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fragmentSizeLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fragmentSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(maxLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(filterLabel)
                                .addComponent(minLabel)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterFcLabel)
                            .addComponent(filterNLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filterNTextField)
                            .addComponent(filterFcTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(windowLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(windowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(highFrequencyCheckBox)))
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(532, Short.MAX_VALUE))
            .addComponent(iftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(signalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(filterLabel)
                                            .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(minLabel)
                                            .addComponent(minTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(maxLabel)
                                            .addComponent(maxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(signalLabel)
                                            .addComponent(signalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fragmentSizeLabel)
                                            .addComponent(fragmentSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ALabel)
                                            .addComponent(ATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TLabel)
                                            .addComponent(TTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NLabel)
                                            .addComponent(NTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(startButton)
                                    .addComponent(filterButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(filterNLabel)
                                    .addComponent(filterNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(windowLabel)
                                    .addComponent(windowComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(filterFcLabel)
                                    .addComponent(filterFcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(highFrequencyCheckBox))))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private List<Double> signal = null;
    int fragmentSize;
    double sampleRate = 1;
    SoundStream soundStream = null;
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        final int index = signalComboBox.getSelectedIndex();
        
        if (index == SAW_INDEX) {
            double A = Double.parseDouble(ATextField.getText());
            double T = Double.parseDouble(TTextField.getText());
            int N = Integer.parseInt(NTextField.getText());
            
            StandartSignal sawSignal = new SawSignal(A, T, N);
            signal = sawSignal.getSignal();
            
            fragmentSize = N;
            sampleRate = N / T;
        } else {
            File soundFile;
            int start;
            
            switch (index) {
                case 0:
                    soundFile = new File("sounds/the-rolling-stones.wav");
                    start = 0;
                    break;
                case 1:
                    soundFile = new File("sounds/song.wav");
                    start = 0;
                    break;
                default:
                    soundFile = new File("sounds/speech.wav");
                    start = 32_000;
                    break;
            }
            
            fragmentSize = Integer.parseInt(fragmentSizeTextField.getText());
            soundStream = new SoundStream();
            
            try {
                signal = soundStream.loadSignal(soundFile, start, fragmentSize);
                System.out.println("\nРазмер фрагмента: " + signal.size());
            } catch (IOException ex) {
                System.err.println("Не удалось загрузить сигнал");
            }
            
            sampleRate = soundStream.getSampleRate();
        }
        
        Common.updateSignalChart(signalChart, signal, sampleRate, seriesName);
        
        double step = 1.0;
        FourierTransform fastFourierTransform = new FastFourierTransform(signal);
        
        switch (filterComboBox.getSelectedIndex()) {
            case 1 : {
                int min = getMinFilter();
                fastFourierTransform.filterMin(min);
                break;
            }
            case 2 : {
                int max = getMaxFilter();
                fastFourierTransform.filterMax(max);
                break;
            }
            case 3: {
                int min = getMinFilter();
                int max = getMaxFilter();
                fastFourierTransform.filterMinMax(min, max);
                break;
            }
        }
        
        List<Double> fftModule = fastFourierTransform.getModuleList();
        updateFftChart(fftModule, step);
        
        List<Double> ift = fastFourierTransform.getIftList();
        Common.updateSignalChart(iftChart, ift, sampleRate, seriesName);
        
        repaint();
        
        if (signalComboBox.getSelectedIndex() != SAW_INDEX) {
            saveSignal(soundStream, ift, "Fourier_output.wav");
        }
        
        filterButton.setEnabled(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void fragmentSizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragmentSizeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fragmentSizeTextFieldActionPerformed

    private void signalComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signalComboBoxActionPerformed
        boolean isSaw = signalComboBox.getSelectedIndex() == SAW_INDEX;
        setSawParamsEnabled(isSaw);
        setSoundParamsEnabled(!isSaw);
    }//GEN-LAST:event_signalComboBoxActionPerformed

    private void filterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterComboBoxActionPerformed
        switch (filterComboBox.getSelectedIndex()) {
            case 0 :
                setFilterEnabled(false);
                break;
            case 1 :
                setFilterMinEnabled(true);
                setFilterMaxEnabled(false);
                break;
            case 2 :
                setFilterMinEnabled(false);
                setFilterMaxEnabled(true);
                break;
            case 3 :
                setFilterEnabled(true);
                break;
        }
    }//GEN-LAST:event_filterComboBoxActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        
        int N = Integer.parseInt(filterNTextField.getText());
        double fc = Double.parseDouble(filterFcTextField.getText());
        
        Filter.Name filterName;
        switch (windowComboBox.getSelectedIndex()) {
            case 0:
                filterName = Filter.Name.Rectangular;
                break;
            case 1:
                filterName = Filter.Name.Hamming;
                break;
            case 2:
                filterName = Filter.Name.Bartlett;
                break;
            case 3:
                filterName = Filter.Name.Hanning;
                break; 
            default:
                filterName = Filter.Name.Blackman;
        }
        
        boolean isHigh = highFrequencyCheckBox.isSelected();
        
        supportingFrame.makeAll(signal, N, fc, filterName, isHigh, sampleRate);
        
        List<Double> resultSignal = supportingFrame.getResultSignal();
        if (signalComboBox.getSelectedIndex() != SAW_INDEX) {
            saveSignal(soundStream, resultSignal, "FIR_output.wav");
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    private void filterFcTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterFcTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterFcTextFieldActionPerformed

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D signalPanelGraphics = (Graphics2D) signalPanel.getGraphics();
        signalChart.paint(signalPanelGraphics, signalPanel.getWidth(), signalPanel.getHeight());
        
        Graphics2D fftPanelGraphics = (Graphics2D) fftPanel.getGraphics();
        fftChart.paint(fftPanelGraphics, fftPanel.getWidth(), fftPanel.getHeight());
        
        Graphics2D iftPanelGraphics = (Graphics2D) iftPanel.getGraphics();
        iftChart.paint(iftPanelGraphics, iftPanel.getWidth(), iftPanel.getHeight());
    }
    
    void updateFftChart(List<Double> signal, double step) {
        List<Double> x = new ArrayList<>();
        for (int i = 0, ei = signal.size() / 2; i < ei; i++) {
            x.add(i * step * sampleRate / fragmentSize);
        }
        
        Common.updateChart(fftChart, x, signal.subList(0, signal.size() / 2), seriesName);
    }
    
    private int getMinFilter() {
        return (int) (Integer.parseInt(minTextField.getText()) * fragmentSize / sampleRate);
    }
    
    private int getMaxFilter() {
        return (int) (Integer.parseInt(maxTextField.getText()) * fragmentSize / sampleRate);
    }
    
    private void setSoundParamsEnabled(boolean value) {
        fragmentSizeLabel.setEnabled(value);
        fragmentSizeTextField.setEditable(value);
    }
    
    private void setSawParamsEnabled(boolean value) {
        setAEnabled(value);
        setTEnabled(value);
        setNEnabled(value);
    }
    
    void setAEnabled(boolean value) {
        ALabel.setEnabled(value);
        ATextField.setEditable(value);
    }
    
    void setTEnabled(boolean value) {
        TLabel.setEnabled(value);
        TTextField.setEditable(value);
    }
    
    void setNEnabled(boolean value) {
        NLabel.setEnabled(value);
        NTextField.setEditable(value);
    }
    
    private void setFilterEnabled(boolean value) {
        setFilterMinEnabled(value);
        setFilterMaxEnabled(value);
    }
    
    void setFilterMinEnabled(boolean value) {
        minLabel.setEnabled(value);
        minTextField.setEnabled(value);
    }
    
    void setFilterMaxEnabled(boolean value) {
        maxLabel.setEnabled(value);
        maxTextField.setEnabled(value);
    }
    
    void saveSignal(SoundStream stream, List<Double> signal, String fileName) {
        File file = new File(filePath + fileName);
        try {
            stream.saveSignal(signal, file);
        } catch (IOException ex) {
            System.err.println("Не удалось сохранить сигнал");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ALabel;
    private javax.swing.JTextField ATextField;
    private javax.swing.JLabel NLabel;
    private javax.swing.JTextField NTextField;
    private javax.swing.JLabel TLabel;
    private javax.swing.JTextField TTextField;
    private javax.swing.JPanel fftPanel;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JLabel filterFcLabel;
    private javax.swing.JTextField filterFcTextField;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel filterNLabel;
    private javax.swing.JTextField filterNTextField;
    private javax.swing.JLabel fragmentSizeLabel;
    private javax.swing.JTextField fragmentSizeTextField;
    private javax.swing.JCheckBox highFrequencyCheckBox;
    private javax.swing.JPanel iftPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JTextField maxTextField;
    private javax.swing.JLabel minLabel;
    private javax.swing.JTextField minTextField;
    private javax.swing.JComboBox<String> signalComboBox;
    private javax.swing.JLabel signalLabel;
    private javax.swing.JPanel signalPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JComboBox<String> windowComboBox;
    private javax.swing.JLabel windowLabel;
    // End of variables declaration//GEN-END:variables
}
