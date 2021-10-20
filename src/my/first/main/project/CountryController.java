package my.first.main.project;

import java.io.*;
import java.util.*;
import java.util.function.ToDoubleBiFunction;

public class CountryController implements Comparator<Country> {

    private static List<Country> listOfCountries = new ArrayList<>();

    private final String DELIMITER_FOR_FILE = "\t";

    public void addCountry(Country country){
        listOfCountries.add(country);
    }

    public Country getCountry(int index){
        return listOfCountries.get(index);
    }

    public int countriesSize (){
        return listOfCountries.size();
    }

    @Override
    public int compare(Country country1, Country country2) {
        return Double.compare(country1.getFullTaxInPercent(), country2.getFullTaxInPercent());
    }


    public static CountryController importFromFile(String fileName) throws TaxException {
        CountryController countries = new CountryController();
        Comparator<Country> compareByTax = (o1, o2) -> Double.compare(o1.getFullTaxInPercent(), o2.getFullTaxInPercent());
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()){
                String inputLine = scanner.nextLine();
                String[] items = inputLine.split(countries.DELIMITER_FOR_FILE);

                if (items.length!=5) throw new TaxException(
                        "The number of items does not correct on: "+inputLine+(items.length+"items"));
                Country country = new Country(items[1],items[0],items[2],items[3],items[4]);
                countries.addCountry(country);
                Collections.sort(listOfCountries, compareByTax.reversed() );
            }
        }
        catch (FileNotFoundException ex) {
            throw new TaxException("File: " + fileName + "Not Found" + ex.getMessage());
        }
        return countries;
    }

    public void exportToFile (String fileName) throws TaxException{
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
            for( Country country:listOfCountries){
                formatCountryList(getCountriesWithBiggerAndNoSpecialTax());
                writer.println(country.getNameOfCountry()+DELIMITER_FOR_FILE +
                        country.getCountryCode()+DELIMITER_FOR_FILE+
                        country.getFullTaxInPercent()+DELIMITER_FOR_FILE+
                        country.getExtraTax());
            }
        }catch (FileNotFoundException exa){
            throw new TaxException("File: "+ fileName+"is not found"+exa.getMessage());
        }

    }

    public List<Country> getCountriesWithBiggerAndNoSpecialTax(){
        List<Country> result = new ArrayList<>();
        for (Country country:listOfCountries) {

            if (country.getFullTaxInPercent()>20
                            &&
                    country.getExtraTax()==false) {

                result.add(country);
            }
        }
        return result;
    }

    public List<Country>getCountriesWithLowerAndSpecialTax(){
        List<Country> result = new ArrayList<>();
        for (Country country:listOfCountries) {

            if (country.getFullTaxInPercent()<=20
                    &&
                    country.getExtraTax()!=false) {

                result.add(country);
            }
        }
        return result;
    }

    public static String formatCountryList(List<Country> list) {
        StringBuilder builder = new StringBuilder(
                "List of countries with higher tax than 20 % and no extra tax: (" + list.size() + " items):" + System.lineSeparator());
        list.stream().forEach(
                country -> {
                    builder.append(" * " + country);
                    builder.append(System.lineSeparator());
                });
        return builder.toString();
    }

    public static String differentFormatCountryList(List<Country> list) {
        StringBuilder builder = new StringBuilder(
                "List of countries with lower than 20 % tax and extra tax: (" + list.size() + " items):" + System.lineSeparator());
        list.stream().forEach(
                country -> {
                    builder.append(" * " + country);
                    builder.append(System.lineSeparator());
                });
        return builder.toString();
    }

    public static void getCountriesByTax(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your value of tax (in %), or press ENTER to use default value 20%");
        List<Country>countryList = new ArrayList<>();

        String tax = scanner.nextLine();
        int taxInteger;
        if (tax.isEmpty()){
            taxInteger = 20;
            countryList = getCountriesWithBiggerOrEqualTax(taxInteger);
        }else {
            taxInteger = Integer.valueOf(tax);
            countryList = getCountriesWithBiggerOrEqualTax(taxInteger);
        }
        System.out.println();
    }

    public static List<Country> getCountriesWithBiggerOrEqualTax(int tax) {
        List<Country>result = new ArrayList<>();
        for (Country country:listOfCountries) {
            if (country.getFullTaxInPercent()>=tax){
                result.add(country);
            }

        }
        return result;
    }

}



