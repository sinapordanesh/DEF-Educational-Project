package edu.def.op;

import java.util.ArrayList;

public class ReusablePool {

    private int size;
    private ArrayList<Reusable> free;
    private ArrayList<Reusable> inUse;

    ReusablePool(int size){
        this.size = size;
        this.free = new ArrayList<>();
        this.inUse = new ArrayList<>();

        for (int i = 0; i < size; i++){
            this.free.add(new Reusable());
        }
    }

    public Reusable acquire(){
        assert this.free.size() > 0;
        Reusable r = this.free.get(0);
        this.free.remove(r);
        this.inUse.add(r);

        return r;
    }

    public void release(Reusable r){
        this.inUse.remove(r);
        this.free.add(r);
    }
}
