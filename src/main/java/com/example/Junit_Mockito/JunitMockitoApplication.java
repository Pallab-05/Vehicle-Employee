package com.example.Junit_Mockito;

import com.example.Junit_Mockito.entity.Vehicle;
import com.example.Junit_Mockito.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JunitMockitoApplication implements CommandLineRunner {
	@Autowired
	VehicleRepository vehicleRepository;
	public static void main(String[] args) {
		SpringApplication.run(JunitMockitoApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {
		Vehicle vehicle1=new Vehicle(1L,new Date(2024-05-01),"Honda",22.6118, 75.77786,22.61184,75.77786);
		Vehicle vehicle2=new Vehicle(2L,new Date(2024-05-02),"Honda", 22.6118, 75.77786,22.61184,75.77786);
		Vehicle vehicle3=new Vehicle(3L,new Date(2024-05-03),"Honda", 22.6118, 75.77786,22.61184,75.77786);
		Vehicle vehicle6=new Vehicle(5L,new Date(2024-05-01),"Hero",22.6118, 75.77786,22.61184,75.77786);
		Vehicle vehicle7=new Vehicle(6L,new Date(2024-05-01),"Hero",22.6118, 75.77786,22.61184,75.77786);
		Vehicle vehicle8=new Vehicle(7L,new Date(2024-05-01),"Hero",22.6118, 75.77786,22.61184,75.77786);
		vehicleRepository.save(vehicle1);
		vehicleRepository.save(vehicle2);
		vehicleRepository.save(vehicle3);
		vehicleRepository.save(vehicle8);
		vehicleRepository.save(vehicle6);
		vehicleRepository.save(vehicle7);

	}
}
