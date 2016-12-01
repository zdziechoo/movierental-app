/* zaimplementować program do obsługi wypożyczalni video
 * funkcjonalnosci: dodaj plyte (do zbioru), dodaj kasete, wypozycz plyte, wypozycz kasete
 * mozliwosc wypisywania wszystkich plyt i kaset na stanie
 * mozliwosc wypisania posortowanych plyt: a po typie filmu, b po tytule
*/


package com.zdziechowski.movierental.console;

import java.util.*;

import com.zdziechowski.movierental.carrier.*;
import com.zdziechowski.movierental.dao.MovieRentalLinkedList;
import com.zdziechowski.movierental.console.Option;
import static com.zdziechowski.movierental.console.Option.END_THE_PROGRAM;
import static java.util.stream.Stream.of;


class App
{
    private static MovieRentalLinkedList movieRental = new MovieRentalLinkedList();
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean end = false;

    public static void main(String[] args )
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
    private static void printMenu() {
            /*for (Option option : Option.values()) {
                System.out.println(option.getDescription());
            }*/

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

    private static void loadSampleData() {
        if (movieRental.isEmpty()) {
            //adding sample data
            Dvd dvd1 = new Dvd("Terminator", "action");
            Dvd dvd2 = new Dvd("Terminator 2", "action");
            Dvd dvd3 = new Dvd("Dumb & Dumber", "comedy");
            Dvd dvd4 = new Dvd("Ace Ventura", "comedy");

            Videotape video1 = new Videotape("Terminator 2", "action");
            Videotape video2 = new Videotape("Avengers", "action");
            Videotape video3 = new Videotape("Pocahontas 2", "for kids");

            movieRental.addCarrier(dvd1);
            movieRental.addCarrier(dvd2);
            movieRental.addCarrier(dvd3);
            movieRental.addCarrier(dvd4);

            movieRental.addCarrier(video1);
            movieRental.addCarrier(video2);
            movieRental.addCarrier(video3);
        }

        addSamples(new char[10], 0, 5);
    }

    private static void addSamples(char[] out, int pos, int len) {
        if (pos > 0) movieRental.addCarrier(new Videotape(new String(out, 0, pos), "sample"));
        if (pos < len) for (char c = 'a'; c <= 'r'; c++) {
            out[pos] = c;
            addSamples(out, pos + 1, len);
        }

    }


}