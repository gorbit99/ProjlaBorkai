package game_classes;

import java.util.Scanner;
import java.util.Stack;

/**
 * This class creates the indented output
 */
public class TestLogger {
    private static int indentLevel = 0;
    private static Scanner scanner;
    private static Stack<String> functions = new Stack<>();

    /**
     * To be called when calling a function
     * @param functionName The name of the function
     */
    public static void EnterFunction(String functionName) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(functionName + "()");
        functions.push(functionName);
        indentLevel++;
    }

    /**
     * To be called when exiting a function
     */
    public static void ExitFunction() {
        indentLevel--;
        String function = functions.pop();
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(function + "() return");
    }

    /**
     * To be called when asking a question
     * @param message Text of the question.
     * @return the answer
     */
    public static String AskQuestion(String message) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        System.out.println("\n" + message + " ");
        String result = scanner.next();
        System.out.println();
        return result;
    }
}
