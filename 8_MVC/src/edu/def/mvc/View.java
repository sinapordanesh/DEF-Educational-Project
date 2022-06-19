/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import javax.swing.*;
import java.util.UUID;

public abstract class View {
    public abstract void setup(Controller controller);
    public abstract void appendToList(UUID item);
    public abstract void clearList();
    public abstract void  startMainLoop();
}
