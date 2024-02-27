package org.example;

import org.example.enums.RideType;
import org.example.pojos.Vechile;
import org.example.services.RideService;
import org.example.services.UserService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        UserService userService = new UserService();
        userService.addUser(1, "a");
        Vechile v11 = userService.addVechile(1, "FZ", "KA-5412322");

        userService.addUser(2, "b");
        Vechile v21 = userService.addVechile(2, "Baleno", "KA-5218732");

        userService.addUser(3, "c");

        userService.addUser(4, "d");
        Vechile v31 = userService.addVechile(3, "x", "KA-512142322");
        Vechile v32 = userService.addVechile(3, "y", "KA-51212322");

        userService.addUser(5, "e");


        RideService rideService = new RideService();

        rideService.offerRide(1, "Hyd", "Blr", 2, v11, 4, 13);
        rideService.offerRide(4, "Blr", "Mysore", 2, v31, 6, 7);
        rideService.offerRide(4, "Blr", "Mysore", 2, v32, 4, 10);
        rideService.offerRide(2, "Hyd", "Blr", 2, v21, 6, 10);

        rideService.selectRide(3, "Blr", "Mysore", RideType.FASTEST);
        rideService.selectRide(3, "Blr", "Mysore", RideType.EARLEST);
        rideService.selectRide(3, "Blr", "Mysore", RideType.EARLEST);
        rideService.selectRide(3, "Blr", "Mysore", RideType.EARLEST);
        rideService.selectRide(3, "Blr", "Mysore", RideType.EARLEST);
    }
}