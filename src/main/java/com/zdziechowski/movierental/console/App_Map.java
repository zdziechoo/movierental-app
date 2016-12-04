package com.zdziechowski.movierental.console;

import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.Videotape;
import com.zdziechowski.movierental.dao.MovieRentalTreeMap;

import java.util.Scanner;

import static com.zdziechowski.movierental.console.Option.END_THE_PROGRAM;
import static java.util.stream.Stream.of;

/**
 * Created by Asus on 2016-12-03.
 */
public class App_Map {

    private static MovieRentalTreeMap movieRental = new MovieRentalTreeMap();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean end = false;

    public static void main(String[] args)
    {
        loadSampleData();
        while (!end) {
            printMenu();
            movieRental.print();
            try {
                Option o = readOption();
                if (!o.equals(END_THE_PROGRAM)) {
                    o.invoke(movieRental);
                } else end = true;
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void loadSampleData(){
        if(movieRental.isEmpty()){
            Dvd dvd1 = new Dvd("Terminator", "action");
            Dvd dvd2 = new Dvd("Terminator 2", "action");
            Dvd dvd3 = new Dvd("Dumb & Dumber", "comedy");
            Dvd dvd4 = new Dvd("Ace Ventura", "comedy");

            Videotape video1 = new Videotape("Terminator 2", "action");
            Videotape video2 = new Videotape("Avengers", "action");
            Videotape video3 = new Videotape("Pocahontas 2", "for kids");
            movieRental.addCarrier("ZZZ",dvd1);
            movieRental.addCarrier("BBB",dvd2);
            movieRental.addCarrier("MMM",video1);
            movieRental.addCarrier("LLL",video2);
            movieRental.addCarrier("WWW",video3);
        }
    }

    private static void printMenu() {
        of(Option.values())
                .map(Option::getDescription)
                .forEach(System.out::println);
    }

    private static Option readOption() throws InvalidOptionException {
        //sprobowac z lambdami
        System.out.println("Choose option >");
        Character c = scanner.next().charAt(0);
        for (Option option : Option.values()) {
            if (option.accept(c)) {
                return option;
            }
        }
        throw new InvalidOptionException();
    }

    private static void addSamples(char[] out, int pos, int len) {
        if (pos > 0) movieRental.addCarrier(new Videotape(new String(out, 0, pos), "sample"));
        if (pos < len) for (char c = 'a'; c <= 'r'; c++) {
            out[pos] = c;
            addSamples(out, pos + 1, len);
        }

    }
}
