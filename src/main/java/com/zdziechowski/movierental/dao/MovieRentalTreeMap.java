package com.zdziechowski.movierental.dao;

import com.zdziechowski.movierental.carrier.Carrier;
import com.zdziechowski.movierental.carrier.Dvd;
import com.zdziechowski.movierental.carrier.Videotape;
import java.util.*;

public class MovieRentalTreeMap {
    private Map<String,ArrayList<Carrier>> movies= new TreeMap<>();

    public void addCarrier(String title, Carrier carrierToAdd){
        if (movies.containsKey(title)) {
            movies.get(title).add(carrierToAdd);
        }
        else{
            movies.put(title,new ArrayList<>());
            movies.get(title).add(carrierToAdd);
        }
    }

    public Set<String> listMovies(){
        //ask about immutable

        return movies.keySet();
    }
    public Map<String,ArrayList<Carrier>> getMovies(){
        Map<String,ArrayList<Carrier>> result = new HashMap<>();
        if(!movies.isEmpty()){
            for (String k:movies.keySet()){result.put(k, (ArrayList<Carrier>) copyCarriers(k));}
            return result;
        }
        else return null;
    }


    public List<Carrier> carriersByTitle(String title){
        if(movies.containsKey(title)){return copyCarriers(title);}
        else return null;
    }

    private List<Carrier> copyCarriers(String title){
        ArrayList<Carrier> result = new ArrayList<>();
        for (Carrier m:movies.get(title)) {
            Carrier c = null;
            if(m instanceof Videotape){c = new Videotape(m.getName(),m.getCategory());}
            if(m instanceof Dvd){c = new Dvd(m.getName(),m.getCategory());}
            c.setAvailable(m.isAvailable());
            result.add(c);
        }
        return result;
    }

    public boolean isEmpty(){return movies.isEmpty();}

    public void print() {

        System.out.println("w wypozyczalni mamy: " + movies.size() + " filmow");

    }

}
