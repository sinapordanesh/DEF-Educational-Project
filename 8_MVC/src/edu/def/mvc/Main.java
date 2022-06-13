package edu.def.mvc;

import edu.def.mvc.uuid.Uuid1;
import edu.def.mvc.uuid.Uuid4;
import edu.def.mvc.uuid.UuidString;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(
                new Model(),
                new GUI(),
                new Uuid4()
                );
        controller.start();
    }
}
