package projlab.skeleton.map;

import projlab.skeleton.entities.Entity;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.Scanner;

/**
 * Teleportkapuk megtestesítése
 */
public class TeleportGate extends Field {
    /**
     * A teleportkapu párja
     */
    private TeleportGate pair;

    /**
     * Mmegszűnik létezni a teleportkapu
     */
    public void die() {
        FunctionPrinter.enter("TeleportGate", "die", this);
        FunctionPrinter.exit();
    }

    /**
     * Reagálás az aszteroidájának felrobbanására
     */
    @Override
    public void explodeReaction() {
        FunctionPrinter.enter("TeleportGate", "explodeReaction", this);
        pair.die();
        this.die();
        FunctionPrinter.exit();
    }

    /**
     * Az teleportkapura entitás érkezik
     * @param entity az érkező entitás
     */
    @Override
    public void addEntity(Entity entity) {
        FunctionPrinter.enter("TeleportGate", "addEntity", this, entity);
        teleportToPair(entity);
        FunctionPrinter.exit();
    }

    /**
     * A teleportkapu párjára való átteleportálás
     *
     * @param entity a teleportkaput használó entitás
     */
    private void teleportToPair(Entity entity) {
        FunctionPrinter.enter("TeleportGate", "teleportToPair", this, entity);
        neighbors.get(0).addEntity(entity);
        FunctionPrinter.exit();
    }

    /**
     * Beállítja a teleportkapu párját
     *
     * @param teleport a teleportkapu párja
     */
    public void setPair(TeleportGate teleport) {
        FunctionPrinter.enter("TeleportGate", "setPair", this, teleport);
        pair = teleport;
        FunctionPrinter.exit();
    }

    /**
     * Megadja, hogy aktyv-e a teleportkapu
     *
     * @return aktívság
     */
    public boolean getActive() {
        FunctionPrinter.enter("TeleportGate", "getActive", this);
        FunctionPrinter.ask("Aktiv a teleport? (I/N)");
        boolean active = new Scanner(System.in).next().equals("I");
        FunctionPrinter.exit();
        return active;
    }

    /**
     * Beállítjuk a teleportkapu aktívságát
     *
     * @param active a teleportkapu aktívsága
     */
    public void setActive(boolean active) {
        FunctionPrinter.enter("TeleportGate", "setActive", this, active);
        // Eggyezzen meg a pár aktivitása is
        if (active) {
            if (!pair.getActive())
                pair.setActive(true);
        } else {
            if (pair.getActive())
                pair.setActive(false);
        }
        FunctionPrinter.exit();
    }
}
