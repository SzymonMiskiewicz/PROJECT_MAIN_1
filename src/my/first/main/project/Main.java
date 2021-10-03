package my.first.main.project;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";

    public static void main(String[] args) {

        //import
       Countries country = new Countries();


        try{
        country.importFromFile(INPUTFILE);
    } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        // end region

        System.out.println(country.getBasicInfo());
    }

}
