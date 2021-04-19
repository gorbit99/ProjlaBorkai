package game_classes;

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
    public static final MockIn in;
    /**
     * Mock output stream, throws away the input
     */
    public static final MockOut out;
}

/**
 * Mock input stream
 */
class MockIn extends InputStream {
    private final LinkedList<String> inputs = new LinkedList<>();

    /**
     * Reads the next byte specified earlier
     *
     * @return The next byte in the stream
     */
    @Override
    public int read() {
        while (inputs.size() > 0 && inputs.get(0).length() == 0) {
            inputs.pollFirst();
        }

        if (inputs.size() == 0) {
            return -1;
        }

        int result = inputs.get(0).getBytes(StandardCharsets.UTF_8)[0];
        inputs.set(0, inputs.get(0).substring(1));

        return result;
    }

    /**
     * Add input to the stream
     *
     * @param input The input to add
     */
    public void addInput(String input) {
        inputs.addLast(input);
    }
}

/**
 * Mock output stream
 */
class MockOut extends OutputStream {
    /**
     * Throws the parameter away
     *
     * @param i The byte to write
     */
    @Override
    public void write(int i) {
    }

    /**
     * Mocks a println call with a parameter
     *
     * @param ignored The line to print out
     */
    public void println(String ignored) {

    }

    /**
     * Mocks a println call
     */
    public void println() {

    }
}
