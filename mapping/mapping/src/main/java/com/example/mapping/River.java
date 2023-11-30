package com.example.mapping;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "river")
public class River {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="river_id")
	private int river_id;
	
    @Column(name = "river_name")
	private String river_name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "city_river",
            joinColumns = @JoinColumn(name = "river_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> citys = new ArrayList<>();

	public River() {
	}

	public River(String river_name) {
		this.river_name = river_name;
	}

	public int getRiver_id() {
		return river_id;
	}

	public void setRiver_id(int river_id) {
		this.river_id = river_id;
	}

	public String getRiver_name() {
		return river_name;
	}

	public void setRiver_name(String river_name) {
		this.river_name = river_name;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	@Override
	public String toString() {
		return "River [river_id=" + river_id + ", river_name=" + river_name + ", citys=" + citys + "]";
	}
    
}
