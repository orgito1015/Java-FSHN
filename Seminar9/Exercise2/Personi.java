public class Personi {
    private String emri;
    private String mbiemri;

    public Personi(String emri, String mbiemri) {
        this.emri = emri;
        this.mbiemri = mbiemri;
    }

    public String getEmri() {
        return emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    @Override
    public String toString() {
        return emri + " " + mbiemri;
    }
}
