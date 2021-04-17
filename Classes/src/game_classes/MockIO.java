package game_classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

/**
 * Direct replacement for System.in and System.out
 */
public class MockIO {
    static {
        in = new MockIn();
        out = new MockOut();
    }

    /**
     * Mock input stream, returns the previous specified bytes in order
     */
    public static MockIn in;
    /**
     * Mock output stream, throws away the input
     */
    public static MockOut out;
}

/**
 * Mock input stream
 */
class MockIn extends InputStream {
    private LinkedList<String> inputs = new LinkedList<>();

    /**
     * Reads the next byte specified earlier
     * @return The next byte in the stream
     * @throws IOException
     */
    @Override
    public int read() throws IOException {
        while (inputs.size() > 0 && inputs.get(0).length() == 0) {
            inputs.pollFirst();
        }

        if (inputs.size() == 0) {
            throw new IOException("No input provided!");
        }

        int result = inputs.get(0).getBytes(StandardCharsets.UTF_8)[0];
        inputs.set(0, inputs.get(0).substring(1));

        return result;
    }

    /**
     * Add input to the stream
     * @param input The input to add
     */
    public void addInput(String input) {
        inputs.addLast(input);
    }
}

class MockOut extends OutputStream {
    @Override
    public void write(int i) throws IOException {
    }
}
