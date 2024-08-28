package com.example.Junit_Mockito.repository;

import com.example.Junit_Mockito.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query(value = "SELECT id," +
            " date, name," +
            "starting_latitude,starting_longitude," +
            "ending_latitude,ending_longitude FROM vehicle WHERE name = :name",
            nativeQuery = true)
    List<Vehicle> findListOfVehicleByName(@Param("name") String name);
}
