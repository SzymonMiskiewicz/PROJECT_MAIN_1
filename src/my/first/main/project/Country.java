package my.first.main.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Country {

    private String countryCode;
    private String nameOfCountry;
    private double fullTaxInPercent;
    private double decreaseTaxInPercent;
    private boolean extraTax;



    public Country(String nameOfCountry, String countryCodes, double fullTaxPercent,
                   double decreaseTaxPercent, boolean extraTax) {
        this.nameOfCountry = nameOfCountry;
        this.countryCode = countryCodes;
        this.fullTaxInPercent = fullTaxPercent;
        this.decreaseTaxInPercent = decreaseTaxPercent;
        this.extraTax = extraTax;
    }

    public Country(String nameOfCountryStr, String countryCodesStr, String fullTaxPercentStr,
                   String decreaseTaxPercentStr, String extraTaxStr) throws TaxException {
        this.nameOfCountry = nameOfCountryStr;
        this.countryCode = countryCodesStr;
        try {
            this.fullTaxInPercent = Double.parseDouble(fullTaxPercentStr);
            this.decreaseTaxInPercent = Double.parseDouble(decreaseTaxPercentStr);
        } catch (NumberFormatException e) {
            throw new TaxException("Bad format of tax: " + e.getMessage());
        }
        this.extraTax = Boolean.parseBoolean(extraTaxStr);
    }

    public static Country parse(String inputLine, String delimiter) throws ParseException, TaxException {
        String[] items = inputLine.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems != 5) throw new ParseException("Number of items is not correct: " + numberOfItems
                + "on the line: " + inputLine, 0);

        String countryCode = items[0];
        String nameOfCountry = items[1];
        double fullTaxInPercent = Double.parseDouble(items[2]);
        double decreaseTaxInPercent = Double.parseDouble(items[3]);
        boolean extraTax = Boolean.parseBoolean(items[4]);

        return new Country(countryCode, nameOfCountry.toUpperCase(Locale.ROOT),
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

    //    public String getCountryCodes (String nameOfCountry){
//        String[] isoCountryCodes = Locale.getISOCountries();
//        for (String code : isoCountryCodes) {
//            Locale locale = new Locale("", code);
//            if (code.equalsIgnoreCase(locale.getDisplayCountry())) {
//                return code;
//            }
//        }
//
//        return countryCode;
//
//    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public double getFullTaxInPercent() {
        return fullTaxInPercent;
    }

    public void setFullTaxInPercent(double fullTaxInPercent) {
        this.fullTaxInPercent = fullTaxInPercent;
    }

    public double getDecreaseTaxInPercent() {
        return decreaseTaxInPercent;
    }

    public void setDecreaseTaxInPercent(double decreaseTaxInPercent) {
        this.decreaseTaxInPercent = decreaseTaxInPercent;
    }

    public boolean getExtraTax() {
        return extraTax;
    }

    public void setExtraTax(boolean extraTax) {
        this.extraTax = extraTax;
    }






    public String getDescription() {
        return ("Name of Country: " + getNameOfCountry()+ "(" +getCountryCode()+")"+ "Tax: "+getExtraTax());

    }

 
}
