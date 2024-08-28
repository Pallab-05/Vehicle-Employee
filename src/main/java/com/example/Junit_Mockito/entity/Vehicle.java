package com.example.Junit_Mockito.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
@JsonPropertyOrder({"id","date","name","startingLatitude","startingLongitude","endingLatitude","endingLongitude"})
public class Vehicle {
    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startingLatitude")
    private double startingLatitude;
    @JsonProperty("startingLongitude")
    private double startingLongitude;
    @JsonProperty("endingLatitude")
    private double endingLatitude;
    @JsonProperty("endingLongitude")
    private double endingLongitude;
}
