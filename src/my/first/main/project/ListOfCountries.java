package my.first.main.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ListOfCountries {

   public static List<Country>listOfCountries = new ArrayList<>();

    public void importFromFile(String vatFile) throws TaxException{
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(pathAndFile)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()){
                String record = scanner.nextLine();
                lineNumber++;
                try{
                    this.addCountry(Country.parse(record,"/t"));
                    listOfCountries.get(record).getCountryCodes();
                }
            }
        }
    }
}
