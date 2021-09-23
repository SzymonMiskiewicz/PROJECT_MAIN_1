package my.first.main.project;

import java.util.Locale;

public class Country {

    private String nameOfCountry;
    private String countryCodes;
    private int fullTaxPercent;
    private int decreaseTaxPercent;
    private boolean specialTaxOfProducts;

    public Country(String nameOfCountry, String countryCodes, int fullTaxPercent,
                   int decreaseTaxPercent, boolean specialTaxOfProducts ){
        this.nameOfCountry =nameOfCountry;
        this.countryCodes = countryCodes;
        this.fullTaxPercent = fullTaxPercent;
        this.decreaseTaxPercent = decreaseTaxPercent;
        this.specialTaxOfProducts = specialTaxOfProducts;
    }
    public String getNameOfCountry(){
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry){
        this.nameOfCountry = nameOfCountry;

    }
    public String getCountryCodes(String nameOfCountry){
        String[] isoCountryCodes = Locale.getISOCountries();
        for (String code: isoCountryCodes ) {
            Locale locale = new Locale("",code);
            if (nameOfCountry.equalsIgnoreCase(locale.getDisplayCountry())){
                return code;
            }

        }
        return countryCodes;
    }
    public void setCountryCodes(String countryCodes){
        this.countryCodes = countryCodes;
    }
    public int getFullTaxPercent(){
        return fullTaxPercent;
    }
    public void setFullTaxPercent(int fullTaxPercent){
        this.fullTaxPercent = fullTaxPercent;
    }
    public int getDecreaseTaxPercent(){
        return decreaseTaxPercent;
    }
    public void setDecreaseTaxPercent(int decreaseTaxPercent){
        this.decreaseTaxPercent = decreaseTaxPercent;
    }
    public boolean getSpecialTaxOfProducts(){
        return specialTaxOfProducts;
    }
    public void setSpecialTaxOfProducts(boolean specialTaxOfProducts){
        this.specialTaxOfProducts = specialTaxOfProducts;
    }

}
