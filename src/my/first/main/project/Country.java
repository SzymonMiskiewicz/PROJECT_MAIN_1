package my.first.main.project;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Country {


    private String countryCode;
    private String nameOfCountry;
    private double fullTaxInPercent;
    private double decreaseTaxInPercent;
    private boolean extraTax;
    private List<Countries> countriesList = new ArrayList<>();




    public Country(String nameOfCountry, String countryCodes, double fullTaxPercent,
                   double decreaseTaxPercent, boolean extraTax) {
        this.nameOfCountry = nameOfCountry;
        this.countryCode = countryCodes;
        this.fullTaxInPercent = fullTaxPercent;
        this.decreaseTaxInPercent = decreaseTaxPercent;
        this.extraTax = extraTax;
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
        String info = ("Name of Country: " + getNameOfCountry()
                        + "(" +getCountryCode()+")"+ "Tax: "+getDecreaseTaxInPercent())+" %";
        return info;
    }


}
