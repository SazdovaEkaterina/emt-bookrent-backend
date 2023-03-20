package finki.emt.BookRent.service.impl;

import finki.emt.BookRent.model.Author;
import finki.emt.BookRent.model.Book;
import finki.emt.BookRent.model.dto.BookDto;
import finki.emt.BookRent.model.exceptions.AuthorNotFoundException;
import finki.emt.BookRent.model.exceptions.BookNotFoundException;
import finki.emt.BookRent.repository.AuthorRepository;
import finki.emt.BookRent.repository.BookRepository;
import finki.emt.BookRent.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        Author author = this.authorRepository.findById(bookDto.getAuthor().getId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor().getId()));

        this.bookRepository.deleteByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(book.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author = this.authorRepository.findById(bookDto.getAuthor().getId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor().getId()));
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }
}
