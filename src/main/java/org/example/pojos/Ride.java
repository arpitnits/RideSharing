package org.example.pojos;

import lombok.Data;

@Data
public class Ride {

    private int uuid;
    private String src;
    private String dest;
    private Vechile vechile;
    private int startTime;

    private int rideDuration;
    private int seats;
}
