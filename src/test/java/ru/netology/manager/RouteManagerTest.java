package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RouteManagerTest {
    private RouteRepository repository = new RouteRepository();
    private RouteManager manager = new RouteManager(repository);

    private Route reservation1 = new Route(1, 2300, "YFA", "GOJ", 130);
    private Route reservation2 = new Route(2, 2250, "SVO", "KZN", 100);
    private Route reservation3 = new Route(3, 2500, "KLV", "VOG", 190);
    private Route reservation4 = new Route(4, 2300, "SVO", "KZN", 110);
    private Route reservation5 = new Route(5, 12200, "LED", "CEK", 450);
    private Route reservation6 = new Route(6, 2705, "CEK", "DME", 220);
    private Route reservation7 = new Route(7, 2155, "SVO", "KZN", 90);

    @BeforeEach
    void setUp(){
        manager.add(reservation1);
        manager.add(reservation2);
        manager.add(reservation3);
        manager.add(reservation4);
        manager.add(reservation5);
        manager.add(reservation6);
        manager.add(reservation7);
    }

    @Test
    void shouldShowExistTickets(){

        Route[] expected = {reservation7, reservation2, reservation4};
        Route[] actual = manager.findAll("SVO", "KZN");

        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldShowNonExistTickets(){

        Route[] expected = {};
        Route[] actual = manager.findAll("KLV", "DME");

        assertArrayEquals(expected, actual);

    }
}