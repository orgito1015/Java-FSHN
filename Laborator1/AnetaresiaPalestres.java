import java.util.ArrayList;

/**
 * AnetaresiaPalestres — Klasa e Anëtarësisë së Palestres
 *
 * Shpjegim:
 * - Kjo klasë modelon anëtarësinë e një klienti në palestër.
 * - Atributet: emri i klientit (String), viti i regjistrimit (int),
 *   listë ushtrimesh të planifikuara (ArrayList<String>).
 * - isAnetarBesnik() kthen true nëse klienti është i regjistruar prej të
 *   paktën 3 vitesh (viti referencë: 2026).
 * - shtoUshtrim() shton një ushtrim të ri në listë.
 */
public class AnetaresiaPalestres {

    private String emriKlientit;
    private int vitiRegjistrimit;
    private ArrayList<String> ushtrimet;

    private static final int VITI_REFERUES = 2026;

    /** Konstruktori me parametra */
    public AnetaresiaPalestres(String emriKlientit, int vitiRegjistrimit) {
        this.emriKlientit = emriKlientit;
        this.vitiRegjistrimit = vitiRegjistrimit;
        this.ushtrimet = new ArrayList<>();
    }

    /** Konstruktori pa parametra (no-arg) */
    public AnetaresiaPalestres() {
        this.emriKlientit = "";
        this.vitiRegjistrimit = VITI_REFERUES;
        this.ushtrimet = new ArrayList<>();
    }

    // ---- Getters ----

    public String getEmriKlientit() {
        return emriKlientit;
    }

    public int getVitiRegjistrimit() {
        return vitiRegjistrimit;
    }

    public ArrayList<String> getUshtrimet() {
        return ushtrimet;
    }

    // ---- Setters ----

    public void setEmriKlientit(String emriKlientit) {
        this.emriKlientit = emriKlientit;
    }

    public void setVitiRegjistrimit(int vitiRegjistrimit) {
        this.vitiRegjistrimit = vitiRegjistrimit;
    }

    public void setUshtrimet(ArrayList<String> ushtrimet) {
        this.ushtrimet = ushtrimet;
    }

    // ---- Metoda shtese ----

    /**
     * Shton nje ushtrim te ri ne listen e ushtrimeve te planifikuara.
     *
     * @param ushtrim emri i ushtimit qe shtohet
     */
    public void shtoUshtrim(String ushtrim) {
        ushtrimet.add(ushtrim);
    }

    /**
     * Kontrollon nese klienti eshte anetar besnik (te paktën 3 vjet).
     *
     * @return true nese (VITI_REFERUES - vitiRegjistrimit) >= 3
     */
    public boolean isAnetarBesnik() {
        return (VITI_REFERUES - vitiRegjistrimit) >= 3;
    }

    @Override
    public String toString() {
        return "Klienti: " + emriKlientit
             + " | Viti regjistrimit: " + vitiRegjistrimit
             + " | Ushtrimet: " + ushtrimet;
    }
}
