package finki.emt.BookRent.service;

import finki.emt.BookRent.model.Book;
import finki.emt.BookRent.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}
