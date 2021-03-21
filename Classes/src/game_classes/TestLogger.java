package game_classes;

public class TestLogger {
    private static int indentLevel = 0;

    public static void EnterFunction(String functionName) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("---");
        }
        System.out.println(functionName);
    }

    public static void ExitFunction() {
        indentLevel--;
    }
}
