package graphics;

import game_classes.Worker;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class WorkerController  implements PropertyChangeListener  {
    public abstract void propertyChange(PropertyChangeEvent evt);
}
