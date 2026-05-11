import java.time.LocalDate;

/**
 * Relacioni Punonjes-Adresa eshte agregim (has-a).
 */
public class Punonjes {
    private String emriPunonjesit;
    private int idPunonjesi;
    private LocalDate dataPunesimit;
    private String departamenti;
    private double paga;
    private Adresa adresa;

    public Punonjes(String emriPunonjesit, int idPunonjesi, LocalDate dataPunesimit,
                    String departamenti, double paga, Adresa adresa) {
        this.emriPunonjesit = emriPunonjesit;
        this.idPunonjesi = idPunonjesi;
        this.dataPunesimit = dataPunesimit;
        this.departamenti = departamenti;
        this.paga = paga;
        this.adresa = adresa;
    }

    public String getEmriPunonjesit() {
        return emriPunonjesit;
    }

    public void setEmriPunonjesit(String emriPunonjesit) {
        this.emriPunonjesit = emriPunonjesit;
    }

    public int getIdPunonjesi() {
        return idPunonjesi;
    }

    public void setIdPunonjesi(int idPunonjesi) {
        this.idPunonjesi = idPunonjesi;
    }

    public LocalDate getDataPunesimit() {
        return dataPunesimit;
    }

    public void setDataPunesimit(LocalDate dataPunesimit) {
        this.dataPunesimit = dataPunesimit;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    public void setDepartamenti(String departamenti) {
        this.departamenti = departamenti;
    }

    public double getPaga() {
        return paga;
    }

    public void setPaga(double paga) {
        this.paga = paga;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Punonjes{" +
                "emri='" + emriPunonjesit + '\'' +
                ", id=" + idPunonjesi +
                ", dataPunesimit=" + dataPunesimit +
                ", departamenti='" + departamenti + '\'' +
                ", paga=" + paga +
                ", adresa=" + adresa +
                '}';
    }
}
