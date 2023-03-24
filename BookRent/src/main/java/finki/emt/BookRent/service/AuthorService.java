package finki.emt.BookRent.service;

import finki.emt.BookRent.model.Author;
import finki.emt.BookRent.model.dto.AuthorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> findById(Long id);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
