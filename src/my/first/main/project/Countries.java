package my.first.main.project;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void importFromFile(String fileName) throws TaxException {
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                lineNumber++;
                try {
                    addCountry(Country.parse(inputLine, DELIMITER_FOR_FILE));
                } catch (ParseException e) {
                   throw new TaxException(
                           "Invalid input file: "+fileName+ " line number: " + lineNumber+ "," +e.getMessage());
                }
//                System.out.println(inputLine);
            }
        } catch (FileNotFoundException e) {
            throw new TaxException("Input file : " + fileName + " was not found. " + e.getMessage());
        }

    }
    public String getBasicInfo(){
        StringBuilder info = new StringBuilder();
        for (Country country:listOfCountries) {
            info.append(country.getNameOfCountry())
                    .append(country.getCountryCode())
                    .append(country.getFullTaxInPercent());



        }
        return info.toString();
    }


}
