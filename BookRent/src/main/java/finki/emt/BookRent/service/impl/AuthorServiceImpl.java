package finki.emt.BookRent.service.impl;

import finki.emt.BookRent.repository.AuthorRepository;
import finki.emt.BookRent.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

}
