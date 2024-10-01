package katiaul.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class RawData {
    public static byte[] getBytes(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        byte[] bytes = stream.readAllBytes();
        stream.close();
        return bytes;
    }

    public static byte[] getBytes(String path) throws IOException {
        return getBytes(new File(path));
    }

    public static void putBytes(File file, byte[] bytes) throws IOException {
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(bytes);
        stream.close();
    }

    public static void putBytes(String path, byte[] bytes) throws IOException {
        putBytes(new File(path), bytes);
    }
}
