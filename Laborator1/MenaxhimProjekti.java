import java.util.ArrayList;

/**
 * MenaxhimProjekti — Klasa e Menaxhimit të Projektit
 *
 * Shpjegim:
 * - Kjo klasë modelon një projekt me emër, buxhet total, dhe listë anëtarësh.
 * - Konstruktori me parametra inicializon të gjitha fushat.
 * - Konstruktori pa parametra krijon një projekt bosh me buxhet 0 dhe listë bosh.
 * - Getter dhe setter për çdo fushë.
 * - isProjektIMadh() kthen true nëse buxheti i tejkalon 50,000 Euro.
 * - shtoAnetar() shton një anëtar të ri në listë.
 */
public class MenaxhimProjekti {

    private String emriProjektit;
    private double buxhetiTotal;
    private ArrayList<String> anetaret;

    /** Konstruktori me parametra */
    public MenaxhimProjekti(String emriProjektit, double buxhetiTotal) {
        this.emriProjektit = emriProjektit;
        this.buxhetiTotal = buxhetiTotal;
        this.anetaret = new ArrayList<>();
    }

    /** Konstruktori pa parametra (no-arg) */
    public MenaxhimProjekti() {
        this.emriProjektit = "";
        this.buxhetiTotal = 0.0;
        this.anetaret = new ArrayList<>();
    }

    // ---- Getters ----

    public String getEmriProjektit() {
        return emriProjektit;
    }

    public double getBuxhetiTotal() {
        return buxhetiTotal;
    }

    public ArrayList<String> getAnetaret() {
        return anetaret;
    }

    // ---- Setters ----

    public void setEmriProjektit(String emriProjektit) {
        this.emriProjektit = emriProjektit;
    }

    public void setBuxhetiTotal(double buxhetiTotal) {
        this.buxhetiTotal = buxhetiTotal;
    }

    public void setAnetaret(ArrayList<String> anetaret) {
        this.anetaret = anetaret;
    }

    // ---- Metoda shtese ----

    /**
     * Shton nje anetar te ri ne listen e anetareve te projektit.
     *
     * @param anetar emri i anetarit qe shtohet
     */
    public void shtoAnetar(String anetar) {
        anetaret.add(anetar);
    }

    /**
     * Kontrollon nese projekti ka buxhet te madh (mbi 50,000 Euro).
     *
     * @return true nese buxheti > 50000, false ne rast tjeter
     */
    public boolean isProjektIMadh() {
        return buxhetiTotal > 50000;
    }

    @Override
    public String toString() {
        return "Projekti: " + emriProjektit
             + " | Buxheti: " + buxhetiTotal + " EUR"
             + " | Anetaret: " + anetaret;
    }
}
