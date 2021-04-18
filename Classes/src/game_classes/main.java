package game_classes;

import java.io.*;
import java.util.Scanner;

public class main {
    /**
     * The main function
     * @param args Program arguments
     */
    public static void main(String[] args) {
        TestHarness testHarness = new TestHarness();
        try {
            testHarness.run();
        } catch (TestHarness.TestException e) {
            System.out.println(e);
        }
    }
}

