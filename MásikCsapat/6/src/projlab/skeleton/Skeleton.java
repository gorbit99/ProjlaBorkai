package projlab.skeleton;

import projlab.skeleton.entities.Robot;
import projlab.skeleton.entities.Settler;
import projlab.skeleton.map.Asteroid;
import projlab.skeleton.map.TeleportGate;
import projlab.skeleton.participants.AI;
import projlab.skeleton.participants.Player;
import projlab.skeleton.resources.Coal;
import projlab.skeleton.resources.Iron;
import projlab.skeleton.resources.WaterIce;
import projlab.skeleton.resources.radioactive.Uran;
import projlab.skeleton.utils.BillOfResources;
import projlab.skeleton.utils.FunctionPrinter;

import java.util.ArrayList;

/**
 * A program szenárióit kezelő osztály
 */
public class Skeleton {
    /**
     * 5.3.3-as szekvencia és 5.4.3-as kommunikációs diagram írja le
     * A telepes bányászását modellezi le
     */
    public void settlerMines() {
        System.out.println("settlerMines");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Iron resource = new Iron();
        FunctionPrinter.register(resource, "resource");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(settler);
        asteroid.setResource(resource);

        settler.mine();
    }

    /**
     * 5.3.7-es szekvencia és 5.4.7-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes nem radioaktív vagy vízjég nyersanyagot helyez le egy aszteroidába
     */
    public void placeDownNotRadioactiveOrWatericeResource() {
        System.out.println("placeDownNotRadioactiveOrWatericeResource");
        Iron resource = new Iron();
        FunctionPrinter.register(resource, "resource");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(settler);
        settler.addResource(resource);

        settler.placeDownResource(resource);
    }

    /**
     * 5.3.6-os szekvencia és 5.4.6-os kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes lehelyez egy teleport kaput
     */
    public void placeDownTeleportGate() {
        System.out.println("placeDownTeleportGate");
        TeleportGate teleport1 = new TeleportGate();
        FunctionPrinter.register(teleport1, "teleport1");
        TeleportGate teleport2 = new TeleportGate();
        FunctionPrinter.register(teleport2, "teleport2");

        teleport1.setPair(teleport2);
        teleport2.setPair(teleport1);

        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        settler.setTeleports(teleport1, teleport2);
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        Game game = Game.getInstance();
        FunctionPrinter.register(game, "game");
        asteroid.addEntity(settler);

        settler.placeDownTeleport(asteroid);
    }

    /**
     * 5.3.4-es szekvencia és a 5.4.4-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes épít egy robotot
     */
    public void buildRobot() {
        System.out.println("buildRobot");
        Iron iron = new Iron();
        FunctionPrinter.register(iron, "iron");
        Coal coal = new Coal();
        FunctionPrinter.register(coal, "coal");
        Uran uran = new Uran();
        FunctionPrinter.register(uran, "uran");

        BillOfResources robotBill = new BillOfResources();
        FunctionPrinter.register(robotBill, "robotBill");
        AI ai = AI.getInstance();
        FunctionPrinter.register(ai, "ai");
        Settler settler = new Settler(robotBill, null);
        FunctionPrinter.register(settler, "settler");

        robotBill.addResource(iron);
        robotBill.addResource(coal);
        robotBill.addResource(uran);

        Iron iron2 = new Iron();
        FunctionPrinter.register(iron2, "iron2");
        Coal coal2 = new Coal();
        FunctionPrinter.register(coal2, "coal2");
        Uran uran2 = new Uran();
        FunctionPrinter.register(uran2, "uran2");

        settler.addResource(iron2);
        settler.addResource(coal2);
        settler.addResource(uran2);

        settler.buildRobot();
    }

    /**
     * 5.3.5-ös szekvencia és a 5.4.5-ös kommunikációs diagram írja le
     *  Azt modellezi le, hogy egy telepes épít egy teleportkapu párt
     */
    public void buildTeleportGate() {
        System.out.println("buildTeleportGate");
        Iron iron1 = new Iron();
        FunctionPrinter.register(iron1, "iron1");
        Iron iron2 = new Iron();
        FunctionPrinter.register(iron2, "iron2");
        WaterIce waterIce = new WaterIce();
        FunctionPrinter.register(waterIce, "waterIce");
        Uran uran = new Uran();
        FunctionPrinter.register(uran, "uran");

        BillOfResources teleportBill = new BillOfResources();
        FunctionPrinter.register(teleportBill, "teleportBill");
        Settler settler = new Settler(null, teleportBill);
        FunctionPrinter.register(settler, "settler");

        Iron iron3 = new Iron();
        FunctionPrinter.register(iron3, "iron3");
        Iron iron4 = new Iron();
        FunctionPrinter.register(iron4, "iron4");
        WaterIce waterIce2 = new WaterIce();
        FunctionPrinter.register(waterIce2, "waterIce2");
        Uran uran2 = new Uran();
        FunctionPrinter.register(uran2, "uran2");

        teleportBill.addResource(iron3);
        teleportBill.addResource(iron4);
        teleportBill.addResource(waterIce2);
        teleportBill.addResource(uran2);

        settler.addResource(iron1);
        settler.addResource(iron2);
        settler.addResource(waterIce);
        settler.addResource(uran);

        settler.buildTeleport();
    }

