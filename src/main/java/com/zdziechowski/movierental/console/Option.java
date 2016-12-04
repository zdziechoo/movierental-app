package com.zdziechowski.movierental.console;

import com.zdziechowski.movierental.carrier.Carrier;
import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.NoCarrierOrAlreadyRentException;
import com.zdziechowski.movierental.carrier.Videotape;
import com.zdziechowski.movierental.dao.MovieRentalTreeMap;

import java.util.Scanner;
enum Option {

    ADD_VIDEOTAPE("1 - add videotape", '1') {
        void invoke(MovieRentalTreeMap movieRental) {
            Carrier newCarrier = new Videotape();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Set release year: ");
            newCarrier.setReleaseYear(scanner.nextLine());
            System.out.println("Set category: ");
            newCarrier.setCategory(scanner.nextLine());
            System.out.println("Set title: ");
            movieRental.addCarrier(scanner.nextLine(),newCarrier);
        }
    },
    ADD_DVD("2 - add dvd", '2') {

        @Override
        void invoke(MovieRentalTreeMap movieRental) {
            Carrier newCarrier = new Dvd();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Set release year: ");
            newCarrier.setReleaseYear(scanner.nextLine());
            System.out.println("Set category: ");
            newCarrier.setCategory(scanner.nextLine());
            System.out.println("Set title: ");
            movieRental.addCarrier(scanner.nextLine(),newCarrier);
        }
    },
    RENT_VIDEOTAPE("3 - rent videotape", '3') {
        void invoke(MovieRentalTreeMap movieRental) {
            System.out.println("Set title of videotape to rent: ");
            rent(movieRental);
        }
    },
    RENT_DVD("4 - rent dvd", '4') {
        void invoke(MovieRentalTreeMap movieRental) {
            System.out.println("Set title of dvd to rent: ");
            rent(movieRental);
            }
    },
    SHOW_CARRIERS("5 - show carriers", '5') {
        void invoke(MovieRentalTreeMap movieRental) {
            showCarriers(movieRental);
        }
    },
    SORT_CARRIERS_BY_CATEGORY("6 - sort by category", '6') {
        void invoke(MovieRentalTreeMap movieRental) {
            movieRental.sortByCategory();
            showCarriers(movieRental);
        }
    },
    SORT_CARRIERS_BY_TITLE("7 - sort by title", '7') {
        void invoke(MovieRentalTreeMap movieRental) {
            movieRental.listMovies();
            showCarriers(movieRental);
        }
    },
    END_THE_PROGRAM("0 - end the program", '0') {
        void invoke(MovieRentalTreeMap movieRental) {
        }

    };

    private final String description;
    private final Character param;

    Option(String description, Character param) {
        this.description = description;
        this.param = param;
    }

    String getDescription() {
        return description;
    }

    boolean accept(Character c) {
        return c.equals(param);
    }

    abstract void invoke(MovieRentalTreeMap movieRental);

    private static void showCarriers(MovieRentalTreeMap movieRental) {
        System.out.println("-----------------------------------------------------------------");
        for (String title : movieRental.listMovies()) {
            System.out.println("Title: "+ title);
            for (Carrier carrier:movieRental.carriersByTitle(title)
                 ) {
                System.out.println("Release year: " + carrier.getReleaseYear() + ", Category: "
                        + carrier.getCategory() + ", carrier: " + carrier.getCarrier()
                        + ", available: " + carrier.isAvailable());
            }

        }
    }

    private static void rent(MovieRentalTreeMap movieRental) {
        Scanner scanner = new Scanner(System.in);
        String titleToRent = scanner.nextLine();
        try {
            movieRental.rentCarrierByTitle(titleToRent);
        } catch (NoCarrierOrAlreadyRentException e) {
            System.out.println(e.getMessage());
        }
    }
}
