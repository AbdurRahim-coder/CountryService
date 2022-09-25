package com.countryservice.controller;

import com.countryservice.beans.Country;
import com.countryservice.services.ServiceForCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    ServiceForCountry service;

    @GetMapping("getcountries")
    public List getCountries(){
        return service.getAllCountry();
    }

    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id") int id){

        try{
            Country country = service.getCountryById(id);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getcountries/countryName")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value="countryName") String countryName){
        try{
            Country country = service.getCountryByName(countryName);
            return new ResponseEntity<Country>(country,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addCountry")
    public Country addCountry(@RequestBody Country country){
        return service.addCountry(country);
    }

    @PutMapping("/updateCountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id, @RequestBody Country country){
        try{
           Country exist_country = service.getCountryById(id);
           exist_country.setCountryName(country.getCountryName());
           exist_country.setCountryCapital(country.getCountryCapital());
           Country con=service.updateCountry(exist_country);
           return new ResponseEntity<Country>(con,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deleteCountry/{country}")
    public void deleteCountry(@PathVariable Country country){
        service.deleteCountry(country);
    }

}
