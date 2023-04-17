package finki.emt.BookRent.service.impl;

import finki.emt.BookRent.model.Country;
import finki.emt.BookRent.model.dto.CountryDto;
import finki.emt.BookRent.model.exceptions.CountryNotFoundException;
import finki.emt.BookRent.repository.CountryRepository;
import finki.emt.BookRent.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {

        this.countryRepository.deleteByName(countryDto.getName());
        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);

    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {

        Country country = this.countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        this.countryRepository.save(country);

        return Optional.of(country);

    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
