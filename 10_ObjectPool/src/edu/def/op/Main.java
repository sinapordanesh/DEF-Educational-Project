package edu.def.op;

public class Main {
    public static void main(String[] args) {
        ReusablePool pool = new ReusablePool(2);
        Reusable r = pool.acquire();
        Reusable r2 = pool.acquire();

        r.test();
        r2.test();

        pool.release(r2);
        Reusable r3 = pool.acquire();
        r3.test();
    }
}
