package com.zdziechowski.movierental.dao;

import com.zdziechowski.movierental.carrier.Carrier;
import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.NoCarrierOrAlreadyRentException;
import com.zdziechowski.movierental.carrier.Videotape;

import java.util.*;

public class MovieRentalLinkedList {
    private List<Carrier> movies = new LinkedList<>();

    private final Comparator<Carrier> byCategory = (c1, c2) -> c1.getCategory().compareTo(c2.getCategory());
    private final Comparator<Carrier> byTitle = (c1, c2) -> c1.getName().compareTo(c2.getName());

    public void sortByTitle() {
        Collections.sort(movies, byTitle);
    }

    public void sortByCategory() {
        Collections.sort(movies, byCategory);
    }


    public void addCarrier(Carrier addCarrier) {
        movies.add(addCarrier);
    }

    public void rentCarrierByTitle(String title) throws NoCarrierOrAlreadyRentException {

        for (Carrier m : movies) {
            if (m.getName().equals(title) && m.isAvailable()) {
                m.setAvailable(false);
                return;
            }
        }
        throw new NoCarrierOrAlreadyRentException();
    }

    public List<Carrier> getMovies() {
        List<Carrier> result = new LinkedList<>();
        for (Carrier m : movies) {
            Carrier c = null;
            if (m instanceof Videotape) c = new Videotape(m.getName(), m.getCategory());
            if (m instanceof Dvd) c = new Dvd(m.getName(), m.getCategory());
            c.setAvailable(m.isAvailable());
            result.add(c);
        }
        return result;
    }

    public boolean isEmpty() {
        return movies.isEmpty();
    }

    public void print() {

        System.out.println("w wypozyczalni mamy: " + movies.size() + " filmow");
        System.out.println(movies.get(movies.size() - 1).getName());
    }
}
