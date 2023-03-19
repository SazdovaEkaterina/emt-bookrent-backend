package finki.emt.BookRent.repository;

import finki.emt.BookRent.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository
        extends JpaRepository<Author, Long> {
}
