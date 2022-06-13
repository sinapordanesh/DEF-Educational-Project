package edu.def.mvc;

import edu.def.mvc.uuid.GenerateUuid;

import java.util.UUID;

public class Controller {

    private Model model;
    private View view;
    private GenerateUuid generateUuid;

    Controller(Model model, View view, GenerateUuid uuid){
        this.model = model;
        this.view = view;
        this.generateUuid = uuid;
    }

    public void start(){
        this.view.setup(this);
        this.view.startMainLoop();
    }

    public void handleClickGenerateUuid(){
        this.model.addUuid(this.generateUuid.generateUuid());
    }

    public void handleClickClearList(){
        this.model.clearModel();
        this.view.clearList();
    }

    public Model getModel() {
        return model;
    }
}
