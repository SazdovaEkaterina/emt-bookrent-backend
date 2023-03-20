package finki.emt.BookRent.model.dto;

import finki.emt.BookRent.model.Author;
import finki.emt.BookRent.model.enumerations.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class BookDto {

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Author author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}