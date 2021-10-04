package my.first.main.project;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Country {

    public static final String NR = "\n";
    private String countryCode;
    private String nameOfCountry;
    private int fullTaxInPercent;
    private int decreaseTaxInPercent;
    private boolean extraTax;
    private List<Countries> countriesList = new ArrayList<>();




    public Country(String nameOfCountry, String countryCodes, int fullTaxPercent,
                   int decreaseTaxPercent, boolean extraTax) {
        this.nameOfCountry = nameOfCountry;
        this.countryCode = countryCodes;
        this.fullTaxInPercent = fullTaxPercent;
        this.decreaseTaxInPercent = decreaseTaxPercent;
        this.extraTax = extraTax;
    }



    public static Country parse(String inputLine, String delimiter) throws ParseException {
        String[] items = inputLine.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems != 5) throw new ParseException(" Number of items is not correct: "
                + numberOfItems+ ","
                + " on the line: " + inputLine, 0);

        String countryCode = items[0];
        String nameOfCountry = items[1];
        int fullTaxInPercent = Integer.parseInt(items[2]);
        int decreaseTaxInPercent = Integer.parseInt(items[3]);
        boolean extraTax = Boolean.parseBoolean(items[4]);

        return new Country(countryCode,nameOfCountry.toUpperCase(Locale.ROOT),
                fullTaxInPercent, decreaseTaxInPercent, extraTax);
    }


    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;

    }

    public String getCountryCode() {
        return countryCode;
    }


    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getFullTaxInPercent() {
        return fullTaxInPercent;
    }

    public void setFullTaxInPercent(int fullTaxInPercent) {
        this.fullTaxInPercent = fullTaxInPercent;
    }

    public double getDecreaseTaxInPercent() {
        return decreaseTaxInPercent;
    }

    public void setDecreaseTaxInPercent(int decreaseTaxInPercent) {
        this.decreaseTaxInPercent = decreaseTaxInPercent;
    }

    public boolean getExtraTax() {
        return extraTax;
    }

    public void setExtraTax(boolean extraTax) {
        this.extraTax = extraTax;
    }






    public String getDescription() {
        StringBuilder info = new StringBuilder(
                "Name of Country: " + getNameOfCountry()+ "(" +getCountryCode()+")"+ "Tax: "+getExtraTax());



        return info.toString();
    }

 
}
