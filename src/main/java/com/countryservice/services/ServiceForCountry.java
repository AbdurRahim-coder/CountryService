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
    public List<Country> getAllCountry(){ return countryrep.findAll(); }
    public Country getCountryById(int id){
        List<Country> countries=countryrep.findAll();
        Country country=null;

        for(Country con : countries){
            if(con.getId()==id){
                country=con;
            }
        }
        return country;
    }

    public Country getCountryByName(String countryName){

        List<Country> countries=countryrep.findAll();
        Country country=null;
        for(Country con:countries){
            if(con.getCountryName().equals(countryName)){
                country=con;
            }
        }
        return country;
    }

    int getMaxId(){
        List<Country> countries=countryrep.findAll();
        int id=1;
        for(Country con : countries){
            if(con.getId()>id)
                id= con.getId();
        }
        return id;

    }
    public Country addCountry(Country country){
        country.setId(getMaxId());
        countryrep.save(country);
        return country;
    }

    public Country updateCountry(Country country){
        countryrep.save(country);
        return country;
    }
    public void deleteCountry(Country country){
       countryrep.delete(country);
    }

}
