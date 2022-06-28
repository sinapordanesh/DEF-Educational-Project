package edu.def.mvc;

import java.util.ArrayList;
import java.util.UUID;
/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */


/**
 * This is the Model class which should act as a database in this program.
 * This model is pretty simple, and we can hold the whole data on a simple ArrayList.
 * In complicated versions, Model class should connect with an external database.
 */
public class Model {

    private ArrayList<UUID> uuids;

    Model(){
        uuids = new ArrayList<>();
    }

    public void setUuids(ArrayList<UUID> uuids) {
        this.uuids = uuids;
    }

    public ArrayList<UUID> getUuids() {
        return uuids;
    }

    public void addUuid(UUID uuid){
        this.uuids.add(uuid);
    }

    public void clearModel(){
        this.uuids.clear();
    }
}
