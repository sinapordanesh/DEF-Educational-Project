package edu.def.mvc.uuid;

import java.util.UUID;

/**
 * A class which implements GenerateUuid interface to generate a
 * kind of uuid
 */
public class Uuid4 implements GenerateUuid{

    @Override
    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
