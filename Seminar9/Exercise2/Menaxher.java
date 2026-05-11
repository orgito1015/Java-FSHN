public class Menaxher extends Punonjes {
    private int numriEkipit;

    public Menaxher(String emri, String mbiemri, int idPunonjesi, String departamenti, int numriEkipit) {
        super(emri, mbiemri, idPunonjesi, departamenti);
        this.numriEkipit = numriEkipit;
    }

    public int getNumriEkipit() {
        return numriEkipit;
    }

    @Override
    public String toString() {
        return "Menaxher{" +
                "teDhenat=" + super.toString() +
                ", numriEkipit=" + numriEkipit +
                '}';
    }
}
