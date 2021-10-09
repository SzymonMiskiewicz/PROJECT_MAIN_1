package my.first.main.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";

    public static void main(String[] args) {

        // region import
       Countries country = new Countries();

        try{
        country = Countries.importFromFile(INPUTFILE);
    } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        // end region

        for (int i = 0; i <country.countriesSize() ; i++) {
            System.out.println(country.getCountry(i).getDescription());
        }
        List<Country>countryList = new ArrayList<>();{
        for (Country cntr : countryList ) {
            if (cntr.getFullTaxInPercent()>20 && cntr.getExtraTax()==false){
                System.out.println(cntr.getDescription());

            }
        }
    }


    }

}