    /**
     * 5.3.20-as szekvencia és a 5.4.20-as kommunikációs diagram írja le
     * Azt modellezi le, hogy egy játékos passzol
     */
    public void pass() {
        System.out.println("pass");
        Player player = new Player();
        FunctionPrinter.register(player, "player");

        player.pass();
    }

    /**
     * 5.3.19-es szekvencia és a 5.4.19-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy játékos feladja a játékot
     */
    public void giveUp() {
        System.out.println("giveUp");
        Player player = new Player();
        FunctionPrinter.register(player, "player");
        Game game = Game.getInstance();
        FunctionPrinter.register(game, "game");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");

        game.addParticipant(player);
        player.setSettler(settler);
        asteroid.addEntity(settler);

        player.giveUp();
    }

    /**
     * 5.3.1-es szekvencia és a 5.4.1-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes mozog egy aszteroidára át
     */
    public void settlerMoveAsteroid() {
        System.out.println("settlerMoveAsteroid");
        Asteroid a1 = new Asteroid();
        FunctionPrinter.register(a1, "asteroid1");
        Asteroid a2 = new Asteroid();
        FunctionPrinter.register(a2, "asteroid2");
        Settler s1 = new Settler(null, null);
        FunctionPrinter.register(s1, "settler");
        a1.addEntity(s1);
        a1.addNeighbor(a2);
        a2.addNeighbor(a1);

        s1.move(a2);
    }

    /**
     * 5.3.2-es szekvencia és a 5.4.2-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes egy teleport kapura mozog át
     */
    public void settlerMoveTeleportGate() {
        System.out.println("settlerMoveTeleportGate");
        Asteroid asteroid1 = new Asteroid();
        FunctionPrinter.register(asteroid1, "aasteroid1");
        Asteroid asteroid2 = new Asteroid();
        FunctionPrinter.register(asteroid2, "asteroid2");
        TeleportGate teleportGate1 = new TeleportGate();
        FunctionPrinter.register(teleportGate1, "teleportGate1");
        TeleportGate teleportGate2 = new TeleportGate();
        FunctionPrinter.register(teleportGate2, "teleportGate2");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        teleportGate1.addNeighbor(asteroid1);
        asteroid1.addEntity(settler);
        asteroid1.addNeighbor(teleportGate1);
        asteroid2.addNeighbor(teleportGate2);
        teleportGate2.addNeighbor(asteroid2);
        teleportGate1.setPair(teleportGate2);
        teleportGate2.setPair(teleportGate1);


        settler.move(teleportGate1);
    }

    /**
     * 5.3.10-es szekvencia és a 5.4.10-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy robot egy aszteroidára mozog át
     */
    public void robotMove() {
        System.out.println("robotMove");
        Asteroid asteroid1 = new Asteroid();
        FunctionPrinter.register(asteroid1, "asteroid1");
        Asteroid asteroid2 = new Asteroid();
        FunctionPrinter.register(asteroid2, "asteroid2");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        asteroid1.addEntity(robot);
        asteroid1.addNeighbor(asteroid2);
        asteroid2.addNeighbor(asteroid1);

        robot.move(asteroid2);
    }

    /**
     * 5.3.11-es szekvencia és a 5.4.11-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy robot egy teleport kapura mozog át
     */
    public void robotMoveTeleportGate() {
        System.out.println("robotMoveTeleportGate");
        FunctionPrinter.register(AI.getInstance(), "ai");
        Asteroid asteroid1 = new Asteroid();
        FunctionPrinter.register(asteroid1, "asteroid1");
        Asteroid asteroid2 = new Asteroid();
        FunctionPrinter.register(asteroid2, "asteroid");
        TeleportGate teleportGate1 = new TeleportGate();
        FunctionPrinter.register(teleportGate1, "teleportGate1");
        TeleportGate teleportGate2 = new TeleportGate();
        FunctionPrinter.register(teleportGate2, "teleportGate2");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        asteroid1.addEntity(robot);
        asteroid1.addNeighbor(teleportGate1);
        teleportGate1.addNeighbor(asteroid1);
        asteroid2.addNeighbor(teleportGate2);
        teleportGate2.addNeighbor(asteroid2);
        teleportGate1.setPair(teleportGate2);
        teleportGate2.setPair(teleportGate1);


        robot.move(teleportGate1);
    }

