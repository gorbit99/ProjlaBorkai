package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;
/**
 * 
 * Az entitások által tartózkodásra használható objektumok összefogása
 *
 */
public abstract class Field {
    /**
     * szomszédos mezők
     */
    protected final ArrayList<Field> neighbors = new ArrayList<>();

    /**
     * Szomszédos Field hozzáadása
     * @param f a szomszéd
     */
    public void addNeighbor(Field f) {
        FunctionPrinter.enter("Field", "addNeighbor", this, f);
        neighbors.add(f);
        FunctionPrinter.exit();
    }
/**
 * Szomszédos Field kivétele a szomszédok közül
 * @param f a szomsz�d
 */
    public void removeNeighbor(Field f) {
        FunctionPrinter.enter("Field", "removeNeighbor", this, f);
        neighbors.remove(f);
        FunctionPrinter.exit();
    }
/**
 * Entitások érkezése
 * @param entity az érkező entitás
 */
    public abstract void addEntity(Entity entity);
/**
 * Napvihar hatása a Fieldekre
 */
    public void solarFlare() {
        FunctionPrinter.enter("Field", "solarFlare", this);
        FunctionPrinter.exit();
    }
/**
 * Szomszédos robbanás hatása a Fieldekre
 */
    public void explodeReaction() {
        FunctionPrinter.enter("Field", "explodeReaction", this);
        FunctionPrinter.exit();
    }
/**
 * Visszaadja a Field szomszédjait
 * @return a szomszédok
 */
    public ArrayList<Field> getNeighbors() {
        FunctionPrinter.enter("Field", "getNeighbors", this);
        FunctionPrinter.exit();
        return neighbors;
    }


}
