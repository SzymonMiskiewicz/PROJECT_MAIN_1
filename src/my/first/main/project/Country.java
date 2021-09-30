package my.first.main.project;

import java.text.ParseException;
import java.util.Locale;

public class Country {

    private String countryCode;
    private String nameOfCountry;
    private double fullTaxInPercent;
    private double decreaseTaxInPercent;
    private boolean extraTax;



    public Country(String nameOfCountry, String countryCodes, double fullTaxPercent,
                   double decreaseTaxPercent, boolean extraTax) throws TaxException{
        this.nameOfCountry =nameOfCountry;
        this.countryCode = countryCodes;
        try {
            this.fullTaxInPercent = fullTaxPercent;
            this.decreaseTaxInPercent = decreaseTaxPercent;
        }catch (NumberFormatException e){
            throw new TaxException("Bad format of tax: "+e.getMessage());
        }
        this.extraTax = extraTax;
    }

    public static Country parse(String inputLine, String delimiter) throws ParseException, TaxException {
        String [] items = inputLine.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems !=5) throw new ParseException("Number of items is not correct: "+numberOfItems
                +"on the line: "+inputLine,0);

        String countryCode = items[0];
        String nameOfCountry = items[1];
        double fullTaxInPercent = Double.parseDouble(items[2]);
        double decreaseTaxInPercent = Double.parseDouble(items[3]);
        boolean extraTax = Boolean.parseBoolean(items[4]);

        return new Country(countryCode,nameOfCountry.toUpperCase(Locale.ROOT)
                ,fullTaxInPercent,decreaseTaxInPercent,extraTax);
    }


    public String getNameOfCountry(){
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry){
        this.nameOfCountry = nameOfCountry;

    }
    public String getCountryCodes (String nameOfCountry){
        String[] isoCountryCodes = Locale.getISOCountries();
        for (String code : isoCountryCodes) {
            Locale locale = new Locale("", code);
            if (code.equalsIgnoreCase(locale.getDisplayCountry())) {
                return code;
            }
        }

        return countryCode;

    }
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    public double getFullTaxInPercent(){
        return fullTaxInPercent;
    }
    public void setFullTaxInPercent(double fullTaxInPercent){
        this.fullTaxInPercent = fullTaxInPercent;
    }
    public double getDecreaseTaxInPercent(){
        return decreaseTaxInPercent;
    }
    public void setDecreaseTaxInPercent(double decreaseTaxInPercent){
        this.decreaseTaxInPercent = decreaseTaxInPercent;
    }
    public boolean getExtraTax(){
        return extraTax;
    }
    public void setExtraTax(boolean extraTax){
        this.extraTax = extraTax;
    }


    public String toString(){
        return "Name of Country: "+getNameOfCountry()+"("+getCountryCodes(getNameOfCountry()
                +") Basic tax is: "+ getFullTaxInPercent());
    }

}
