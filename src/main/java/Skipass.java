import java.time.LocalDate;
import java.util.UUID;

public abstract class Skipass {
    private String uniqueID;
    private boolean blocked = false;
    private LocalDate expirationTime;

    protected Skipass() {
        long daysBeforeExpiration = 365;
        expirationTime = LocalDate.now().plusDays(daysBeforeExpiration);
        uniqueID = UUID.randomUUID().toString();
        SkipassSystem.addSkipass(this);
    }

    public abstract boolean isValid();

    public abstract boolean use();

    protected String getUniqueID() {
        return uniqueID;
    }

    public abstract String type();

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationTime);
    }

    protected void block() {
        blocked = true;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (!other.getClass().equals(this.getClass())) return false;
        Skipass otherSkipass = (Skipass) other;
        if (other == this) return true;
        return otherSkipass.getUniqueID().equals(this.getUniqueID());
    }
}