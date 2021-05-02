package graphics;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class WorkerController  implements PropertyChangeListener  {
    public abstract void propertyChange(PropertyChangeEvent evt);
}
