package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Route implements Comparable<Route> {
    private int id;
    private int price;
    private String departAirport;
    private String arriveAirport;
    private int travelTime;


    public int compareTo(Route o) {
        return price - o.price;
    }
}