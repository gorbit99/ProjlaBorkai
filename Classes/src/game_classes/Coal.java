package game_classes;

/**
 * This class represents the coal. It extends from material.
 */
public class Coal extends Material{
    /**
     * This is the constructor of the coal.
     */
    public Coal(){
        TestLogger.EnterFunction("Coal.ctor");
        TestLogger.ExitFunction();
    }

    /**
     *
     * @return The class name.
     */
    public String toString(){
        return "Coal";
    }
}
