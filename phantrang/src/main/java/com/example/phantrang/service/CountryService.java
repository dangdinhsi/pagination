package com.example.phantrang.service;

import com.example.phantrang.entity.Country;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountry();
    Page<Country> countryPaginate(int page,int limit);
    Country getById(int id);
    Country create(Country country);
}
