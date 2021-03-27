package projlab.skeleton.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 * A Skeletonhoz szükséges konzol kiírást elősegítő segédosztály
 */
public class FunctionPrinter {

    /**
     * A behúzás jelenlegi szintje
     */
    private static int level = 0;

    /**
     * A behúzűsokhoz tartozó metódus nevek
     */
    private static ArrayList<String> names = new ArrayList<>();
    /**
     * A regisztrált objektumok a név szerinti kiíráshoz
     */
    private static HashMap<Object, String> objects = new HashMap<>();

    /**
     * Regisztrál egy objektumhoz egy nevet, így ha a kiíró találkozik vele, tudni fogja, hogy hogy kell kiírni
     * @param object A regisztrálandó objektum
     * @param name A regisztrálandó objektum neve
     */
    public static void register(Object object, String name) {
        objects.put(object, name);
    }

    /**
     * A függvények elején meghívandó. Kiírja a metódus és objektum nevét a paraméterekkel és behúzza eggyel a kimenetet
     * @param className A meghívó osztály neve
     * @param name A meghívó metódus neve
     * @param object A meghívó objektum
     * @param parameters A paraméterek, amiket a meghívó metódus kap
     */
    public static void enter(String className, String name, Object object, Object... parameters) {

        // Szérializáljuk a paramétereket és kapcsoljuk őket össze vesszővel
        StringJoiner joiner = new StringJoiner(", ");
        for (Object parameter : parameters) {
            if (parameter == null) {
                // Ha a paraméter null, írjuk azt
                joiner.add("null");
            } else if (objects.containsKey(parameter)) {
                // Ha regisztrálva van az objektum
                joiner.add(objects.get(parameter));
            } else {
                // Egyébként próbáljuk meg csak stringgé alakítani
                joiner.add(parameter.toString());
            }
        }

        // Ha regisztrálva van az objektum, használjuk a nevét, egyébként pedig az osztály nevet
        String objName;
        if (objects.containsKey(object)) {
            objName = objects.get(object) + ".";
        } else {
            objName = className + "#";
        }

        // Írjuk ki a nevet és a kapcsos rázójeleket behúzással együtt
        String n = objName + name + "(" + joiner.toString() + ")";
        System.out.println("    ".repeat(level) + n + " {");
        // Adjuk hozzá a nevet a listához a későbbi használathoz
        names.add(n);
        level++;
    }

    /**
     * Kiír egy üzenetet a konzolra a meghívó metódus szintjében
     * @param msg A kiírandó üzenet
     */
    public static void msg(String msg) {
        System.out.println("    ".repeat(level) + msg);
    }

    /**
     * Feltesz egy kérdést a konzolon. Gyakorlatilag üzenet új sor nélkül
     * @param question A kiírandó kérdés
     */
    public static void ask(String question) {
        System.out.print("    ".repeat(level) + question + " ");
    }

    /**
     * Meghívandó, amikor kilépünk egy metódusból. Visszavon egy behúzást
     */
    public static void exit() {
        level--;
        names.remove(names.size() - 1);
        System.out.println("    ".repeat(level) + "}");
    }



}
