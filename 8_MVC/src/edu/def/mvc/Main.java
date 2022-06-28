/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import edu.def.mvc.uuid.Uuid1;
import edu.def.mvc.uuid.Uuid4;
import edu.def.mvc.uuid.UuidString;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(
                new Model(),
                new SwingView(),
                new Uuid4()
                );
        controller.start();
    }
}
