package my.first.main.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";
    public static final String OUTPUTFILE = "vat-over-20.txt";
    public static final String GAP = "=====================================================================\n";

    public static void main(String[] args) {

        // region import
        Countries country = new Countries();

        try {
            country = Countries.importFromFile(INPUTFILE);
        } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        // end region

        try {
            country.exportToFile(OUTPUTFILE);
        } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        
        //1.Vypiš seznam všech států
        for (int i = 0; i < country.countriesSize(); i++) {
            System.out.println(country.getCountry(i).getDescription());

        }
        // end region

        System.out.println(GAP);
        /**2. Vypište ve stejném formátu pouze státy, které
         *  mají základní sazbu daně z přidané hodnoty vyšší než 20 %
         *  a přitom nepoužívají speciální sazbu daně.*/

        System.out.print(Countries.formatCountryList(country.getCountriesWithBiggerAndNoSpecialTax()));

        System.out.println(GAP);

    /**4.Pod výpis doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují.*/
        System.out.print(Countries.differentFormatCountryList(country.getCountriesWithLowerAndSpecialTax()));



    }
}



