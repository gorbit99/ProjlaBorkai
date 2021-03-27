package projlab.skeleton;

import projlab.skeleton.map.Field;
import projlab.skeleton.participants.Participant;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A játékot eltároló objektum
 */
public class Game {

    /**
     * A játékpálya mezői
     */
    private final ArrayList<Field> fields = new ArrayList<>();
    /**
     * A játékban résztvevők listája
     */
    private final ArrayList<Participant> participants = new ArrayList<>();
    /**
     * A játékhoz szükséges nyersanyagokat tároló objektum
     */
    private BillOfResources winBill;

    /**
     * A singleton design pattern instance tagváltozója
     */
    private static Game instance;

    /**
     * Privát konstruktor a singleton design patternhez
     */
    private Game() { }

    /**
     * Visszaadja az osztály singleton instance-ét
     * @return Az osztály singleton instance-e
     */
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    /**
     * Elindítja a játékot, egyelőre semmit nem csinál
     */
    public void startGame() {
        FunctionPrinter.enter("Game", "startGame", this);
        FunctionPrinter.exit();
    }

    /**
     * Befejezi a játékot, egyelőre semmit nem csinál
     */
    public void endGame() {
        FunctionPrinter.enter("Game", "endGame", this);
        FunctionPrinter.exit();
    }

    /**
     * Leellenőrzi, hogy a játék véget ért-e
     * @return Véget ért-e a játék
     */
    public boolean checkGameEnd() {
        FunctionPrinter.enter("Game", "checkGameEnd", this);
        FunctionPrinter.ask("Vege a jateknak? (I/N)");
        boolean end = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return end;
    }

    /**
     * Leellenőrzi, hogy van-e elég nyersanyag a játék megnyeréséhez
     * @return Van-e elég nyersanyag a játék megnyeréséhez
     */
    public boolean checkEnoughResources() {
        FunctionPrinter.enter("Game", "checkEnoughResources", this);
        FunctionPrinter.ask("Van eleg nyersanyag? (I/N)");
        boolean enough = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return enough;
    }

    /**
     * Lefuttat egy napkitörést a játékpályán
     */
    public void solarFlare() {
        FunctionPrinter.enter("Game", "solarFlare", this);
        // Menjünk végig az összes mezőn és futtassunk le rajtuk egy napkitörést
        for (Field field : fields) {
            field.solarFlare();
        }
        FunctionPrinter.exit();
    }

    /**
     * Hozzáad egy mezőt a játékpályához
     * @param field A hozzáadandó metódus
     */
    public void addField(Field field) {
        FunctionPrinter.enter("Game", "addField", this, field);
        fields.add(field);
        FunctionPrinter.exit();
    }

    /**
     * Eltávolít egy résztvevőt a játékból
     * @param participant Az eltávolítandó résztvevő
     */
    public void removeParticipant(Participant participant) {
        FunctionPrinter.enter("Game", "removeParticipant", this, participant);
        participants.remove(participant);
        FunctionPrinter.exit();
    }

    /**
     * Hozzáad egy résztvevőt a játékjoz
     * @param participant A hozzáadandó résztvevő
     */
    public void addParticipant (Participant participant){
        FunctionPrinter.enter("Game", "addParticipant", this, participant);
        participants.add(participant);
        FunctionPrinter.exit();
    }

}
