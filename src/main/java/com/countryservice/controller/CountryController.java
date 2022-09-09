package com.countryservice.controller;

import com.countryservice.beans.Country;
import com.countryservice.services.ServiceForCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    ServiceForCountry service;

    @GetMapping("getcountries")
    public List getCountries(){
        return service.GetAllCountry();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountryById(@PathVariable(value = "id") int id){
        return service.GetCountryById(id);
    }

    @GetMapping("/getcountries/countryName")
    public Country getCountryByName(@RequestParam(value="countryName") String countryName){
        return service.GetCountryByName(countryName);
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country){
        return service.addCountry(country);
    }

    @PutMapping("/updateCountry")
    public Country updateCountry(@RequestBody Country country){
        return service.updateCountry(country);
    }

    @DeleteMapping("/deleteCountry/{id}")
    public AddResponse deleteCountry(@PathVariable int id){
        return service.deleteCountry(id);
    }

}
