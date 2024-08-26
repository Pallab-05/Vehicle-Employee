package com.example.Junit_Mockito.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@JsonPropertyOrder({"date","name","distance"})
public class VehicleResponseDto {
    @JsonProperty("date")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;
    @JsonProperty("name")
    private String name;
    @JsonProperty("distance")
    private double distance;
}
