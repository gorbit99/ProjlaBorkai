package game_classes;

import java.util.Scanner;

public class TestLogger {
    private static int indentLevel = 0;
    private static Scanner scanner;

    public static void EnterFunction(String functionName) {
        indentLevel++;
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(functionName);
    }

    public static void ExitFunction() {
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
