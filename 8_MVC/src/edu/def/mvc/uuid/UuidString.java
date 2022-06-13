package edu.def.mvc.uuid;

import java.util.UUID;

public class UuidString implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        return UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
    }
}
