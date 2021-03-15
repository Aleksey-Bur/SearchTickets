package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Route;

@AllArgsConstructor
@NoArgsConstructor

public class RouteRepository {

    private Route[] items = new Route[0];

    public void save(Route item) {
        int length = items.length + 1;
        Route[] tmp = new Route[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }
    public Route[] showAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Route[] tmp = new Route[length];
        int index = 0;
        for (Route item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}