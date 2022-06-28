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
public class Uuid1 implements GenerateUuid{
    @Override
    public UUID generateUuid() {
        byte[] byteName
                = { 50, 40, 30, 20, 10 };
        return UUID.nameUUIDFromBytes(byteName);
    }
}
