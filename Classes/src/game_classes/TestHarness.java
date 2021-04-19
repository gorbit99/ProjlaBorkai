package game_classes;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Interprets and runs the tests
 */
public class TestHarness {
    /**
     * Input scanner
     */
    protected final Scanner inputScanner;
    /**
     * Output writer
     */
    protected final Writer outputWriter = new OutputStreamWriter(System.out);
    /**
     * Hashmap of the workers
     */
    protected final HashMap<String, Worker> workers = new HashMap<>();
    /**
     * Hashmap of the astronauts
     */
    protected final HashMap<String, Astronaut> astronauts = new HashMap<>();
    /**
     * Hashmap of the robots
     */
    protected final HashMap<String, Robot> robots = new HashMap<>();
    /**
     * Hashmap of the ufos
     */
    protected final HashMap<String, Ufo> ufos = new HashMap<>();
    /**
     * Hashmap of the spaceobjects
     */
    protected final HashMap<String, SpaceObject> spaceobjects = new HashMap<>();
    /**
     * Hashmap of the asteroids
     */
    protected final HashMap<String, Asteroid> asteroids = new HashMap<>();
    /**
     * Hashmap of the teleporters
     */
    protected final HashMap<String, Teleporter> teleporters = new HashMap<>();
    /**
     * Hashmap of the materials
     */
    protected final HashMap<String, Material> materials = new HashMap<>();

    /**
     * Constructs a test harness
     */
    public TestHarness() {
        inputScanner = new Scanner(System.in);
    }

    /**
     * Constructs a test harness with a specified input stream
     *
     * @param stream The input stream the tests are going to be read from
     */
    public TestHarness(InputStream stream) {
        inputScanner = new Scanner(stream);
    }

