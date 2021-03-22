package game_classes;

import java.util.Scanner;
import java.util.Stack;

public class TestLogger {
    private static int indentLevel = 0;
    private static Scanner scanner;
    private static Stack<String> functions = new Stack<>();

    public static void EnterFunction(String functionName) {
        indentLevel++;
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(functionName + "()");
        functions.push(functionName);
    }

    public static void ExitFunction() {
        String function = functions.pop();
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(function + "() return");
        indentLevel--;
    }

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
