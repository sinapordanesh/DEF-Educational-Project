/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc.uuid;

import java.util.UUID;

/**
 * Interface for all UUIDs generators classes.
 * Only contains one method for generating a kind of UUIDs.
 */
public interface GenerateUuid {
    public UUID generateUuid();
}
