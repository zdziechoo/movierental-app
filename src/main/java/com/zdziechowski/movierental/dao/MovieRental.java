/*
package com.zdziechowski.movierental.dao;

import java.util.*;

import com.zdziechowski.movierental.carrier.*;

public class MovieRental {

    private List<Carrier> movies = new ArrayList<>();

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
        List<Carrier> result = new ArrayList<>();
        for (Carrier m : movies) {
            if (m instanceof Videotape) result.add(new Videotape(m.getName(), m.getCategory()));
            if (m instanceof Dvd) result.add(new Dvd(m.getName(), m.getCategory()));
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
*/
