package my.first.main.project;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";

    public static void main(String[] args) {
        Countries country = new Countries();

        try{
        country.importFromFile(INPUTFILE);
    } catch (TaxException e) {
            System.err.println(e.getMessage());
        }
//        for (int i = 0; i < country.countriesSize(); i++) {
//            System.out.println("jak to wgrać");
//    }
    }
}
