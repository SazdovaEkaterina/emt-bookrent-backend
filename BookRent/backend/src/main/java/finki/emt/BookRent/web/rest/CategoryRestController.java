package finki.emt.BookRent.web.rest;

import finki.emt.BookRent.model.Book;
import finki.emt.BookRent.model.enumerations.Category;
import finki.emt.BookRent.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final BookService bookService;

    public CategoryRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Category> findAll(){
        return Arrays.stream(Category.values()).toList();
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Book>> findBooksByCategory(@PathVariable String categoryName){
        if(Category.isValidCategoryName(categoryName)){
            return ResponseEntity.ok().body(this.bookService.findAllByCategory(categoryName.toUpperCase()));
        }
        return ResponseEntity.badRequest().build();
    }

}
