package my.first.main.project;

import java.io.*;
import java.util.*;

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

    public void exportToFile(String fileName) throws TaxException {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
            for( Country country: listOfCountries) {
                writer.println(country.getNameOfCountry() + DELIMITER_FOR_FILE +
                        country.getCountryCode() + DELIMITER_FOR_FILE +
                        country.getFullTaxInPercent() + DELIMITER_FOR_FILE +
                        country.getExtraTax());
            }
        }catch (FileNotFoundException e){
                throw new TaxException("File: "+ fileName+"is not found"+e.getMessage());
        }

    }

    public void exportToFileByTax(String fileName) throws TaxException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your value of tax (in %), or press ENTER to use default value 20%");
        List<Country> biggerOrEqual;
        List<Country> smaller;
        String tax = scanner.nextLine();
        int taxInteger;
        if (tax.isEmpty()){
            taxInteger = 20;
        } else {
            taxInteger = Integer.valueOf(tax);
        }
        biggerOrEqual = getCountriesWithBiggerOrEqualTax(taxInteger);
        smaller = getSmallerTax(taxInteger);

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))){
            writer.println("Countries with tax bigger or equal than " + taxInteger +"%:\n");
            for( Country country:biggerOrEqual){
                formatCountryList(getCountriesWithBiggerOrEqualTax(taxInteger));
                writer.println(country.getNameOfCountry()+DELIMITER_FOR_FILE +
                        country.getCountryCode()+DELIMITER_FOR_FILE+
                        country.getFullTaxInPercent()+DELIMITER_FOR_FILE+
                        country.getExtraTax());
            }
            writer.print(Main.GAP);

            writer.println("Countries with tax smaller than " + taxInteger +"%:\n");
            for( Country country:smaller) {
                formatCountryList(getSmallerTax(taxInteger));
                writer.println(country.getNameOfCountry() + DELIMITER_FOR_FILE +
                        country.getCountryCode() + DELIMITER_FOR_FILE +
                        country.getFullTaxInPercent() + DELIMITER_FOR_FILE +
                        country.getExtraTax());
            }

        }catch (FileNotFoundException exa){
            throw new TaxException("File: "+ fileName+"is not found"+exa.getMessage());
        }

    }

    public List<Country> getCountriesWithBiggerAndNoSpecialTax(){
        List<Country> bigAndNoSpecial = new ArrayList<>();
        for (Country country:listOfCountries) {
            if (country.getFullTaxInPercent()>20
                            &&
                    country.getExtraTax()==false) {
                bigAndNoSpecial.add(country);
            }
        }
        return bigAndNoSpecial;
    }

    public List<Country>getCountriesWithLowerAndSpecialTax(){
        List<Country> lowAndSpecial = new ArrayList<>();
        for (Country country:listOfCountries) {
            if (country.getFullTaxInPercent()<=20
                    &&
                    country.getExtraTax()!=false) {
                lowAndSpecial.add(country);
            }
        }
        return lowAndSpecial;
    }
    public static List<Country> getCountriesWithBiggerOrEqualTax(int tax) {
        List<Country>bigOrEqual = new ArrayList<>();
        for (Country country:listOfCountries) {
            if (country.getFullTaxInPercent()>=tax){
                bigOrEqual.add(country);
            }

        }
        return bigOrEqual;
    }
    public static List<Country>getSmallerTax(int tax){
        List<Country>smaller = new ArrayList<>();
        for (Country country:listOfCountries){
            if (country.getFullTaxInPercent()<tax){
                smaller.add(country);
            }
        }
        return smaller;
    }

    public static void getCountriesByTax(){
        Scanner scanner = new Scanner(System.in);
        List<Country>countryList = new ArrayList<>();
        String tax;
        do {
            System.out.println("Write your value of tax (in %), or press ENTER to use default value 20%");
            tax = scanner.nextLine();
            if (!tax.equals("END")) {
                int taxInteger;
                if (tax.isEmpty()) {
                    taxInteger = 20;
                    countryList = getCountriesWithBiggerOrEqualTax(taxInteger);
                } else {
                    taxInteger = Integer.valueOf(tax);
                    countryList = getCountriesWithBiggerOrEqualTax(taxInteger);
                }
                System.out.println(anotherFormatCountryList(countryList, taxInteger));
            }System.out.println("Incorrect value. Please enter correct value (natural number or \"END\").");

            }
            while (!tax.equals("END")) ;

    }

    public static String anotherFormatCountryList(List<Country> list, int tax) {
        StringBuilder builder = new StringBuilder(
                "List of countries with higher or equal tax "
                        + tax +" % and extra tax: ("
                        + list.size() + " items):"
                        + System.lineSeparator());
        list.stream().forEach(
                country -> {
                    builder.append(" * " + country);
                    builder.append(System.lineSeparator());
                });
        return builder.toString();
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
                "List of countries with lower than 20 % tax and extra tax: ("
                        + list.size() + " items):"
                        + System.lineSeparator());
        list.stream().forEach(
                country -> {
                    builder.append(" * " + country);
                    builder.append(System.lineSeparator());
                });
        return builder.toString();
    }

}



