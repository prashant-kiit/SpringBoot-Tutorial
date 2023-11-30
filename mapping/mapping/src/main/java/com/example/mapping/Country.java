package com.example.mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private int country_id;

    @Column(name="country_name")
    private String country_name = new String(); 
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capital_id")
    private Capital capital = new Capital(); 
    
	@OneToMany(mappedBy="country", cascade = CascadeType.ALL)
	private List<City> citys;
    
	public Country() {
		
	}
	
	public Country(String country_name) {
		this.country_name = country_name;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	public List<City> getCity() {
		return citys;
	}

	public void setCity(List<City> citys) {
		this.citys = citys;
	}

    public void add(City city) {

        if (citys == null) {
        	citys = new ArrayList<>();
        }

        citys.add(city);

        city.setCountry(this);
    }
	
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country_name=" + country_name + ", capital=" + capital
				+ "]";
	}
	
}
