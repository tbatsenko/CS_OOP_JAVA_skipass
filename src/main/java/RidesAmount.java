public enum RidesAmount {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    protected int rides;

    RidesAmount(int rides){
        this.rides = rides;
    }
}
