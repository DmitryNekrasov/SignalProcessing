package signalprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nekrasov
 */
public class SoundStream {
    
    private byte[] head = new byte[44];
    
    public List<Double> loadSignal(File file) throws IOException {
        
        DataInputStream stream = new DataInputStream(new FileInputStream(file));
        
        stream.read(head);
        
        DataInputStream headStream = new DataInputStream(new ByteArrayInputStream(head));
        
        // "RIFF"
        for (int i = 0; i < 4; i++) {
            System.out.print((char) headStream.readByte());
        }
        System.out.println();
        
        byte[] intBuffer = new byte[4];
        headStream.read(intBuffer);
        System.out.println("Размер файла: " + intFromBytes(intBuffer));
        
        // "WAVE"
        for (int i = 0; i < 4; i++) {
            System.out.print((char) headStream.readByte());
        }
        System.out.println();
        
        // "fmt "
        for (int i = 0; i < 4; i++) {
            System.out.print((char) headStream.readByte());
        }
        System.out.println();
        
        for (int i = 0; i < 4; i++) {
            System.out.print(headStream.readByte()+ " ");
        }
        System.out.println();
        
        for (int i = 0; i < 4; i++) {
            System.out.print(headStream.readByte()+ " ");
        }
        System.out.println();
        
        headStream.read(intBuffer);
        int sampleRate = intFromBytes(intBuffer);
        System.out.println("Частота дискретизации: " + sampleRate);
        
        headStream.read(intBuffer);
        int bytePerSecond = intFromBytes(intBuffer);
        System.out.println("Число байт в секунду: " + bytePerSecond);
        
        for (int i = 0; i < 4; i++) {
            System.out.print(headStream.readByte() + " ");
        }
        System.out.println();
        
        char ch = (char) headStream.readByte();
        System.out.print(ch);
        for (int i = 0; i < 3; i++) {
            System.out.print((char) headStream.readByte());
        }
        System.out.println();
        
        if (Character.toLowerCase(ch) == 'd') {
            headStream.read(intBuffer);
        } else {
            headStream.read(intBuffer);
            boolean isData = false;
            while (!isData) {
                ch = (char) stream.readByte();
                if (Character.toLowerCase(ch) == 'd') {
                    ch = (char) stream.readByte();
                    if (Character.toLowerCase(ch) == 'a') {
                        ch = (char) stream.readByte();
                        if (Character.toLowerCase(ch) == 't') {
                            ch = (char) stream.readByte();
                            if (Character.toLowerCase(ch) == 'a') {
                                isData = true;
                            }
                        }
                    }
                }
            }
            stream.read(intBuffer);
        }
        
        int dataSize = intFromBytes(intBuffer);
        System.out.println("Размер данных: " + dataSize);
        
        List<Double> signal = new ArrayList<>();
        byte[] shortBuffer = new byte[2];
        for (int i = 0, ei = dataSize / 2; i < ei; i++) {
            stream.read(shortBuffer);
            signal.add((double) shortFromBytes(shortBuffer));
        }
        
        return signal;
    }
    
    int intFromBytes(byte[] buffer) {
        return (buffer[0] & 0xff) | ((buffer[1] & 0xff) << 8) | ((buffer[2] & 0xff) << 16) | ((buffer[3] & 0xff) << 24);
    }
    
    short shortFromBytes(byte[] buffer) {
        return (short) ((buffer[0] & 0xff) | ((buffer[1] & 0xff) << 8));
    }
    
}
