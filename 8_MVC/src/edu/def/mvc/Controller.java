/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import edu.def.mvc.uuid.GenerateUuid;

import java.util.UUID;

/**
 * Controller class
 */
public class Controller {

    private Model model;
    private View view;
    private GenerateUuid generateUuid;

    Controller(Model model, View view, GenerateUuid uuid){
        this.model = model;
        this.view = view;
        this.generateUuid = uuid;
    }

    //start the initial UI
    public void start(){
        this.view.setup(this);
    }

    //handle "Generate UUID" button and
    public void handleClickGenerateUuid(){
        this.model.addUuid(this.generateUuid.generateUuid());
    }

    //handle "Clear list" button and
    public void handleClickClearList(){
        this.model.clearModel();
        this.view.clearList();
    }

    //getting the Model object to use its data
    public Model getModel() {
        return model;
    }
}
