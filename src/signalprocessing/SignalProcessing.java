/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signalprocessing;

/**
 *
 * @author nekrasov
 */
public class SignalProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        startLab04();
    }
    
    private static void startLab02() {
        Lab02JFrame frame = new Lab02JFrame();
        frame.setTitle("ЛР №2. Основные понятия линейных фильтров. КИХ-фильтры.");
        frame.setVisible(true);
    }
    
    private static void startLab04() {
        Lab04JFrame frame = new Lab04JFrame();
        frame.setVisible(true);
    }
    
}
