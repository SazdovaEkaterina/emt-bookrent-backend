package finki.emt.BookRent.model.enumerations;


public enum Role {

    ROLE_LIBRARIAN;

    public String getAuthority() {
        return name();
    }
}
