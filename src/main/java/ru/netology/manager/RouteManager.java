package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import java.util.Arrays;

@AllArgsConstructor
@Data

public class RouteManager {
    private RouteRepository repository;


    public void add(Route item) {
        repository.save(item);
    }

    public Route[] findAll(String from, String to) {
        Route[] result = new Route[0];
        for (Route Route : repository.showAll()) {
            if (Route.getDepartAirport().equals(from) && Route.getArriveAirport().equals(to)) {
                Route[] tmp = new Route[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = Route;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}