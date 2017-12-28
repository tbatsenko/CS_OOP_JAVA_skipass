import java.time.LocalDateTime;
import java.util.HashMap;

public class SkipassSystem {
    private static HashMap<String, Skipass> skipasses;

    SkipassSystem(){
        skipasses = new HashMap<>();
    }

    public static void addSkipass(Skipass skipass) {
        skipasses.put(skipass.getUniqueID(), skipass);
    }

    public static Skipass findSkipass(String uid) {
        return skipasses.get(uid);
    }

    public static void blockSkipass(String uid) {
        findSkipass(uid).block();
    }

    public static void logSkipassUsage(Skipass skipass, boolean operationStatus) {
        if(operationStatus) {
            System.out.format("Skipass %s was used successfully at %s \n", skipass.getUniqueID(), LocalDateTime.now());
        } else {
            System.out.format("Skipass %s was blocked at %s \n", skipass.getUniqueID(), LocalDateTime.now());
        }
    }
}
