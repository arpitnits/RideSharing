package org.example.pojos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private int id;
    private String name;
    private int age;

    private List<Vechile> vechiles = new ArrayList<>();
    private int ridesTaken;
    private int ridesOffered;

    private int fuelSaved;
}
