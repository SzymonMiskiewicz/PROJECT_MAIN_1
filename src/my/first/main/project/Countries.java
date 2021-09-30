package my.first.main.project;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Countries {

    public static final String TAB = "\t";
    private List<Country> listOfCountries = new ArrayList<>();

   public void addCountry(Country newCountry){
       listOfCountries.add(newCountry);
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
                System.out.println(record);
                try {
                    this.addCountry(Country.parse(record, TAB));
                } catch (ParseException e) {
                    throw new TaxException(
                            "Invalid input file: " + fileName + " line number: " + lineNumber + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new TaxException("Input file :" + fileName + " was not found. " + e.getMessage());
        }

    }




}
