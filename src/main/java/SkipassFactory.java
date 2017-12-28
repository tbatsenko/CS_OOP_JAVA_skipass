import java.util.Calendar;
import java.util.Date;


public class SkipassFactory {
    public static RideSkipass skipassFor10Rides() {
        return new RideSkipass(RidesAmount.TEN);
    }

    public static RideSkipass skipassFor20Rides() {
        return new RideSkipass(RidesAmount.TWENTY);
    }

    public static RideSkipass skipassFor50Rides() {
        return new RideSkipass(RidesAmount.FIFTY);
    }

    public static RideSkipass skipassFor100Rides() {
        return new RideSkipass(RidesAmount.HUNDRED);
    }

    public static DaysSkipass skipassFor1Day() {
        return new DaysSkipass((DaysAmount.ONE));
    }

    public static DaysSkipass skipassFor2Days() {
        return new DaysSkipass((DaysAmount.TWO));
    }

    public static DaysSkipass skipassFor5Days() {
        Calendar cal = Calendar.getInstance();
        Date dateNow = new Date();
        cal.setTime(dateNow);

        boolean nowIsHoliday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

        if (!nowIsHoliday)
            return new DaysSkipass((DaysAmount.FIVE));
        else
            System.out.println("Sorry, you can't buy 5 days skipass on weekends");
            return new DaysSkipass((DaysAmount.TWO));
    }
}
