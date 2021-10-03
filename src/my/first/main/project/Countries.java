package my.first.main.project;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Countries {

    private List<Country> listOfCountries = new ArrayList<>();

    public void add(Country country){
        listOfCountries.add(country);
    }

    public int countriesSize (){
        return listOfCountries.size();
    }
    public void importFromFile(String fileName) throws TaxException {
        try (Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(fileName)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                lineNumber++;

//                System.out.println(record);
            }
        } catch (FileNotFoundException e) {
            throw new TaxException("Input file :" + fileName + " was not found. " + e.getMessage());
        }

    }
    public String getBasicInfo(){
        StringBuilder info = new StringBuilder("Number of Countries: "+listOfCountries.size());
        for (Country country:listOfCountries) {
            info.append(country.getNameOfCountry())
                    .append(country.getCountryCode())
                    .append(country.getFullTaxInPercent());



        }
        return info.toString();
    }
    public static String formatCountryList(List<Country> list) {
        StringBuilder builder = new StringBuilder(
                "Number of Countries (" + list.size() + " items):" + System.lineSeparator());
        list.stream().forEach(
                country -> {
                    builder.append(" * " + country);
                    builder.append(System.lineSeparator());
                });
        return builder.toString();


    }

}
