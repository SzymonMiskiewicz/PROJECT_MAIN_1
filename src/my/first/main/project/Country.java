package my.first.main.project;

import java.text.ParseException;
import java.util.Locale;

public class Country {

    private String nameOfCountry;
    private String countryCode;
    private int fullTaxInPercent;
    private int decreaseTaxInPercent;
    private boolean extraTax;



    public Country(String nameOfCountry, String countryCodes, int fullTaxPercent,
                   int decreaseTaxPercent, boolean extraTax){
        this.nameOfCountry =nameOfCountry;
        this.countryCode = countryCodes;
        this.fullTaxInPercent = fullTaxPercent;
        this.decreaseTaxInPercent = decreaseTaxPercent;
        this.extraTax = extraTax;
    }

    public static String parse(String inputLine, String delimiter) throws ParseException {
        String [] items = inputLine.split(delimiter);

        int numberOfItems = items.length;
        if (numberOfItems !=5) throw new ParseException("Number of items is not correct: "+numberOfItems
                +"on the line: "+inputLine,0);

        String nameOfCountry = items[0];
        String countryCode = items[1];
        int fullTaxInPercent = Integer.parseInt(items[2]);
        int decreaseTaxInPercent = Integer.parseInt(items[3]);
        String extraTax = boolean.toString(items[4]);

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
    public int getFullTaxInPercent(){
        return fullTaxInPercent;
    }
    public void setFullTaxInPercent(int fullTaxInPercent){
        this.fullTaxInPercent = fullTaxInPercent;
    }
    public int getDecreaseTaxInPercent(){
        return decreaseTaxInPercent;
    }
    public void setDecreaseTaxInPercent(int decreaseTaxInPercent){
        this.decreaseTaxInPercent = decreaseTaxInPercent;
    }
    public boolean getExtraTax(boolean b, boolean b2){
        boolean b = true;
        boolean b2 = false;
        if (ge)
        String str = String.valueOf(b);
        String str2 = String.valueOf(b2);
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