    /**
     * 5.3.18-as szekvencia és a 5.4.18-as kommunikációs diagram írja le
     * Azt modellezi le, hogy napvihar ér el egy aszteroidát és az azon tartózkodó entityket
     */
    public void solarFlare() {
        System.out.println("solarFlare");
        Game game = Game.getInstance();
        FunctionPrinter.register(game, "game");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");

        game.addField(asteroid);
        asteroid.addEntity(settler);
        asteroid.addEntity(robot);


        game.solarFlare();

    }

    /**
     * 5.3.9-es szekvencia és a 5.4.9-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes vízjég nyersanyagot helyez le egy aszteroidába
     */
    public void placeDownWaterIce() {
        System.out.println("placeDownWaterIce");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        WaterIce resource = new WaterIce();
        FunctionPrinter.register(resource, "resource");
        asteroid.addEntity(settler);
        settler.addResource(resource);


        settler.placeDownResource(resource);
    }

    /**
     * 5.3.8-as szekvencia és a 5.4.8-as kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes radioaktív nyersanyagot helyez le egy aszteroidába
     */
    public void placeDownRadioactive() {
        System.out.println("placeDownRadioactive");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Uran resource = new Uran();
        FunctionPrinter.register(resource, "resource");
        asteroid.addEntity(settler);
        settler.addResource(resource);

        settler.placeDownResource(resource);
    }

    /**
     * 5.3.17-es szekvencia és a 5.4.17-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy robot nem radioaktív vagy vízjég nyersanyagot tartalmazó aszteroidát fúr
     */
    public void robotDiggingNotRadioactiveOrWatericeAsteroid() {
        System.out.println("robotDiggingNotRadioactiveOrWatericeAsteroid");
        FunctionPrinter.register(AI.getInstance(), "ai");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        Coal coal = new Coal();
        FunctionPrinter.register(coal, "coal");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(robot);
        asteroid.setResource(coal);
        robot.dig();
    }

    /**
     * 5.3.16-os szekvencia és a 5.4.16-os kommunikációs diagram írja le
     * Azt modellezi le, hogy egy robot radioaktív nyersanyagot tartalmazó aszteroidát fúr
     */
    public void robotDiggingRadioactiveAsteroid() {
        System.out.println("robotDiggingRadioactiveAsteroid");
        FunctionPrinter.register(AI.getInstance(), "ai");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        Uran uran = new Uran();
        FunctionPrinter.register(uran, "uran");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(robot);
        asteroid.setResource(uran);
        robot.dig();
    }

    /**
     * 5.3.15-ös szekvencia és a 5.4.15-ös kommunikációs diagram írja le
     * Azt modellezi le, hogy egy robot vízjeget tartalmazó aszteroidát fúr
     */
    public void robotDiggingWatericeAsteroid() {
        System.out.println("robotDiggingWatericeAsteroid");
        FunctionPrinter.register(AI.getInstance(), "ai");
        Robot robot = new Robot();
        FunctionPrinter.register(robot, "robot");
        WaterIce waterice = new WaterIce();
        FunctionPrinter.register(waterice, "waterice");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(robot);
        asteroid.setResource(waterice);
        robot.dig();
    }

    /**
     * 5.3.14-es szekvencia és a 5.4.14-es kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes nem radioaktív vagy vízjég nyersanyagot tartalmazó aszteroidát fúr
     */
    public void settlerDiggingNotRadioactiveOrWatericeAsteroid() {
        System.out.println("settlerDiggingNotRadioactiveOrWatericeAsteroid");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Coal coal = new Coal();
        FunctionPrinter.register(coal, "coal");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(settler);
        asteroid.setResource(coal);
        settler.dig();
    }

    /**
     * 5.3.13-as szekvencia és a 5.4.13-as kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes radioaktív nyersanyagot tartalmazó aszteroidát fúr
     */
    public void settlerDiggingRadioactiveAsteroid() {
        System.out.println("settlerDiggingRadioactiveAsteroid");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        Uran uran = new Uran();
        FunctionPrinter.register(uran, "uran");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        asteroid.addEntity(settler);
        asteroid.setResource(uran);
        settler.dig();
    }

    /**
     * 5.3.15-ös szekvencia és a 5.4.15-ös kommunikációs diagram írja le
     * Azt modellezi le, hogy egy telepes vízjég nyersanyagot tartalmazó aszteroidát fúr
     */
    public void settlerDiggingWatericeAsteroid() {
        System.out.println("settlerDiggingWatericeAsteroid");
        Asteroid asteroid = new Asteroid();
        FunctionPrinter.register(asteroid, "asteroid");
        Settler settler = new Settler(null, null);
        FunctionPrinter.register(settler, "settler");
        WaterIce waterice = new WaterIce();
        FunctionPrinter.register(waterice, "waterice");
        asteroid.addEntity(settler);
        asteroid.setResource(waterice);
        settler.dig();
    }

}
