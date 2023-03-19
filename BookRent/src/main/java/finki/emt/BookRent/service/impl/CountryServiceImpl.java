package finki.emt.BookRent.service.impl;

import finki.emt.BookRent.repository.CountryRepository;
import finki.emt.BookRent.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

}
