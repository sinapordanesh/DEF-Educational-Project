package edu.def.mvc;

import java.util.UUID;

public interface View {
    public void setup(Controller controller);
    public void appendToList();
    public void clearList();
    public void startMainLoop();
}
