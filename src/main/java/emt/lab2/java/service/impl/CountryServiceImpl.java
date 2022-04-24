package emt.lab2.java.service.impl;

import emt.lab2.java.repository.CountryRepository;
import emt.lab2.java.service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


}
