import java.util.ArrayList;

class Pedagogu {
    private final String emri;
    private final String titulli;

    public Pedagogu(String emri, String titulli) {
        this.emri = emri;
        this.titulli = titulli;
    }

    @Override
    public String toString() {
        return titulli + " " + emri;
    }
}

class Departamenti {
    private final String emriDepartamentit;
    private final ArrayList<Pedagogu> pedagoget;

    public Departamenti(String emriDepartamentit) {
        this.emriDepartamentit = emriDepartamentit;
        this.pedagoget = new ArrayList<>();
    }

    public void shtoPedagog(Pedagogu pedagogu) {
        pedagoget.add(pedagogu);
    }

    public void shfaqListen() {
        System.out.println("Departamenti: " + emriDepartamentit);
        for (Pedagogu pedagogu : pedagoget) {
            System.out.println(" - " + pedagogu);
        }
    }
}

public class AgregimiTest {

    public static void main(String[] args) {
        Pedagogu p1 = new Pedagogu("Artan Hoxha", "Prof. Dr.");
        Pedagogu p2 = new Pedagogu("Ilda Metaj", "Dr.");
        Pedagogu p3 = new Pedagogu("Gent Beqiri", "MSc.");

        Departamenti dept = new Departamenti("Informatike");
        dept.shtoPedagog(p1);
        dept.shtoPedagog(p2);
        dept.shtoPedagog(p3);

        dept.shfaqListen();

        System.out.println();
        System.out.println("Fshijme departamentin...");
        dept = null;

        System.out.println("Pedagoget ekzistojne ende:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
