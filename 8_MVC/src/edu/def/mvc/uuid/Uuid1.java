package edu.def.mvc.uuid;

import java.util.UUID;

public class Uuid1 implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        byte[] byteName
                = { 50, 40, 30, 20, 10 };
        return UUID.nameUUIDFromBytes(byteName);
    }
}
