package game_classes;

import java.io.*;
import java.util.Scanner;

public class main {
    /**
     * The main function
     * @param args Program arguments
     */
    public static void main(String[] args) {
        Asteroid a1 = new Asteroid();
        Astronaut s1 = new Astronaut(a1);
        a1.SetCore(new Coal());
        MockIO.in.addInput("1");
        try{
            s1.Mine();
            System.out.println(s1.GetStoredMaterials().size());
            s1.PlaceMaterial();
        } catch (Exception e) {
        }
        System.out.println(a1.GetCore().toString());
    }
}

