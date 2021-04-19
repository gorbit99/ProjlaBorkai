package game_classes;

import java.util.Scanner;

/**
 * This class creates the indented output
 */
public class TestLogger {
    private static Scanner scanner;

    /**
     * To be called when asking a question
     *
     * @param message Text of the question.
     * @return the answer
     */
    public static String AskQuestion(String message) {
        if (scanner == null) {
            scanner = new Scanner(MockIO.in);
        }
        MockIO.out.println("\n" + message + " ");
        String result = scanner.next();
        MockIO.out.println();
        return result;
    }
}
