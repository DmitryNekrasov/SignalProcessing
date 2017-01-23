/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XYChart;

/**
 *
 * @author nekrasov
 */
public class Lab05JFrame extends javax.swing.JFrame {

    final String seriesName = "y(x)";
    
    XYChart signalChart;
    
    /**
     * Creates new form Lab05JFrame
     */
    public Lab05JFrame() {
        initComponents();
        
        signalChart = QuickChart.getChart("", "", "", seriesName, new double[1], new double[1]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signalPanel = new javax.swing.JPanel();
        signalTypeLabel = new javax.swing.JLabel();
        signalTypeComboBox = new javax.swing.JComboBox<>();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        signalTypeLabel.setText("Тип сигнала:");

        signalTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Кардиосигнал", "Реосигнал", "Велосигнал" }));

        startButton.setText("Старт");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signalTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signalTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton))
                .addContainerGap(825, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(signalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signalTypeLabel)
                    .addComponent(signalTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startButton)
                .addGap(0, 270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int index = signalTypeComboBox.getSelectedIndex();
        SignalFromFile signalFromFile;
        double sampleRate = 1;
        switch (index) {
            case 0:
                signalFromFile = new SignalFromFile("signals/Cardio.txt");
                break;

            case 1:
                signalFromFile = new SignalFromFile("signals/Reo.txt");
                break;

            default:
                signalFromFile = new SignalFromFile("signals/Velo.txt");
        }
        
        List<Double> signal = signalFromFile.getSignal();
        
        Common.updateSignalChart(signalChart, signal, sampleRate, seriesName);
        
        repaint();
    }//GEN-LAST:event_startButtonActionPerformed

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D signalPanelGraphics = (Graphics2D) signalPanel.getGraphics();
        signalChart.paint(signalPanelGraphics, signalPanel.getWidth(), signalPanel.getHeight());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel signalPanel;
    private javax.swing.JComboBox<String> signalTypeComboBox;
    private javax.swing.JLabel signalTypeLabel;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}