package sisal.services.flightMs.domain.enums;

public enum SalesStatus {
    IN_SALE("Satışta"),
    SOLD("Satıldı"),
    CLOSE_FOR_SALE("Satışa Kapalı");

    public final String description;

    SalesStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
