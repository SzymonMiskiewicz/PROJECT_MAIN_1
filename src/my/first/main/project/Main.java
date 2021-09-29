package my.first.main.project;

public class Main {

    public static final String INPUTFILE = "vat-eu.csv";

    public static void main(String[] args) {
        Countries list = new Countries();

        System.out.println();
        try{
        list.importFromFile(INPUTFILE);
    } catch (TaxException e) {
            System.err.println(INPUTFILE+e.getMessage());
        }
    }
}
