package com.countryservice.services;

import com.countryservice.beans.Country;
import com.countryservice.controller.AddResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Service
public class ServiceForCountry {

    static HashMap<Integer, Country> countryIdMap;

    public ServiceForCountry(){
        countryIdMap=new HashMap<Integer,Country>();

        Country bangladeshCountry = new Country(1,"Bangladesh","Dhaka");
        Country ukCountry = new Country(2,"United Kingdom","Longon");
        Country usaCountry = new Country(3,"United State","Washington");

        countryIdMap.put(1,bangladeshCountry);
        countryIdMap.put(2,ukCountry);
        countryIdMap.put(3,usaCountry);
    }

    public List GetAllCountry(){
        List countries = new ArrayList<>(countryIdMap.values());
        return countries;
    }

    public Country GetCountryById(int id){
        return countryIdMap.get(id);
    }

    public Country GetCountryByName(String countryName){
        Country country=null;

        for(int i : countryIdMap.keySet()){
            if(countryIdMap.get(i).getCountryName().equals(countryName)){
                country=countryIdMap.get(i);
            }
        }
        return country;
    }
    public Country addCountry(Country country){
        country.setId(getMaxId());
        countryIdMap.put(country.getId(),country);
        return country;
    }

    public int getMaxId(){
        int i=0;
        for(int xx : countryIdMap.keySet()){
            if(xx>i){
                i=xx;
            }
        }
        return ++i;
    }

    public Country updateCountry(Country country){
        countryIdMap.put(country.getId(),country);
        return country;
    }

    public AddResponse deleteCountry(int id){
        countryIdMap.remove(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setId(id);
        addResponse.setMsg("country id deleted");
        return addResponse;
    }



}
