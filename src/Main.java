public class Main {
    public static void main(String[] args) {
        // Oppretter en ny instans av UnikeTall klassen med et array av lengde 20
        UnikeTall unikeTall = new UnikeTall(100);

        // Kaller metoden for å fylle arrayet med unike tall
        unikeTall.fyllArray();

        unikeTall.visTallIMeldingsboks();

        int minsteTall = unikeTall.finnMinsteTall();
        int storsteTall = unikeTall.finnStorsteTall();
        double gjennomsnitt = unikeTall.beregnGjennomsnitt();

        System.out.println("Minste tall: " + minsteTall);
        System.out.println("Største tall: " + storsteTall);
        System.out.println("Gjennomsnitt: " + String.format("%.1f", gjennomsnitt));
    }
}