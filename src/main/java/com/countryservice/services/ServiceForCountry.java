package com.countryservice.services;

import com.countryservice.beans.Country;
import com.countryservice.controller.AddResponse;

import com.countryservice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class ServiceForCountry {

    @Autowired
    CountryRepository countryrep;
    public List<Country> GetAllCountry(){
        return countryrep.findAll();
    }
    public Country GetCountryById(int id){
        return countryrep.findById(id).get();
    }

    public Country GetCountryByName(String countryName){

        List<Country> countries=countryrep.findAll();
        Country country=null;
        for(Country con:countries){
            if(con.getCountryName().equals(countryName)){
                country=con;
            }
        }
        return country;
    }
    public Country addCountry(Country country){
        country.setId(countryrep.findAll().size()+1);
        countryrep.save(country);
        return country;
    }

    public Country updateCountry(Country country){
        countryrep.save(country);
        return country;
    }
    public AddResponse deleteCountry(int id){
        countryrep.deleteById(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMsg("Country Deleted......");
        addResponse.setId(id);
        return addResponse;
    }

}
