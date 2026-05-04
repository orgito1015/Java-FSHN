import java.util.ArrayList;
import java.util.List;

/**
 * Klasa Prona – ruan te dhenat e nje prone per shitje dhe listen e klienteve te interesuar.
 *
 * Lidhja ndermjet Prona dhe Klient (Composition / HAS-A):
 *   Nje prove "ka" disa klienta te interesuar. Prona menaxhon listen e Klienteve.
 *   Klientet jane te lidhur me nje prone specifike dhe trajtohen brenda asaj prone.
 *   Kjo eshte nje marredhenie komposite: Prona = e tere; Klient = pjese e te teres.
 *
 * Metodat:
 *   shtoKlient()    – shton nje klient te ri ne listen e te interesuarve
 *   numëroKlientë() – kthen numrin e klienteve te interesuar
 *   ofertaMaks()    – kthen klientin qe ka bere oferten me te larte
 */
public class Prona {

    private String       emri;
    private List<Klient> klientet;

    public Prona(String emri) {
        this.emri     = emri;
        this.klientet = new ArrayList<>();
    }

    public String getEmri()            { return emri; }
    public void   setEmri(String emri) { this.emri = emri; }
    public List<Klient> getKlientet()  { return klientet; }

    /** Shton nje klient te ri te interesuar per prone. */
    public void shtoKlient(Klient k) {
        klientet.add(k);
    }

    /** Kthen numrin e klienteve te interesuar per kete prone. */
    public int numëroKlientë() {
        return klientet.size();
    }

    /**
     * Kthen klientin qe ka bere oferten me te larte.
     * Kthen null nese nuk ka asnje klient.
     */
    public Klient ofertaMaks() {
        if (klientet.isEmpty()) return null;
        Klient maks = klientet.get(0);
        for (Klient k : klientet) {
            if (k.getOferta() > maks.getOferta()) {
                maks = k;
            }
        }
        return maks;
    }

    @Override
    public String toString() {
        return String.format("Prona{emri='%s', klientet=%d}", emri, klientet.size());
    }
}
