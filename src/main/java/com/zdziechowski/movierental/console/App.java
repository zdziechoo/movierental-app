package com.zdziechowski.movierental.console;

import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.Videotape;
import com.zdziechowski.movierental.dao.MovieRental;

import java.util.Scanner;

import static com.zdziechowski.movierental.console.Option.END_THE_PROGRAM;
import static java.util.stream.Stream.of;

/**
 * Created by Asus on 2016-12-03.
 */
public class App {

    private static MovieRental movieRental = new MovieRental();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean end = false;

    public static void main(String[] args)
    {

        while (!end) {
            loadSampleData();
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
            Dvd dvd1 = new Dvd("1984", "action");
            Dvd dvd2 = new Dvd("1991", "action");
            Dvd dvd3 = new Dvd("1994", "comedy");
            Dvd dvd4 = new Dvd("1994", "comedy");

            Videotape video1 = new Videotape("1991", "action");
            Videotape video2 = new Videotape("2012", "action");
            Videotape video3 = new Videotape("1998", "for kids");
            movieRental.addCarrier("Terminator",dvd1);
            movieRental.addCarrier("Terminator 2",video1);
            movieRental.addCarrier("Terminator 2",dvd2);
            movieRental.addCarrier("Avengers",video2);
            movieRental.addCarrier("Pocahontas 2",video3);
            movieRental.addCarrier("Dumb & Dumber",dvd3);
            movieRental.addCarrier("Dumb & Dumber",dvd4);
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

    /*private static void addSamples(char[] out, int pos, int len) {
        if (pos > 0) movieRental.addCarrier(new Videotape(new String(out, 0, pos), "sample"));
        if (pos < len) for (char c = 'a'; c <= 'r'; c++) {
            out[pos] = c;
            addSamples(out, pos + 1, len);
        }

    }*/
}
