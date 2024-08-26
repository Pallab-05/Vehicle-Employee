package com.example.Junit_Mockito.controller;

import com.example.Junit_Mockito.dto.VehicleResponseDto;
import com.example.Junit_Mockito.entity.Vehicle;
import com.example.Junit_Mockito.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    private static final Logger LOGGER= LoggerFactory.getLogger(VehicleController.class);
    @GetMapping("/getAllVehicle")
    public List<VehicleResponseDto> getAllVehicle(){
        LOGGER.info("Getting list of vehicle : " + vehicleService.getAllVehicle().stream().count());
        return vehicleService.getAllVehicle();
    }
    @PostMapping("/saveVehicle")
    public Vehicle save(@RequestBody Vehicle vehicle){
        LOGGER.info("Vehicle saved successfully");
        return vehicleService.saveVehicle(vehicle);
    }
    @GetMapping("/vehicle/{name}")
    public ResponseEntity<List<VehicleResponseDto>> findVehicle(@PathVariable("name") String name){
        List<VehicleResponseDto> vehicles=vehicleService.filterVehiclesByName(name);
        LOGGER.info("Getting list of distance based on starting and ending longitude latitude");
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
}
