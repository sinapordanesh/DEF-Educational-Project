package edu.def.mvc.uuid;

import java.util.UUID;

public class Uuid4 implements GenerateUuid{

    @Override
    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
