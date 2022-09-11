package com.countryservice.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Country")
public class Country {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="country_name")
    private String countryName;
    @Column(name="country_capital")
    private String countryCapital;

}
