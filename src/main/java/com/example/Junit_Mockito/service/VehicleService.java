package com.example.Junit_Mockito.service;

import com.example.Junit_Mockito.dto.VehicleResponseDto;
import com.example.Junit_Mockito.entity.Vehicle;
import com.example.Junit_Mockito.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<VehicleResponseDto> getAllVehicle(){
        List<Vehicle> vehicles=vehicleRepository.findAll();
//        return vehicles.stream().map((vehicle)->
//            modelMapper.map(vehicle,VehicleResponseDto.class)).collect(Collectors.toList());
        List<VehicleResponseDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            double distance = calculateDistance(vehicle.getStartingLatitude(), vehicle.getStartingLongitude(),
                    vehicle.getEndingLatitude(), vehicle.getEndingLongitude());
            VehicleResponseDto vehicleDto = new VehicleResponseDto(vehicle.getDate(), vehicle.getName(), distance);
            vehicleDtos.add(vehicleDto);
        }
        return vehicleDtos;
    }
    public Vehicle saveVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
    public List<VehicleResponseDto> filterVehiclesByName(String name) {
//        return vehicleRepository.findListOfVehicleByName(name);
        List<Vehicle> vehicles = vehicleRepository.findListOfVehicleByName(name);
        List<VehicleResponseDto> vehicleDtos = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            double distance = calculateDistance(vehicle.getStartingLatitude(), vehicle.getStartingLongitude(),
                    vehicle.getEndingLatitude(), vehicle.getEndingLongitude());
            VehicleResponseDto vehicleDto = new VehicleResponseDto(vehicle.getDate(), vehicle.getName(), distance);
            vehicleDtos.add(vehicleDto);
        }

        return vehicleDtos;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}

