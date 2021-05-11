package graphics;

import game_classes.Worker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Abstract base class for the worker controllers
 */
public abstract class WorkerController  implements PropertyChangeListener  {
    /**
     * Every controller should implement this event handler
     * @param evt
     */
    public abstract void propertyChange(PropertyChangeEvent evt);
}
