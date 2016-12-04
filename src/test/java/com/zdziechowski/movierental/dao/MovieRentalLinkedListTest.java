package com.zdziechowski.movierental.dao;

import com.zdziechowski.movierental.carrier.Carrier;
import com.zdziechowski.movierental.carrier.Videotape;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.swing.text.View;

/**
 * Created by Asus on 2016-11-28.
 */
public class MovieRentalLinkedListTest {
    public void setUp() throws Exception {

    }

    public void tearDown() throws Exception {
    }

    @Test
    public void simpleAddTest() {
        //given
        MovieRentalLinkedList dao = new MovieRentalLinkedList();
        Carrier videotape = new Videotape("test", "test");

        //when
        dao.addCarrier(videotape);

        //then
        Assert.assertEquals(1, dao.getMovies().size());
        Assert.assertFalse(dao.isEmpty());
    }

    @Test
    public void simpleRentTest() {
        //given
        MovieRentalLinkedList dao = new MovieRentalLinkedList();
        Carrier videotape = new Videotape("test", "test");
        dao.addCarrier(videotape);

        //when
        dao.rentCarrierByTitle("test");

        //then
        Assert.assertEquals(1, dao.getMovies().size());
        Assert.assertFalse(dao.getMovies().get(0).isAvailable());

    }

    @Test
    public void simpleRentTest2() {
        //given
        MovieRentalLinkedList dao = new MovieRentalLinkedList();
        Carrier carrier = Mockito.mock(Videotape.class);
        Mockito.when(carrier.getName()).thenReturn("Test");
        Mockito.when(carrier.isAvailable()).thenReturn(true);
        dao.addCarrier(carrier);

        //when
        dao.rentCarrierByTitle("Test");

        //then
        Mockito.verify(carrier, Mockito.times(1)).isAvailable();
    }
}