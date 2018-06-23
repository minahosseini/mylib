package com.parsa.myapp.RXSamples;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hmd on 06/15/2018.
 */

public class ObservablesSamples {
    public static List<String> getNamesFromDB(String query) {
        List<String> names= new ArrayList<>();
        names.add("Alireza");
        names.add("Alireza");
        names.add("Mohammad");
        names.add("Javad");
        names.add("Maryam");
        return names;
    }
}
