package my.first.main.project;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";
    public static final String OUTPUTFILE = "vat-over-20.txt";
    public static final String NEW_OUTPUT_FILE_WITH_CUSTOM_TAX = "Vat-Over-";
    public static final String GAP = "\n=====================================================================\n";


    public static void main(String[] args) {

        CountryController country = new CountryController();

        // region import
        try {
            country = CountryController.importFromFile(INPUTFILE);
        } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        // end region

        // region export
        try {
            country.exportToFile(OUTPUTFILE);
        } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
        //end region

        //1.Vypiš seznam všech států
        for (int i = 0; i < country.countriesSize(); i++) {
            System.out.println(country.getCountry(i));

        }
        // end region

        System.out.println(GAP);
        /**2. Vypište ve stejném formátu pouze státy, které
         *  mají základní sazbu daně z přidané hodnoty vyšší než 20 %
         *  a přitom nepoužívají speciální sazbu daně.*/

        System.out.print(CountryController.formatCountryList(country.getCountriesWithBiggerAndNoSpecialTax()));

        System.out.println(GAP);

    /**4.Pod výpis doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují.*/
        System.out.print (CountryController.differentFormatCountryList(country.getCountriesWithLowerAndSpecialTax()));


        System.out.println(GAP);

        /** Doplň možnost, aby uživatel z klávesnice zadal výši sazby DPH/VAT,
         *  podle které se má filtrovat.
         *  Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.*/
        CountryController.getCountriesByTax();


        try {
            country.exportToFileByTax(NEW_OUTPUT_FILE_WITH_CUSTOM_TAX);
        } catch (TaxException e) {
            e.printStackTrace();
        }


    }
}



