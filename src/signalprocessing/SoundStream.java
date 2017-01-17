package signalprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nekrasov
 */
public class SoundStream {
    
    private byte[] head = new byte[44];
    
    private int sampleRate;
    private int bytePerSecond;
    
    public int getSampleRate() {
        return sampleRate;
    }
    
    public int getBytePerSecond() {
        return bytePerSecond;
    }
    
    public List<Double> loadSignal(File file, int start, int fragmentSize) throws IOException {
        
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
        sampleRate = intFromBytes(intBuffer);
        System.out.println("Частота дискретизации: " + sampleRate);
        
        headStream.read(intBuffer);
        bytePerSecond = intFromBytes(intBuffer);
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
        for (int i = 0; i < start; i++) {
            stream.read(shortBuffer);
            dataSize -= 2;
        }
        for (int i = 0, ei = Math.min(dataSize / 2, fragmentSize); i < ei; i++) {
            stream.read(shortBuffer);
            signal.add((double) shortFromBytes(shortBuffer));
        }
        
        return signal;
    }
    
    public void saveSignal(List<Double> signal, File file) throws IOException {
        int dataSize = signal.size() * 2;
        byte[] buffer = intToBytes(dataSize + 36);
        head[4] = buffer[0];
        head[5] = buffer[1];
        head[6] = buffer[2];
        head[7] = buffer[3];
        
        head[36] = 'd';
        head[37] = 'a';
        head[38] = 't';
        head[39] = 'a';
        
        buffer = intToBytes(dataSize);
        head[40] = buffer[0];
        head[41] = buffer[1];
        head[42] = buffer[2];
        head[43] = buffer[3];
        
        FileOutputStream writer = new FileOutputStream(file);
        writer.write(head);
        for (double value : signal) {
            short data = (short) value;
            byte[] shortBuffer = shortToBytes(data);
            writer.write(shortBuffer);
        }
    }
    
    private int intFromBytes(byte[] buffer) {
        return (buffer[0] & 0xff) | ((buffer[1] & 0xff) << 8) | ((buffer[2] & 0xff) << 16) | ((buffer[3] & 0xff) << 24);
    }
    
    private short shortFromBytes(byte[] buffer) {
        return (short) ((buffer[0] & 0xff) | ((buffer[1] & 0xff) << 8));
    }
    
    private byte[] intToBytes(int data) {
        byte[] buffer = new byte[4];
        buffer[0] = (byte) (data & 0xff);
        buffer[1] = (byte) ((data >> 8) & 0xff);
        buffer[2] = (byte) ((data >> 16) & 0xff);
        buffer[3] = (byte) ((data >> 24) & 0xff);
        return buffer;
    }
    
    private byte[] shortToBytes(short data) {
        byte[] buffer = new byte[2];
        buffer[0] = (byte) (data & 0xff);
        buffer[1] = (byte) ((data >> 8) & 0xff);
        return buffer;
    }
}
