package katiaul.io;

import java.io.*;

public class Message {
    private final byte command;
    private final DataInputStream reader;
    private final DataOutputStream writer;
    private final ByteArrayOutputStream buffer;

    public Message(byte command, byte[] buffer) {
        this.command = command;
        this.buffer = new ByteArrayOutputStream();
        reader = new DataInputStream(new ByteArrayInputStream(buffer));
        writer = new DataOutputStream(this.buffer);
    }

    public Message(int command, byte[] buffer) {
        this((byte) command, buffer);
    }

    public Message(byte command) {
        this(command, new byte[0]);
    }

    public Message(int command) {
        this((byte) command);
    }

    public byte getCommand() {
        return command;
    }

    public DataInputStream getReader() {
        return reader;
    }

    public DataOutputStream getWriter() {
        return writer;
    }

    public byte[] getBuffer() {
        return buffer.toByteArray();
    }

    public void flush() throws IOException {
        writer.flush();
        buffer.flush();
    }

    public void close() throws IOException {
        reader.close();
        writer.close();
        buffer.close();
    }
}
