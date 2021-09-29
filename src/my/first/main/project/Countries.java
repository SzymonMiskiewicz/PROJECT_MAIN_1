package my.first.main.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Countries {

    public static final String TAB = "/t";
    public static List<Country> listOfCountries = new ArrayList<>();

   public void addCountry(Country newCountry){
       listOfCountries.add(newCountry);
   }

    public void importFromFile(String vatFile) throws TaxException{
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(vatFile)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String record = scanner.nextLine();
                lineNumber++;
                try {
                    this.addCountry(Country.parse(record),TAB);
                } catch (ParseException e) {
                    ""+e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e){
            throw new TaxException("Input file :"+vatFile+"was not found. "+e.getMessage());
        }
    }
}
