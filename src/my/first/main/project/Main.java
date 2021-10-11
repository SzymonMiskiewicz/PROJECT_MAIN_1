package my.first.main.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";
    public static final String GAP = "=================================================\n";

    public static void main(String[] args) {

        // region import
        Countries country = new Countries();


        try {
            country = Countries.importFromFile(INPUTFILE);
        } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        // end region

        //1.Vypiš seznam všech států
        for (int i = 0; i < country.countriesSize(); i++) {
            System.out.println(country.getCountry(i).getDescription());
        }
        // end region

        System.out.println(GAP);
        /**2. Vypište ve stejném formátu pouze státy, které
         *  mají základní sazbu daně z přidané hodnoty vyšší než 20 %
         *  a přitom nepoužívají speciální sazbu daně.*/

//        List<Country>list = new ArrayList<>();
//
//        for (Country country1:list) {
//            if (country1.getFullTaxInPercent()>20
//                    &&
//                    country1.getExtraTax()== false);
        System.out.print(Countries.formatCountryList(country.getCountriesWithBiggerAndSpecialTax()));
    }

    /**3.Výpis seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou)*/
//        ArrayList<Double> list = new ArrayList<>();
//        Collections.addAll(list, new Double[]{64, 12, 135, 52});
//        System.out.println(list);


}



