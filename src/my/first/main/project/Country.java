package my.first.main.project;

public class Country  {

    private String countryCode;
    private String nameOfCountry;
    private double fullTaxInPercent;
    private double decreaseTaxInPercent;
    private boolean extraTax;


        public Country(String nameOfCountryStr, String countryCodesStr, String fullTaxInPercentStr,
                   String decreaseTaxPercentStr,String extraTaxStr) {
        this.nameOfCountry = nameOfCountryStr;
        this.countryCode = countryCodesStr;
        this.fullTaxInPercent = Double.parseDouble(fullTaxInPercentStr);
        this.decreaseTaxInPercent = Double.parseDouble(decreaseTaxPercentStr);
        this.extraTax = Boolean.parseBoolean(extraTaxStr);
    }
    public Country(String nameOfCountry, int fullTaxInPercent) {
        this.nameOfCountry = nameOfCountry;
            this.fullTaxInPercent = fullTaxInPercent;
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

    public void setFullTaxInPercent(int fullTaxInPercent) throws TaxException {
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

    public String toString(){
        String info = (nameOfCountry + " (" +countryCode+") "
                +fullTaxInPercent)+" % " ;
        return info;
    }


}
