package edu.def.mvc;

import java.util.ArrayList;
import java.util.UUID;

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
