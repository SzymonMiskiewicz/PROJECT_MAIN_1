package my.first.main.project;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
            scanner.useLocale(Locale.GERMANY);
            while (scanner.hasNextLine() ) {
                String inputLine = scanner.nextLine();
                String c1 = scanner.next();
                String c2 = scanner.next();
                Double c3 = scanner.nextDouble();
                Double c4 = scanner.nextDouble();
                Boolean c5 = scanner.nextBoolean();
                this.addCountry(new Country(c1, c2, c3, c4, c5));
                lineNumber++;

                //try {
                    //addCountry(Country.parse(inputLine, DELIMITER_FOR_FILE));
                //} catch (ParseException e) {
                    //e.printStackTrace();
//                    throw new TaxException(
//                            "Invalid input file: "+fileName+ " line number: " + lineNumber+ "," +e.getMessage());
                //}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new TaxException("Input file : " + fileName + " was not found. " + e.getMessage());
        }

    }






}



