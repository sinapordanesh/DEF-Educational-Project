package edu.def.mvc;

import javax.swing.*;
import java.util.UUID;

public interface View {
    public void setup(Controller controller);
    public void list();
    public JButton appendToList();
    public JButton clearList();
    public void startMainLoop();
}
