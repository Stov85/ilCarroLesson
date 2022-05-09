package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Car {
    String address;
    String name;
    String model;
    String year;
    String engine;
    String fuel;
    String gear;
    String wD;
    String doors;
    String seats;
    String clasS;

    String fuelconsumption;
    String carRegNumber;
    String price;
    String distanceIncluded;
    String features;
    String about;



}
