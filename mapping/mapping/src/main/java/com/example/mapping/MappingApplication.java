package com.example.mapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(CountryRepo countryRepo, CapitalRepo capitalRepo, CityRepo cityRepo, RiverRepo riverRepo) {

		return runner -> {
			
			createCountryANDCapital(countryRepo, capitalRepo, cityRepo, riverRepo);
			
			// deleteCountryANDCapital(countryRepo, capitalRepo, cityRepo, riverRepo);
		};
	}

	private void createCountryANDCapital(CountryRepo countryRepo, CapitalRepo capitalRepo, CityRepo cityRepo, RiverRepo riverRepo) {

		// create the capital
		Capital capital = new Capital("New Delhi");

		// create the country
		Country country = new Country("India");

		// associate the objects
		country.setCapital(capital); // Uni and Bi
		
		// create the city
		City city1=new City("Mumbai");
		
		City city2=new City("Patna");

		// associate city to country
		// city1.setCountry(country); // Uni
		
		// city2.setCountry(country); // Uni
		
		country.add(city1); // Bi
		
		country.add(city2); // Bi
		
		// create the river
		River river1 = new River("Ganga");

		River river2 = new River("Yamuna");
		
		// associate river to city
		
		city1.getRivers().add(river1);

		city1.getRivers().add(river2);
		
		// display
		System.out.println("Saving : " + capital + " " + country + " " + city1 + " " + city2 + " " + river1);
		
		// save the country
		// NOTE: this will ALSO save the capital object
		// because of CascadeType.ALL
		// First capital will be saved then country
		// First country and then city		
		// explicit Auto wire not needed		
	    // countryRepo.save(country);
		
		// capitalRepo.save(capital);
		
		cityRepo.save(city1);
		
		// cityRepo.save(city2);

		// riverRepo.save(river1);
		
		System.out.println("Done!");
		
	}
	
	private void deleteCountryANDCapital(CountryRepo countryRepo, CapitalRepo capitalRepo, CityRepo cityRepo, RiverRepo riverRepo) {
		
		System.out.println("Getting Started!");
		
		// This will delete the country record as well as the corresponding capital record
		// b/c of cascade.all		
		// countryRepo.deleteById(4);
		
		// capitalRepo.deleteById(1);
		
		// cityRepo.deleteById(1);
		
		System.out.println("Done!");
		
	}
}
