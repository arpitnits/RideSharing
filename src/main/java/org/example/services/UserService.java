package org.example.services;

import org.example.pojos.User;
import org.example.pojos.Vechile;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    static Map<Integer, User> userMap = new HashMap<>();
    static Map<String, Vechile> vechileMap = new HashMap<>();
    public User addUser(int id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        userMap.put(id, user);

        System.out.println("User added: " + user.getId());

        return user;
    }

    public Vechile addVechile(int userId, String name, String id) {
        Vechile vechile = new Vechile();
        vechile.setVechileId(id);
        vechile.setVechileName(name);

        vechileMap.put(id, vechile);
        userMap.get(userId).getVechiles().add(vechile);

        System.out.println("Vechile added: " + vechile.getVechileId());

        return vechile;
    }

    public void totalRides(int uuid) {
       int taken =  userMap.get(uuid).getRidesTaken();
        int offered =  userMap.get(uuid).getRidesOffered();

        System.out.println("user: " + uuid + " Taken: " + taken + " offered: " + offered);
    }
}
