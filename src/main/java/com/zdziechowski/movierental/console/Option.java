package com.zdziechowski.movierental.console;

import com.zdziechowski.movierental.carrier.Carrier;
import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.NoCarrierOrAlreadyRentException;
import com.zdziechowski.movierental.carrier.Videotape;
import com.zdziechowski.movierental.dao.MovieRental;

import java.util.Scanner;
enum Option {

    ADD_VIDEOTAPE("1 - add videotape", '1') {
        void invoke(MovieRental movieRental) {
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
        void invoke(MovieRental movieRental) {
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
        void invoke(MovieRental movieRental) {
            System.out.println("Set title of videotape to rent: ");
            rent(movieRental,"videotape");
        }
    },
    RENT_DVD("4 - rent dvd", '4') {
        void invoke(MovieRental movieRental) {
            System.out.println("Set title of dvd to rent: ");
            rent(movieRental,"dvd");
            }
    },
    SHOW_CARRIERS("5 - show carriers", '5') {
        void invoke(MovieRental movieRental) {
            showCarriers(movieRental);
        }
    },
    SORT_CARRIERS_BY_CATEGORY("6 - sort by category", '6') {
        void invoke(MovieRental movieRental) {
            movieRental.sortByCategory();
            showCarriers(movieRental);
        }
    },
    SORT_CARRIERS_BY_TITLE("7 - sort by title", '7') {
        void invoke(MovieRental movieRental) {
            movieRental.listMovies();
            showCarriers(movieRental);
        }
    },
    END_THE_PROGRAM("0 - end the program", '0') {
        void invoke(MovieRental movieRental) {
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

    abstract void invoke(MovieRental movieRental);

    private static void showCarriers(MovieRental movieRental) {
        System.out.println("-----------------------------------------------------------------");
        for (String title : movieRental.listMovies()) {
            System.out.println("Title: "+ title);
            for (Carrier carrier:movieRental.carriersByTitle(title)
                 ) {
                System.out.println("\t\t\t\t|\n"+"\t\t\t\t\t--------"+"Release year: " + carrier.getReleaseYear() + ", Category: "
                        + carrier.getCategory() + ", carrier: " + carrier.getCarrier()
                        + ", available: " + carrier.isAvailable());
            }

        }
    }

    private static void rent(MovieRental movieRental, String carrierType) {
        Scanner scanner = new Scanner(System.in);
        String titleToRent = scanner.nextLine();
        try {
            movieRental.rentCarrier(titleToRent,carrierType);
        } catch (NoCarrierOrAlreadyRentException e) {
            System.out.println(e.getMessage());
        }
    }
}
