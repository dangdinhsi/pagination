package com.example.phantrang.service;

import com.example.phantrang.entity.Country;
import com.example.phantrang.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryServiceIMP implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public Page<Country> countryPaginate(int page, int limit) {
        return countryRepository.findAll(PageRequest.of(page-1,limit));
    }

    @Override
    public Country getById(int id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }
}
