package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * check if city on list
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Saskatoon", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Regina", "SK")));
    }


    /**
     * get the size of the list
     * decrease the list by removing a city
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Ottawa", "ON");
        list.addCity(city);
        assertEquals(1, list.getCount());
        list.deleteCity(city);
        assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
    }

    /**
     * get the size of the list
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Calgary", "AB"));
        assertEquals(2, list.countCities());
    }


}
