/**
 * Klasa Libri – ruan informacionin e nje libri.
 *
 * Variablat instance:
 *   autori    – autori i librit
 *   titulli   – titulli i librit
 *   isbn      – kodi unik ISBN
 *   numFaqeve – numri i faqeve
 *   lloji     – lloji i librit (p.sh. Fantazi, Distopi, Shkencë, etj.)
 *   cmimi     – çmimi i librit në EUR
 */
public class Libri {

    private String autori;
    private String titulli;
    private String isbn;
    private int    numFaqeve;
    private String lloji;
    private double cmimi;

    public Libri(String autori, String titulli, String isbn, int numFaqeve, String lloji, double cmimi) {
        this.autori    = autori;
        this.titulli   = titulli;
        this.isbn      = isbn;
        this.numFaqeve = numFaqeve;
        this.lloji     = lloji;
        this.cmimi     = cmimi;
    }

    // ---- Getters ----
    public String getAutori()    { return autori; }
    public String getTitulli()   { return titulli; }
    public String getIsbn()      { return isbn; }
    public int    getNumFaqeve() { return numFaqeve; }
    public String getLloji()     { return lloji; }
    public double getCmimi()     { return cmimi; }

    // ---- Setters ----
    public void setAutori(String autori)       { this.autori    = autori; }
    public void setTitulli(String titulli)     { this.titulli   = titulli; }
    public void setIsbn(String isbn)           { this.isbn      = isbn; }
    public void setNumFaqeve(int numFaqeve)    { this.numFaqeve = numFaqeve; }
    public void setLloji(String lloji)         { this.lloji     = lloji; }
    public void setCmimi(double cmimi)         { this.cmimi     = cmimi; }

    @Override
    public String toString() {
        return String.format(
            "Autori: %-25s | Titulli: %-25s | ISBN: %-15s | Faqe: %4d | Lloji: %-12s | Cmimi: %.2f EUR",
            autori, titulli, isbn, numFaqeve, lloji, cmimi);
    }
}
