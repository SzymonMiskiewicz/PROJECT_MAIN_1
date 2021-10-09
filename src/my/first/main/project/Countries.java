package my.first.main.project;

import java.io.*;
import java.util.*;

public class Countries {

    private List<Country> listOfCountries = new ArrayList<>();
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



//    public void importFromFile(String fileName) throws TaxException {
//        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
//            while (scanner.hasNextLine() ) {
//                String inputLine = scanner.nextLine();
//                scanner.useDelimiter(DELIMITER_FOR_FILE);
//                String countryCode = scanner.next();
//                String countryName = scanner.next();
//                Double countryFullTax = scanner.nextDouble();
//                Double countryDecreaseTax = scanner.nextDouble();
//                Boolean countryExtraTax = scanner.nextBoolean();
//                addCountry(new Country(countryCode, countryName, countryFullTax, countryDecreaseTax, countryExtraTax));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            throw new TaxException("Input file : " + fileName + " was not found. " + e.getMessage());
//        }
//
//    }
    public static Countries importFromFile(String fileName) throws TaxException {
        Countries countries = new Countries();
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()){
                String inputLine = scanner.nextLine();
                String[] items = inputLine.split(countries.DELIMITER_FOR_FILE);
                if (items.length!=5) throw new TaxException(
                        "The number of items does not correct on: "+inputLine+(items.length+"items"));
                Country country = new Country(items[1],items[0],items[2],items[3],items[4]);
                countries.addCountry(country);
            }
        }
        catch (FileNotFoundException ex) {
            throw new TaxException("File: " + fileName + "Not Found" + ex.getMessage());
        }
        return countries;
    }






}



