package emt.lab2.java.Service.impl;

import emt.lab2.java.Repository.CountryRepository;
import emt.lab2.java.Service.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


}
