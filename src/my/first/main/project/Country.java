package my.first.main.project;


import java.util.ArrayList;
import java.util.List;


public class Country {


    private String countryCode;
    private String nameOfCountry;
    private double fullTaxInPercent;
    private double decreaseTaxInPercent;
    private boolean extraTax;


//    public Country(String nameOfCountry, String countryCodes, double fullTaxPercent,
//                   double decreaseTaxPercent, boolean extraTax) {
//        this.nameOfCountry = nameOfCountry;
//        this.countryCode = countryCodes;
//        this.fullTaxInPercent = fullTaxPercent;
//        this.decreaseTaxInPercent = decreaseTaxPercent;
//        this.extraTax = extraTax;

        public Country(String nameOfCountryStr, String countryCodesStr, String fullTaxPercentStr,
                   String decreaseTaxPercentStr, String extraTaxStr) {
        this.nameOfCountry = nameOfCountryStr;
        this.countryCode = countryCodesStr;
        this.fullTaxInPercent = Double.parseDouble(fullTaxPercentStr);
        this.decreaseTaxInPercent = Double.parseDouble(decreaseTaxPercentStr);
        this.extraTax = Boolean.parseBoolean(extraTaxStr);
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
        String info = ("Name of Country: " + nameOfCountry
                + " (" +countryCode+") "+ "Tax: "+fullTaxInPercent
                +" %"+" Extra Tax: "+extraTax);
        return info;
    }

    public String toString(){
        String info = ("Name of Country: " + nameOfCountry + " (" +countryCode+") "
                + "Tax: "+fullTaxInPercent)+" %"+"Extra Tax: " +extraTax ;
        return info;
    }
}
