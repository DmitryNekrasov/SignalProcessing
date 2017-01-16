import java.io.*;
import java.util.ArrayList;
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
        
        return new ArrayList<>();
    }
    
}
