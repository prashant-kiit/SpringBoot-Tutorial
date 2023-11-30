package com.example.mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="capital")
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="capital_id")
    private int capital_id;

    @Column(name="capital_name")
    private String capital_name = new String();  
    
    @OneToOne(mappedBy = "capital", cascade = CascadeType.ALL)
    private Country country;
    
	public Capital() {

	}

	public Capital(String capital_name) {
		this.capital_name = capital_name;
	}

	public int getCapital_id() {
		return capital_id;
	}

	public void setCapital_id(int capital_id) {
		this.capital_id = capital_id;
	}

	public String getCapital_name() {
		return capital_name;
	}

	public void setCapital_name(String capital_name) {
		this.capital_name = capital_name;
	}

	@Override
	public String toString() {
		return "Capital [capital_id=" + capital_id + ", capital_name=" + capital_name + "]";
	}
    
    
}
