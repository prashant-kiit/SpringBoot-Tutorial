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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="City")
public class City {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private int city_id;
	
	@Column(name="city_name")
	private String city_name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="country_id")
	private Country country = new Country();
	
	// @ManyToMany(mappedBy = "citys", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "city_river",
            joinColumns = @JoinColumn(name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "river_id")
    )
    private List<River> rivers = new ArrayList<>();
	
	public City() {
	}

	public City(String city_name) {
		this.city_name = city_name;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<River> getRivers() {
		return rivers;
	}

	public void setRivers(List<River> rivers) {
		this.rivers = rivers;
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + ", country=" + country + ", rivers=" + rivers
				+ "]";
	}
	
}
