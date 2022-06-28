package edu.def.op;

public class Reusable {
    public void test(){
        System.out.println("Using object " + System.identityHashCode(this));
    }
}
