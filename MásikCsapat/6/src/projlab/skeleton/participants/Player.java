package projlab.skeleton.participants;

import projlab.skeleton.Game;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.utils.FunctionPrinter;

/**
 * A humán játékosokat jelképező osztály
 */
public class Player extends Participant {

    /**
     * A játékos telepese
     */
    private Settler settler;

    /**
     * A feladás parancsot implementáló metódus
     */
    public void giveUp() {
        FunctionPrinter.enter("Player", "giveUp", this);
        // Öljük meg a telepest
        settler.die();
        // Távolítsuk el a játékost a játékból
        Game.getInstance().removeParticipant(this);
        FunctionPrinter.exit();
    }

    /**
     * A semmittevés/passz parancsot implementáló metódus, nem csinál semmit
     */
    public void pass() {
        FunctionPrinter.enter("Player", "pass", this);
        FunctionPrinter.exit();
    }

    /**
     * Beállítja a játékos telepesét
     * @param settler A beállítandó telepes
     */
    public void setSettler(Settler settler) {
        FunctionPrinter.enter("Player", "setSettler", this, settler);
        this.settler = settler;
        FunctionPrinter.exit();
    }
}
