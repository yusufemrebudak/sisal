package sisal.services.flightMs.domain.enums;

public enum Gender {
    MALE("Erkek"),
    FEMALE("Kadın"),

    OTHER("Diğer");
    public final String description;

    Gender(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