    /**
     * Find a key by a value in a hashmap
     *
     * @param map   The hashmap
     * @param value The value to find
     * @param <K>   Key
     * @param <V>   Value
     * @return The key of the entry
     */
    protected <K, V> K reverseMap(HashMap<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Runs the testcase
     *
     * @throws TestException An exception happened inside the testcase
     */
    public void run() throws TestException {
        int lineNo = 1;
        inputScanner.nextLine();
        while (inputScanner.hasNextLine()) {
            lineNo++;
            String line = inputScanner.nextLine();
            int commentIndex = line.indexOf('#');
            if (commentIndex != -1) {
                line = line.substring(0, commentIndex);
            }

            if (line.isBlank()) {
                continue;
            }

            String[] args = line.split(" ");
            if (args.length == 0) {
                continue;
            }

            Command command = null;
            switch (args[0]) {
                case "import":
                    command = new ImportCommand(args, lineNo);
                    break;
                case "create":
                    command = new CreateCommand(args, lineNo);
                    break;
                case "execute":
                    command = new ExecuteCommand(args, lineNo);
                    break;
                case "astronaut":
                    command = new AstronautCommand(args, lineNo);
                    break;
                case "asteroidField":
                    command = new AsteroidFieldCommand(args, lineNo);
                    break;
                case "teleporter":
                    command = new TeleporterCommand(args, lineNo);
                    break;
                case "asteroid":
                    command = new AsteroidCommand(args, lineNo);
                    break;
                case "uranium":
                    command = new UraniumCommand(args, lineNo);
                    break;
                case "solarStorm":
                    command = new SolarStormCommand(args, lineNo);
                    break;
                case "game":
                    command = new GameCommand(args, lineNo);
                    break;
                case "print":
                    try {
                        outputWriter.write(line.substring(line.indexOf(' ')));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "printState":
                    command = new PrintStateCommand(args, lineNo);
                    break;
                default:
                    throw new MalformedTestException("Unknown command!", lineNo);
            }
            if (command != null) {
                command.run();
            }
        }
    }

    /**
     * An exception from a testcase
     */
    abstract static class TestException extends Exception {
        /**
         * The line the exception happened on
         */
        protected int lineNo;

        /**
         * The constructor of the exception
         *
         * @param message The exception message
         * @param lineNo  The line the exception is on
         */
        public TestException(String message, int lineNo) {
            super(message);
            this.lineNo = lineNo;
        }
    }

    /**
     * Incorrectly formed test exception
     * Extends TestException
     */
    static class MalformedTestException extends TestException {
        /**
         * The constructor
         *
         * @param message The exception message
         * @param lineNo  The line the exception happened on
         */
        public MalformedTestException(String message, int lineNo) {
            super(message, lineNo);
        }

        /**
         * Turns the exception into a printable message
         *
         * @return The exception message
         */
        @Override
        public String toString() {
            return getMessage() + "\n"
                    + "On line: " + lineNo;
        }
    }

    /**
     * Invalid argument test exception
     * Extends TestException
     */
    static class TestArgumentException extends TestException {
        /**
         * The format of the command
         */
        private final String usage;

        /**
         * The constructor
         *
         * @param message The message of the exception
         * @param lineNo  The line the exception happened on
         * @param usage   The format of the command
         */
        public TestArgumentException(String message, int lineNo, String usage) {
            super(message, lineNo);
            this.usage = usage;
        }

        /**
         * Turns the exception into a printable message
         *
         * @return The exception message
         */
        @Override
        public String toString() {
            return getMessage() + "\n"
                    + "On line: " + lineNo + "\n"
                    + "Usage: " + usage;
        }
    }

    /**
     * The base class for commands
     */
    abstract class Command {
        /**
         * The constructor
         *
         * @param args   The command arguments
         * @param lineNo The line the command is on
         */
        public Command(String[] args, int lineNo) {
            this.args = args;
            this.lineNo = lineNo;
        }

        /**
         * Runs the command
         *
         * @throws TestException Something went wrong while running the command
         */
        public abstract void run() throws TestException;

        /**
         * Validates the arguments
         *
         * @param usage The format of the command
         * @throws TestArgumentException Incorrect arguments were provided to the command
         */
        protected void validateArgs(String usage) throws TestArgumentException {
            if (args.length != usage.split(" ").length) {
                throw new TestArgumentException("Incorrect number of arguments", lineNo, usage);
            }
        }

        /**
         * Checks for a worker's existence
         *
         * @param workerId The worker's ID
         * @param exists   True: The worker needs to exist, False: The worker must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateWorker(String workerId, boolean exists) throws MalformedTestException {
            if (workers.containsKey(workerId) != exists) {
                throw new MalformedTestException("The entity-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for an astronaut's existence
         *
         * @param astronautId The astronaut's ID
         * @param exists      True: The astronaut needs to exist, False: The astronaut must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateAstronaut(String astronautId, boolean exists) throws MalformedTestException {
            if (astronauts.containsKey(astronautId) != exists) {
                throw new MalformedTestException("The astronaut-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for a robot's existence
         *
         * @param robotId The robot's ID
         * @param exists  True: The robot needs to exist, False: The robot must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateRobot(String robotId, boolean exists) throws MalformedTestException {
            if (robots.containsKey(robotId) != exists) {
                throw new MalformedTestException("The robot-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for a ufo's existence
         *
         * @param ufoId  The ufo's ID
         * @param exists True: The ufo needs to exist, False: The ufo must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateUfo(String ufoId, boolean exists) throws MalformedTestException {
            if (ufos.containsKey(ufoId) != exists) {
                throw new MalformedTestException("The ufo-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for a spaceobject's existence
         *
         * @param spaceobjectId The spaceobject's ID
         * @param exists        True: The spaceobject needs to exist, False: The spaceobject must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateSpaceobject(String spaceobjectId, boolean exists) throws MalformedTestException {
            if (spaceobjects.containsKey(spaceobjectId) != exists) {
                throw new MalformedTestException("The spaceobject-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for an asteroid's existence
         *
         * @param asteroidId The asteroid's ID
         * @param exists     True: The asteroid needs to exist, False: The asteroid must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateAsteroid(String asteroidId, boolean exists) throws MalformedTestException {
            if (asteroids.containsKey(asteroidId) != exists) {
                throw new MalformedTestException("The asteroid-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for a teleporter's existence
         *
         * @param teleporterId The teleporter's ID
         * @param exists       True: The teleporter needs to exist, False: The teleporter must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateTeleporter(String teleporterId, boolean exists) throws MalformedTestException {
            if (teleporters.containsKey(teleporterId) != exists) {
                throw new MalformedTestException("The teleporter-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * Checks for a material's existence
         *
         * @param materialId The material's ID
         * @param exists     True: The material needs to exist, False: The material must not exist
         * @throws MalformedTestException The requirement wasn't met
         */
        protected void validateMaterial(String materialId, boolean exists) throws MalformedTestException {
            if (materials.containsKey(materialId) != exists) {
                throw new MalformedTestException("The material-id " + (exists ? "doesn't exist" : "already exists") + "!", lineNo);
            }
        }

        /**
         * The arguments of the command
         */
        protected String[] args;
        /**
         * The line the command is on
         */
        protected int lineNo;
    }

    /**
     * The import command
     * Extends from Command
     */
    class ImportCommand extends Command {
        /**
         * The constructor
         *
         * @param args   The arguments
         * @param lineNo The line the command is on
         */
        public ImportCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Imports the file.
         *
         * @throws MalformedTestException The specified file doesn't exist
         * @throws TestArgumentException  The arguments provided were incorrect
         * @throws TestException          Something went wrong in the underlying testcase
         */
        @Override
        public void run() throws TestException {
            validateArgs("import <filename>");
            try {
                TestHarness testHarness = new TestHarness(new FileInputStream(args[1]));
                testHarness.run();
            } catch (FileNotFoundException e) {
                throw new MalformedTestException("Import file doesn't exist!", lineNo);
            }
        }
    }

    /**
     * The create command
     */
    class CreateCommand extends Command {
        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public CreateCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was  unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws MalformedTestException, TestArgumentException {
            switch (args[1]) {
                case "astronaut":
                    validateArgs("create astronaut <astronaut-id> <asteroid-id>");
                    validateWorker(args[2], false);
                    validateAsteroid(args[3], true);
                    Astronaut astronaut = new Astronaut(asteroids.get(args[3]));
                    astronauts.put(args[2], astronaut);
                    workers.put(args[2], astronaut);
                    break;
                case "robot":
                    validateArgs("create robot <robot-id> <asteroid-id>");
                    validateWorker(args[2], false);
                    validateAsteroid(args[3], true);
                    Robot robot = new Robot(asteroids.get(args[3]));
                    robots.put(args[2], robot);
                    workers.put(args[2], robot);
                    break;
                case "ufo":
                    validateArgs("create ufo <ufo-id> <asteroid-id>");
                    validateWorker(args[2], false);
                    validateAsteroid(args[3], true);
                    Ufo ufo = new Ufo(asteroids.get(args[3]));
                    ufos.put(args[2], ufo);
                    workers.put(args[2], ufo);
                    break;
                case "asteroid":
                    validateArgs("create asteroid <asteroid-id>");
                    validateSpaceobject(args[2], false);
                    Asteroid asteroid = new Asteroid();
                    asteroids.put(args[2], asteroid);
                    spaceobjects.put(args[2], asteroid);
                    break;
                case "teleporter":
                    validateArgs("create teleporter <teleporter-id>");
                    validateSpaceobject(args[2], false);
                    Teleporter teleporter = new Teleporter();
                    teleporters.put(args[2], teleporter);
                    spaceobjects.put(args[2], teleporter);
                    break;
                case "material":
                    validateArgs("create material <material-id> [coal/iron/uranium/ice]");
                    validateMaterial(args[2], false);
                    switch (args[3]) {
                        case "coal":
                            Coal coal = new Coal();
                            materials.put(args[2], coal);
                            break;
                        case "iron":
                            Iron iron = new Iron();
                            materials.put(args[2], iron);
                            break;
                        case "uranium":
                            Uranium uranium = new Uranium();
                            materials.put(args[2], uranium);
                            break;
                        case "ice":
                            Ice ice = new Ice();
                            materials.put(args[2], ice);
                            break;
                        default:
                            throw new MalformedTestException("Material type is not one of [coal/iron/uranium/ice]", lineNo);
                    }
                    break;
                default:
                    throw new MalformedTestException("Unknown command subtype!", lineNo);
            }
        }
    }

    /**
     * The execute command
     */
    class ExecuteCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public ExecuteCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Run the command
         *
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         * @throws MalformedTestException The command subtype was unknown
         */
        @Override
        public void run() throws TestArgumentException, MalformedTestException {
            switch (args[1]) {
                case "move": {
                    validateArgs("execute move <entity-id> <spaceobject-id>");
                    validateWorker(args[2], true);
                    validateSpaceobject(args[3], true);
                    Worker worker = workers.get(args[2]);
                    SpaceObject spaceObject = spaceobjects.get(args[3]);
                    for (int i = 0; i < worker.position.neighbours.size(); i++) {
                        if (spaceObject == worker.position.neighbours.get(i)) {
                            MockIO.in.addInput((i + 1) + "\n");
                            worker.Move();
                            return;
                        }
                    }
                    throw new MalformedTestException("The entity can't move to the specified spaceobject!", lineNo);
                }
                case "drill": {
                    validateArgs("execute drill <entity-id>");
                    validateWorker(args[2], true);
                    Worker worker = workers.get(args[2]);
                    try {
                        worker.Drill();
                    } catch (Exception ignored) {
                    }
                    break;
                }
                case "mine": {
                    validateArgs("execute mine <astronaut-id>");
                    validateAstronaut(args[2], true);
                    Astronaut astronaut = astronauts.get(args[2]);
                    try {
                        astronaut.Mine();
                    } catch (Exception ignored) {
                    }
                    break;
                }
                case "placeMaterial": {
                    validateArgs("execute placeMaterial <astronaut-id> <material-id>");
                    validateAstronaut(args[2], true);
                    validateMaterial(args[3], true);

                    Astronaut astronaut = astronauts.get(args[2]);
                    Material material = materials.get(args[3]);

                    for (int i = 0; i < astronaut.GetStoredMaterials().size(); i++) {
                        if (astronaut.GetStoredMaterials().get(i) == material) {
                            MockIO.in.addInput((i + 1) + "\n");
                            try {
                                astronaut.PlaceMaterial();
                            } catch (Exception ignored) {
                            }
                            return;
                        }
                    }
                    throw new MalformedTestException("The material specified doesn't belong to the astronaut!", lineNo);
                }
                case "placeTeleporter": {
                    validateArgs("execute placeTeleporter <astronaut-id> <teleporter-id>");
                    validateAstronaut(args[2], true);
                    validateTeleporter(args[3], true);

                    Astronaut astronaut = astronauts.get(args[2]);
                    Teleporter teleporter = teleporters.get(args[3]);

                    for (int i = 0; i < astronaut.GetTeleporters().size(); i++) {
                        if (astronaut.GetTeleporters().get(i) == teleporter) {
                            MockIO.in.addInput((i + 1) + "\n");
                            try {
                                astronaut.PlaceTeleporter();
                            } catch (Exception ignored) {
                            }
                            return;
                        }
                    }
                    throw new MalformedTestException("The teleporter specified doesn't belong to the astronaut!", lineNo);
                }
                case "createRobot": {
                    validateArgs("execute createRobot <astronaut-id> <robot-id>");
                    validateAstronaut(args[2], true);
                    validateRobot(args[3], false);

                    Astronaut astronaut = astronauts.get(args[2]);
                    try {
                        astronaut.CreateRobot();
                        Asteroid astronautPos = astronaut.position;
                        for (Worker w : astronautPos.GetWorkers()) {
                            if (!workers.containsValue(w)) {
                                Robot r = (Robot) w;
                                robots.put(args[3], r);
                                workers.put(args[3], r);
                                break;
                            }
                        }
                    } catch (Exception ignored) {
                    }
                    break;
                }
                case "createTeleporter": {
                    validateArgs("execute createTeleporter <astronaut-id> <teleporter-id> <teleporter-id>");
                    validateAstronaut(args[2], true);
                    validateTeleporter(args[3], false);
                    validateTeleporter(args[4], false);

                    Astronaut astronaut = astronauts.get(args[2]);
                    try {
                        astronaut.CreateTeleporter();
                        boolean args3taken = false;
                        for (Teleporter t : astronaut.GetTeleporters()) {
                            if (!teleporters.containsValue(t)) {
                                if (!args3taken) {
                                    teleporters.put(args[3], t);
                                    spaceobjects.put(args[3], t);
                                    args3taken = true;
                                } else {
                                    teleporters.put(args[4], t);
                                    spaceobjects.put(args[4], t);
                                    break;
                                }
                            }
                        }
                    } catch (Exception ignored) {
                    }

                    break;
                }
                case "steal": {
                    validateArgs("execute steal <ufo-id>");
                    validateUfo(args[2], true);

                    Ufo ufo = ufos.get(args[2]);
                    ufo.Steal();
                    break;
                }
                case "solarStorm": {
                    validateArgs("execute solarStorm <spaceobject-id>");
                    validateSpaceobject(args[2], true);

                    SpaceObject spaceObject = spaceobjects.get(args[2]);
                    spaceObject.HandleSolarStorm();
                    break;
                }
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "execute [move/drill/mine/placeMaterial/placeTeleporter/createRobot/createTeleporter/steal/solarStorm]");
            }
        }
    }

