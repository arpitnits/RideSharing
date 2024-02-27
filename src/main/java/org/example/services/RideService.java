package org.example.services;

import org.example.enums.RideType;
import org.example.pojos.Ride;
import org.example.pojos.User;
import org.example.pojos.Vechile;

import java.util.*;

import static org.example.services.UserService.userMap;

public class RideService {


    static Map<String, List<Ride>> offerRideMap  = new HashMap<>();
    public void offerRide(int uuid, String src, String dst, int seats, Vechile vechile, int startTime, int duration) {
        Ride ride = new Ride();
        ride.setUuid(uuid);
        ride.setSrc(src);
        ride.setDest(dst);
        ride.setSeats(seats);
        ride.setVechile(vechile);
        ride.setStartTime(startTime);
        ride.setRideDuration(duration);

        String key = src+"_"+dst;

        List<Ride> ridesOffered = offerRideMap.getOrDefault(key, new ArrayList<>());
        ridesOffered.add(ride);
        offerRideMap.put(key, ridesOffered);

        User user = userMap.get(uuid);
        user.setRidesOffered(user.getRidesOffered()+1);
        userMap.put(uuid, user); // unnecessary

        System.out.println("OfferRide added: " + ride);
    }

    public Ride selectRide(int uuid, String src, String dst, RideType type) {
        String key = src+ "_" + dst;

       List<Ride> ridesOffered = offerRideMap.getOrDefault(key, new ArrayList<>());

       if(ridesOffered.isEmpty()) {
           System.out.println("No ride available");
           return null;
       }

       switch (type) {
           case FASTEST:
               ridesOffered.sort(Comparator.comparingInt(Ride::getRideDuration));
               break;
           case EARLEST:
               ridesOffered.sort(Comparator.comparingInt(Ride::getStartTime));
               break;
       }

        Ride ride = ridesOffered.get(0);

        System.out.println("SELECTED ride: " + ride);

        ride.setSeats(ride.getSeats()-1);
        if(ride.getSeats() == 0)
            ridesOffered.remove(ride);

        User user = userMap.get(uuid);
        user.setRidesTaken(user.getRidesTaken()+1);
        user.setFuelSaved(user.getFuelSaved()+ ride.getRideDuration());
        userMap.put(uuid, user);

        return ride;
    }
}
