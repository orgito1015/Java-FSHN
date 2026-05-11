public class Punonjes extends Personi {
    private int idPunonjesi;
    private String departamenti;

    public Punonjes(String emri, String mbiemri, int idPunonjesi, String departamenti) {
        super(emri, mbiemri);
        this.idPunonjesi = idPunonjesi;
        this.departamenti = departamenti;
    }

    public int getIdPunonjesi() {
        return idPunonjesi;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    @Override
    public String toString() {
        return "Punonjes{" +
                "personi='" + super.toString() + '\'' +
                ", idPunonjesi=" + idPunonjesi +
                ", departamenti='" + departamenti + '\'' +
                '}';
    }
}
