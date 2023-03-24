package finki.emt.BookRent.service;

import finki.emt.BookRent.model.Book;
import finki.emt.BookRent.model.Country;
import finki.emt.BookRent.model.dto.CountryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(CountryDto countryDto);

    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);

}
