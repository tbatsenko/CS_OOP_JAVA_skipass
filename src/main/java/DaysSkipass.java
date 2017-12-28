import java.time.LocalDate;

public class DaysSkipass extends Skipass {
    protected DaysAmount daysAmount;
    private LocalDate lastDateUsed = null;

    protected DaysSkipass(DaysAmount daysAmount) {
        super();
        this.daysAmount = daysAmount;
    }

    @Override
    public boolean isValid() {
        return daysAmount.days >= 0;
    }

    public DaysAmount getDaysAmount() {
        return daysAmount;
    }

    @Override
    public boolean use() {
        if (!this.isValid()) return false;
        if (lastDateUsed != LocalDate.now()){
            lastDateUsed = LocalDate.now();
            daysAmount.days -= 1;
            return true;
        }

        else return true;
    }

    @Override
    public String type() {
        return this.getClass().getName();
    }
}
