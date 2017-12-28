import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SkipassesFactoryTest {
    @Test
    public void addOneDaySkipass() { assert(SkipassFactory.skipassFor1Day().getDaysAmount() == DaysAmount.ONE);}

    @Test
    public void addTwoDaysSkipass() { assert(SkipassFactory.skipassFor2Days().type().endsWith("DaysSkipass"));}

    @Test
    public void add5DaysSkipass() {
        Calendar cal = Calendar.getInstance();
        Date dateNow = new Date();
        cal.setTime(dateNow);

        boolean nowIsHoliday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

        if (!nowIsHoliday)
            assert(SkipassFactory.skipassFor5Days().getDaysAmount() == DaysAmount.FIVE);
        else
            assert(SkipassFactory.skipassFor5Days().getDaysAmount() == DaysAmount.TWO);

    }

    @Test
    public void add10RidesSkipass() {
        assert(SkipassFactory.skipassFor10Rides().getRidesAmountLeft() == RidesAmount.TEN);
    }

    @Test
    public void add20RidesSkipass() {
        assert(SkipassFactory.skipassFor20Rides().getRidesAmountLeft() == RidesAmount.TWENTY);
    }

    @Test
    public void add50RidesSkipass() {
        assert(SkipassFactory.skipassFor50Rides().getRidesAmountLeft() == RidesAmount.FIFTY);
    }

    @Test
    public void add100RidesSkipass() {
        assert(SkipassFactory.skipassFor100Rides().getRidesAmountLeft() == RidesAmount.HUNDRED);
    }


}
