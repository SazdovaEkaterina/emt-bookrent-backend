package finki.emt.BookRent.repository;

import finki.emt.BookRent.model.Book;
import finki.emt.BookRent.model.enumerations.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository
    extends JpaRepository<Book, Long> {

    void deleteByName(String name);

    Page<Book> findAll(Pageable pageable);

    List<Book> findAllByCategory(Category category);

}