    /**
     * The astronaut command
     */
    class AstronautCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public AstronautCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws MalformedTestException, TestArgumentException {
            validateAstronaut(args[1], true);
            Astronaut astronaut = astronauts.get(args[1]);

            switch (args[2]) {
                case "addMaterial":
                    validateArgs("astronaut <astronaut-id> addMaterial <material-id>");
                    validateMaterial(args[3], true);

                    Material material = materials.get(args[3]);
                    astronaut.GetStoredMaterials().add(material);
                    break;
                case "addTeleporter":
                    validateArgs("astronaut <astronaut-id> addTeleporter <teleporter-id>");
                    validateTeleporter(args[3], true);

                    Teleporter teleporter = teleporters.get(args[3]);
                    astronaut.GetTeleporters().add(teleporter);
                    break;
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "astronaut <astronaut-id> [addMaterial/addTeleporter]");
            }
        }
    }

    /**
     * The asteroidField command
     */
    class AsteroidFieldCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public AsteroidFieldCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            switch (args[1]) {
                case "move":
                    AsteroidField.GetInstance().Move();
                    break;
                case "handleSolarStorm":
                    AsteroidField.GetInstance().HandleSolarStorm();
                    break;
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "asteroidField [move/handleSolarStorm]");
            }
        }
    }

    class TeleporterCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public TeleporterCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            validateTeleporter(args[1], true);
            Teleporter teleporter = teleporters.get(args[1]);

            switch (args[2]) {
                case "linkTo":
                    validateArgs("teleporter <teleporter-id> linkTo <teleporter-id>");
                    validateTeleporter(args[3], true);
                    Teleporter teleporter2 = teleporters.get(args[3]);
                    teleporter.LinkTo(teleporter2);
                    break;
                case "place":
                    validateArgs("teleporter <teleporter-id> place <asteroid-id>");
                    validateAsteroid(args[3], true);
                    Asteroid asteroid = asteroids.get(args[3]);
                    teleporter.Place(asteroid);
                    break;
                case "break":
                    teleporter.SetBroken(true);
                    break;
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "teleporter <teleporter-id> [linkTo/place/break]");
            }
        }
    }

    /**
     * The asteroid command
     */
    class AsteroidCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public AsteroidCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            validateAsteroid(args[1], true);

            Asteroid asteroid = asteroids.get(args[1]);
            switch (args[2]) {
                case "setCore":
                    validateArgs("asteroid <asteroid-id> setCore <material-id>");
                    validateMaterial(args[3], true);

                    Material material = materials.get(args[3]);
                    asteroid.SetCore(material);
                    break;
                case "addNeighbour":
                    validateArgs("asteroid <asteroid-id> addNeighbour <asteroid-id>");
                    validateAsteroid(args[3], true);
                    Asteroid neighbour = asteroids.get(args[3]);
                    asteroid.GetNeighbours().add(neighbour);
                    break;
                case "handleSolarStorm":
                    validateArgs("asteroid <asteroid-id> handleSolarStorm");
                    asteroid.HandleSolarStorm();
                    break;
                case "setLayers":
                    validateArgs("asteroid <asteroid-id> setLayers <integer>");
                    int layers = Integer.parseInt(args[3]);
                    asteroid.SetLayers(layers);
                    break;
                case "setDistance":
                    validateArgs("asteroid <asteroid-id> setDistance <integer>");
                    int distance = Integer.parseInt(args[3]);
                    asteroid.SetDistance(distance);
                    break;
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "asteroid <asteroid-id> [setCore/addNeighbour/handleSolarStorm/setLayers/setDistance]");
            }
        }
    }

    /**
     * The uranium command
     */
    class UraniumCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public UraniumCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            validateMaterial(args[1], true);
            Uranium uranium = (Uranium) materials.get(args[1]);

            if (args[2].equals("setExposure")) {
                validateArgs("uranium <uranium-id> setExposure <integer>");
                int exposure = Integer.parseInt(args[3]);
                uranium.SetExposure(exposure);
            } else {
                throw new TestArgumentException("Unknown command subtype!", lineNo, "uranium <uranium-id> setExposure <integer>");
            }
        }
    }

    /**
     * The solarStorm command
     */
    class SolarStormCommand extends Command {

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public SolarStormCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            SolarStorm solarStorm = Game.GetInstance().GetSolarStorm();

            switch (args[1]) {
                case "setTimeTillHit":
                    validateArgs("solarStorm setTimeTillHit <integer>");
                    int time = Integer.parseInt(args[2]);
                    solarStorm.SetTimeTillHit(time);
                    break;
                case "tick":
                    validateArgs("solarStorm tick");
                    solarStorm.Tick();
                    break;
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "solarStorm [setTimeTillHit/tick]");
            }
        }
    }

    /**
     * The game command
     */
    class GameCommand extends Command {
        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public GameCommand(String[] args, int lineNo) {
            super(args, lineNo);
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            switch (args[1]) {
                case "doRound": {
                    String instructions = Arrays.stream(args).skip(2).collect(Collectors.joining(" "));
                    for (String line : instructions.split(";")) {
                        MockIO.in.addInput(line + "\n");
                    }
                    Game.GetInstance().DoRound();
                    break;
                }
                case "checkWinOrLose":
                    Game.GetInstance().CheckWinOrLose();
                    break;
                case "startGame": {
                    String instructions = Arrays.stream(args).skip(2).collect(Collectors.joining(" "));
                    for (String line : instructions.split(";")) {
                        MockIO.in.addInput(line + "\n");
                    }
                    Game.GetInstance().StartGame();
                    break;
                }
                default:
                    throw new TestArgumentException("Unknown command subtype!", lineNo, "game [doRound/checkWinOrLose/startGame]");
            }
        }
    }

    /**
     * The printState command
     */
    class PrintStateCommand extends Command {
        /**
         * The asteroids that actually exist in-game
         */
        TreeSet<Asteroid> realAsteroids = new TreeSet<>(Comparator.comparing(x -> reverseMap(asteroids, x)));
        /**
         * The teleporters that actually exist in-game
         */
        TreeSet<Teleporter> realTeleporters = new TreeSet<>(Comparator.comparing(x -> reverseMap(teleporters, x)));
        /**
         * The astronauts that actually exist in-game
         */
        TreeSet<Astronaut> realAstronauts = new TreeSet<>(Comparator.comparing(x -> reverseMap(astronauts, x)));
        /**
         * The robots that actually exist in-game
         */
        TreeSet<Robot> realRobots = new TreeSet<>(Comparator.comparing(x -> reverseMap(robots, x)));
        /**
         * The ufos that actually exist in-game
         */
        TreeSet<Ufo> realUfos = new TreeSet<>(Comparator.comparing(x -> reverseMap(ufos, x)));
        /**
         * The materials that actually exist in-game
         */
        TreeSet<Material> realMaterials = new TreeSet<>(Comparator.comparing(x -> reverseMap(materials, x)));

        /**
         * The constructor
         *
         * @param args   The arguments of the command
         * @param lineNo The line the command is on
         */
        public PrintStateCommand(String[] args, int lineNo) {
            super(args, lineNo);

            for (SpaceObject spaceObject : AsteroidField.GetInstance().GetObjects()) {
                if (spaceObject instanceof Asteroid) {
                    realAsteroids.add((Asteroid) spaceObject);
                } else if (spaceObject instanceof Teleporter) {
                    realTeleporters.add((Teleporter) spaceObject);
                }
            }

            for (Worker worker : Game.GetInstance().GetWorkers()) {
                if (worker instanceof Astronaut) {
                    realAstronauts.add((Astronaut) worker);
                } else if (worker instanceof Robot) {
                    realRobots.add((Robot) worker);
                } else if (worker instanceof Ufo) {
                    realUfos.add((Ufo) worker);
                }
            }

            for (Asteroid asteroid : realAsteroids) {
                if (asteroid.GetCore() != null) {
                    realMaterials.add(asteroid.GetCore());
                }
            }

            for (Astronaut astronaut : realAstronauts) {
                realTeleporters.addAll(astronaut.GetTeleporters());
                realMaterials.addAll(astronaut.GetStoredMaterials());
            }
        }

        /**
         * Print the state of the asteroids
         *
         * @throws IOException An error happened while printing
         */
        private void printAsteroids() throws IOException {
            outputWriter.write("Asteroids:\n");
            for (Asteroid asteroid : realAsteroids) {
                String key = reverseMap(asteroids, asteroid);
                outputWriter.write("\t" + key + ":\n");

                ArrayList<String> workerIds = new ArrayList<>();
                for (Worker worker : asteroid.GetWorkers()) {
                    workerIds.add(reverseMap(workers, worker));
                }
                outputWriter.write("\t\tworkers: " + String.join(", ", workerIds) + "\n");

                String core = asteroid.GetCore() == null ? "null" : reverseMap(materials, asteroid.GetCore());
                outputWriter.write("\t\tcore: " + core + "\n");

                outputWriter.write("\t\tlayers: " + asteroid.GetLayers() + "\n");

                ArrayList<String> neighbourIds = new ArrayList<>();
                for (SpaceObject neighbour : asteroid.GetNeighbours()) {
                    neighbourIds.add(reverseMap(spaceobjects, neighbour));
                }
                outputWriter.write("\t\tneighbours: " + String.join(", ", neighbourIds) + "\n");

                outputWriter.write("\t\tdistanceFromSun: " + asteroid.GetDistance() + "\n");
            }
        }

        /**
         * Prints the state of the teleporters
         *
         * @throws IOException An error happened while printing
         */
        private void printTeleporters() throws IOException {
            outputWriter.write("Teleporters:\n");
            for (Teleporter teleporter : realTeleporters) {
                String key = reverseMap(teleporters, teleporter);
                outputWriter.write("\t" + key + ":\n");

                String parent = teleporter.GetParent() == null ? "not placed" : reverseMap(spaceobjects, teleporter.GetParent());
                outputWriter.write("\t\tparent: " + parent + "\n");

                String pair = teleporter.GetPair() == null ? "null" : reverseMap(teleporters, teleporter.GetPair());
                outputWriter.write("\t\tpair: " + pair + "\n");

                outputWriter.write("\t\tisBroken: " + teleporter.IsBroken() + "\n");
            }
        }

        /**
         * Prints the state of the astronauts
         *
         * @throws IOException An error happened while printing
         */
        private void printAstronauts() throws IOException {
            outputWriter.write("Astronauts:\n");
            for (Astronaut astronaut : realAstronauts) {
                String key = reverseMap(astronauts, astronaut);
                outputWriter.write("\t" + key + ":\n");

                ArrayList<String> materialIds = new ArrayList<>();
                for (Material material : astronaut.GetStoredMaterials()) {
                    materialIds.add(reverseMap(materials, material));
                }
                outputWriter.write("\t\tstoredMaterials: " + String.join(", ", materialIds) + "\n");

                ArrayList<String> teleporterIds = new ArrayList<>();
                for (Teleporter teleporter : astronaut.GetTeleporters()) {
                    teleporterIds.add(reverseMap(teleporters, teleporter));
                }
                outputWriter.write("\t\tteleporters: " + String.join(", ", teleporterIds) + "\n");

                outputWriter.write("\t\tposition: " + reverseMap(spaceobjects, astronaut.position) + "\n");
            }
        }

        /**
         * Prints the state of the robots
         *
         * @throws IOException An error happened while printing
         */
        private void printRobots() throws IOException {
            outputWriter.write("Robots:\n");

            for (Robot robot : realRobots) {
                String key = reverseMap(robots, robot);
                outputWriter.write("\t" + key + ":\n");

                outputWriter.write("\t\tposition: " + reverseMap(spaceobjects, robot.position) + "\n");
            }
        }

        /**
         * Prints the state of the ufos
         *
         * @throws IOException An error happened while printing
         */
        private void printUfos() throws IOException {
            outputWriter.write("UFOs:\n");

            for (Ufo ufo : realUfos) {
                String key = reverseMap(ufos, ufo);
                outputWriter.write("\t" + key + ":\n");

                outputWriter.write("\t\tposition: " + reverseMap(spaceobjects, ufo.position) + "\n");
            }
        }

        /**
         * Prints the state of the materials
         *
         * @throws IOException An error happened while printing
         */
        void printMaterials() throws IOException {
            outputWriter.write("Materials:\n");
            for (Material material : realMaterials) {
                String key = reverseMap(materials, material);
                outputWriter.write("\t" + key + ":\n");
                if (material instanceof Coal) {
                    outputWriter.write("\t\ttype: coal\n");
                } else if (material instanceof Iron) {
                    outputWriter.write("\t\ttype: iron\n");
                } else if (material instanceof Ice) {
                    outputWriter.write("\t\ttype: ice\n");
                } else if (material instanceof Uranium) {
                    outputWriter.write("\t\ttype: uranium\n");
                    outputWriter.write("\t\texposureCount: " + ((Uranium) material).GetExposure() + "\n");
                }
            }
        }

        /**
         * Prints the state of the solar storm
         *
         * @throws IOException An error happened while printing
         */
        private void printSolarStorm() throws IOException {
            outputWriter.write("SolarStorm:\n");
            outputWriter.write("\ttimeTillHit: " + Game.GetInstance().GetSolarStorm().GetTimeTillHit() + "\n");
        }

        /**
         * Runs the command
         *
         * @throws MalformedTestException The command subtype was unknown
         * @throws TestArgumentException  The arguments provided to the command were incorrect
         */
        @Override
        public void run() throws TestException {
            validateArgs("printState");

            try {
                if (Game.GetInstance().DidLose()) {
                    outputWriter.write("lose\n");
                } else if (Game.GetInstance().DidWin()) {
                    outputWriter.write("win\n");
                } else {
                    printAsteroids();
                    printTeleporters();
                    printAstronauts();
                    printRobots();
                    printUfos();
                    printMaterials();
                    printSolarStorm();
                }
                outputWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}