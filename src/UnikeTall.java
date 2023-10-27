import javax.swing.*;
import java.util.Arrays;

public class UnikeTall {
    // Deklarasjon av array for lagring av tilfeldige heltall
    private int[] array;

    /* Konstruktør som mottar arrayets lengde som parameter og
     oppretter arrayet.  */
    public UnikeTall(int arrayLength) {
        array = new int[arrayLength];
    }

    /* Metode som skal undersøke om et gitt tall finnes i arrayet fra før.
     Tallet det letes etter skal mottas som parameter.
     Metoden skal returnere true hvis tallet finnes i arrayet.
     Hvis ikke skal metoden returnere false. */

    public boolean finnesTall(int tall) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == tall) {
                return true;
            }
        }
        return false;
    }


    /* Metode som skal fylle arrayet med tilfeldige tall mellom 100 og 999,
     begge grenser inkludert. Metoden skal gjøre dette på en måte
     som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
     parametre og heller ikke returnere noen verdi.
     Tips bruk (int)(Math.random()*(900)+100); for å generere tallene mellom 100 og 999
   */
    public void fyllArray() {
        for (int i = 0; i < array.length; i++) {
            int num;
            do {
                num = (int) (Math.random() * 900 + 100);
            } while (finnesTall(num));
            array[i] = num;
        }
    }


    // Metode som finner og returnerer det minste tallet i arrayet.
    public int finnMinsteTall() {
        if (array.length == 0) {
            throw new IllegalStateException("Arrayet er tomt.");
        }

        int minsteTall = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minsteTall) {
                minsteTall = array[i];
            }
        }

        return minsteTall;
    }

    // Metode som finner og returnerer det største tallet i arrayet.
    public int finnStorsteTall() {
        int storsteTall = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > storsteTall) {
                storsteTall = array[i];
            }
        }

        return storsteTall;
    }

    /*  Metode som beregner og returnerer den gjennomstnittlige verdien
     (double-verdi) av tallene i arrayet.  */
    public double beregnGjennomsnitt() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double gjennomsnitt = (double) sum / array.length;
        return gjennomsnitt;
    }

    /* Metode som viser tallene i arrayet i en meldngsboks.
     I tillegg skal det, i meldingsboks, skrives ut
     opplysninger om hvilket tall som er minst, hvilket som er størst, og
     hva som er gjennomsnittsverdien, jfr bildet over. Gjennomsnittverdien
     skal skrives ut med en desimal. Bruk gjerne String.format("%.2f,tall) til dette.
     Legg inn mellomrom mellom tallene og skriv ut et passende antall tall
     per linje. */
    public void visTallIMeldingsboks() {
        int minsteTall = finnMinsteTall();
        int storsteTall = finnStorsteTall();
        double gjennomsnitt = beregnGjennomsnitt();

        StringBuilder melding = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            melding.append(array[i]).append(" ");

            if ((i+1) % 10 == 0) {
                melding.append("\n");
            }
        }

        melding.append("\nMinste tall: ").append(minsteTall);
        melding.append("\nStørste tall: ").append(storsteTall);
        melding.append("\nGjennomsnitt: ").append(String.format("%.1f", gjennomsnitt));

        JOptionPane.showMessageDialog(null, melding.toString());
    }
}
