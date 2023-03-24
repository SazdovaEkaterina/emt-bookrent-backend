package finki.emt.BookRent.model.enumerations;

public enum Category {

    NOVEL,
    THRILLER,
    HISTORY,
    FANTASY,
    BIOGRAPHY,
    CLASSICS,
    DRAMA;

    public static boolean isValidCategoryName(String name) {
        Category result = null;
        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(name)) {
                result = category;
                break;
            }
        }
        return result != null;
    }
}
