/**
 * Klasa FiguraGjeometrike – me 3 variabla instance double (a, b, c).
 *
 * Llojet e figurave:
 *   1 – Rreth        (perdoret vetem a = rrezja;  b dhe c jane 0)
 *   2 – Drejtkendesh (perdoret a = gjatesia, b = gjeresia; c = 0)
 *   3 – Trekendesh   (a, b, c jane tre brinjete)
 *
 * Metoda llogaritPerimetrin() llogarit perimetrin sipas llojit.
 * Ekstra: eshteTriangulIVlefshëm() kontrollon ne rastin e trekendeshit
 *         nese vlerat mund te jene brinje te nje trekendeshi.
 */
public class FiguraGjeometrike {

    private double a;
    private double b;
    private double c;
    private int    lloji; // 1=rreth, 2=drejtkendesh, 3=trekendesh

    public FiguraGjeometrike(double a, double b, double c, int lloji) {
        this.a     = a;
        this.b     = b;
        this.c     = c;
        this.lloji = lloji;
    }

    /**
     * Llogarit perimetrin sipas llojit te figures:
     *   Rreth:        P = 2 * PI * r         (a = rrezja)
     *   Drejtkendesh: P = 2 * (a + b)
     *   Trekendesh:   P = a + b + c
     */
    public double llogaritPerimetrin() {
        switch (lloji) {
            case 1: return 2 * Math.PI * a;
            case 2: return 2 * (a + b);
            case 3: return a + b + c;
            default: throw new IllegalStateException("Lloj i panjohur figure: " + lloji);
        }
    }

    /**
     * Ekstra – kontrollon nese vlerat a, b, c formojne nje trekendesh te vlefshëm.
     * Nje trekendesh eshte i vlefshëm kur shuma e cdo dy brinjeve eshte me e madhe
     * se brinja e trete.
     */
    public boolean eshteTriangulIVlefshëm() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public double getA()     { return a; }
    public double getB()     { return b; }
    public double getC()     { return c; }
    public int    getLloji() { return lloji; }

    public String emriFigures() {
        switch (lloji) {
            case 1: return "Rreth";
            case 2: return "Drejtkendesh";
            case 3: return "Trekendesh";
            default: return "I panjohur";
        }
    }

    @Override
    public String toString() {
        String params;
        switch (lloji) {
            case 1: params = String.format("r=%.2f", a); break;
            case 2: params = String.format("a=%.2f, b=%.2f", a, b); break;
            case 3: params = String.format("a=%.2f, b=%.2f, c=%.2f", a, b, c); break;
            default: params = "";
        }
        return String.format("%s(%s) => Perimetri: %.4f", emriFigures(), params, llogaritPerimetrin());
    }
}
