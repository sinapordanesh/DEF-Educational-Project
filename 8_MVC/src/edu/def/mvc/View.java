/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import javax.swing.*;
import java.util.UUID;

public interface View {
    public void setup(Controller controller);
    public void list();
    public JButton appendToList();
    public JButton clearList();
}
