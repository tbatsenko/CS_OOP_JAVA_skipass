public class RideSkipass extends Skipass {
    private RidesAmount ridesAmountLeft;

    public RidesAmount getRidesAmountLeft() {
        return ridesAmountLeft;
    }

    protected RideSkipass(RidesAmount ridesAmount){
        super();
        this.ridesAmountLeft = ridesAmount;
    }

    @Override
    public boolean isValid() {
        return ridesAmountLeft.rides > 0;
    }

    @Override
    public boolean use() {
        if (this.isValid()) {
            ridesAmountLeft.rides -= 1;
            return true;
        }
        return false;
    }

    @Override
    public String type() {
        return this.getClass().getName();
    }
}
