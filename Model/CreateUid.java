package Model;

import java.util.UUID;

public class CreateUid {
    
    public static String newUid() {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        return uuidAsString;
    }

}
