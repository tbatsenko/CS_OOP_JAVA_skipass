import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Date;

public class SkipassUsageTest {
    SkipassSystem system = new SkipassSystem();

    @Test
    public void test1DaySkipass() {
        Skipass skipass = SkipassFactory.skipassFor1Day();
        assert Turniket.checkSkipass(skipass);
    }

    @Test
    public void test10RidesSkipass() {
        Skipass skipass = SkipassFactory.skipassFor10Rides();
        for (int i = 0; i < 15; i++){
            if(!Turniket.checkSkipass(skipass)){
                SkipassSystem.blockSkipass(skipass.getUniqueID());
            };
        };
        assert(skipass.isBlocked());
    }

}
