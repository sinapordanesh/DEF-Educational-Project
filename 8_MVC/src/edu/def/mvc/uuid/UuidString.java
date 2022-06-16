/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc.uuid;

import java.util.UUID;

/**
 * A class which implements GenerateUuid interface to generate a
 * kind of uuid
 */
public class UuidString implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        return UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
    }
}
