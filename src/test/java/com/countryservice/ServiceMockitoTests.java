package com.countryservice;

import com.countryservice.beans.Country;
import com.countryservice.repositories.CountryRepository;
import com.countryservice.services.ServiceForCountry;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceMockitoTests {
    @Mock
    CountryRepository countryrep;
    @InjectMocks
    ServiceForCountry serviceForCountry;

    List<Country> countries;

    @Test
    @Order(1)
    public void test_getALLCountry(){

        countries=new ArrayList<>();
        countries.add(new Country(1,"Bangladesh","Dhaka"));
        countries.add(new Country(2,"India","Delli"));

        when(countryrep.findAll()).thenReturn(countries);
        assertEquals(2,serviceForCountry.getAllCountry().size());
    }

    @Test
    @Order(2)
    public void test_getCountryById(){
        List<Country> countries=new ArrayList<>();
        countries.add(new Country(1,"Bangladesh","Dhaka"));
        countries.add(new Country(2,"India","Delli"));
        int countryId=1;

        when(countryrep.findAll()).thenReturn(countries);
        assertEquals("Dhaka", serviceForCountry.getCountryById(countryId).getCountryCapital());
    }
    @Test
    @Order(3)
    public void test_getCountryByName(){
        List<Country> countries=new ArrayList<>();
        countries.add(new Country(1,"Bangladesh","Dhaka"));
        countries.add(new Country(2,"India","Delli"));
        String countryName="Bangladesh";

        when(countryrep.findAll()).thenReturn(countries);
        assertEquals("Dhaka", serviceForCountry.getCountryByName(countryName).getCountryCapital());
    }

    @Test
    @Order(4)
    public void test_addCountry(){
        Country country=new Country(3,"Germany","Berlin");

        when(countryrep.save(country)).thenReturn(country);
        assertEquals(country,serviceForCountry.addCountry(country));

    }
    @Test
    @Order(5)
    public void test_updateCountry(){
        Country country=new Country(3,"Germany","Berlin");

        when(countryrep.save(country)).thenReturn(country);
        assertEquals(country,serviceForCountry.updateCountry(country));
    }

    @Test
    @Order(6)
    public void test_deleteCountry(){
        Country country=new Country(3,"Germany","Berlin");
        serviceForCountry.deleteCountry(country);
        verify(countryrep,times(1)).delete(country);
    }
}
