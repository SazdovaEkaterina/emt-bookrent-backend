package finki.emt.BookRent.repository;

import finki.emt.BookRent.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BookRepository
    extends JpaRepository<Book, Long> {

    void deleteByName(String name);

    Page<Book> findAll(Pageable pageable);

}
