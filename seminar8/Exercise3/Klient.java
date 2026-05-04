/**
 * Klasa Klient – ruan te dhenat e nje klienti te interesuar per blerjen e nje prone.
 *
 * Variablat instance:
 *   emri   – emri i klientit
 *   oferta – oferta (çmimi) qe klienti ka bere per prone (ne EUR)
 */
public class Klient {

    private String emri;
    private double oferta;

    public Klient(String emri, double oferta) {
        this.emri   = emri;
        this.oferta = oferta;
    }

    public String getEmri()     { return emri; }
    public double getOferta()   { return oferta; }

    public void setEmri(String emri)       { this.emri   = emri; }
    public void setOferta(double oferta)   { this.oferta = oferta; }

    @Override
    public String toString() {
        return String.format("Klient{emri='%s', oferta=%.2f EUR}", emri, oferta);
    }
}
