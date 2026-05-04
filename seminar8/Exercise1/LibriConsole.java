import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ushtrimi 1 – Menaxhimi i Librave (Console / LibriTest)
 *
 * Menu:
 *   Shtyp 1 per te shfaqur te gjithe librat qe ndodhen ne liste
 *   Shtyp 2 per te kerkuar nje liber ne liste
 *   Shtyp 3 per te shtuar nje liber ne liste
 *   Shtyp 4 per te hequr nje liber nga lista
 *   Shtyp 0 per te dale nga programi
 */
public class LibriConsole {

    private static final List<Libri> lista = new ArrayList<>();

    public static void main(String[] args) {
        // Disa libra fillestar ne liste
        lista.add(new Libri("J.K. Rowling",           "Harry Potter",    "978-0439708180", 309, "Fantazi",  15.99));
        lista.add(new Libri("George Orwell",           "1984",            "978-0451524935", 328, "Distopi",  12.99));
        lista.add(new Libri("Antoine de Saint-Exupery","Princi i Vogel",  "978-0156012195",  96, "Fabel",    9.99));

        Scanner sc = new Scanner(System.in);
        int zgjedhja;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("Shtyp 1 per te shfaqur te gjithe librat qe ndodhen ne liste");
            System.out.println("Shtyp 2 per te kerkuar nje liber ne liste");
            System.out.println("Shtyp 3 per te shtuar nje liber ne liste");
            System.out.println("Shtyp 4 per te hequr nje liber nga lista");
            System.out.println("Shtyp 0 per te dale nga programi");
            System.out.print("Zgjedhja juaj: ");

            try {
                zgjedhja = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ju lutem vendosni nje numer te vlefshëm.");
                zgjedhja = -1;
                continue;
            }

            switch (zgjedhja) {
                case 1:
                    shfaqLibrat();
                    break;
                case 2:
                    kerkoLibrin(sc);
                    break;
                case 3:
                    shtoLibrin(sc);
                    break;
                case 4:
                    hiqLibrin(sc);
                    break;
                case 0:
                    System.out.println("Mirupafshim!");
                    break;
                default:
                    System.out.println("Zgjedhje e pasakte! Provo perseri.");
            }
        } while (zgjedhja != 0);

        sc.close();
    }

    private static void shfaqLibrat() {
        if (lista.isEmpty()) {
            System.out.println("Lista eshte bosh.");
            return;
        }
        System.out.println("\n--- Lista e Librave (" + lista.size() + " libra) ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }

    private static void kerkoLibrin(Scanner sc) {
        System.out.print("Shkruaj titullin e librit: ");
        String titulli = sc.nextLine().trim();
        boolean gjetur = false;
        for (Libri l : lista) {
            if (l.getTitulli().equalsIgnoreCase(titulli)) {
                System.out.println("Gjetur: " + l);
                gjetur = true;
            }
        }
        if (!gjetur) {
            System.out.println("Libri me titull '" + titulli + "' nuk u gjet.");
        }
    }

    private static void shtoLibrin(Scanner sc) {
        System.out.print("Autori: ");
        String autori = sc.nextLine().trim();
        System.out.print("Titulli: ");
        String titulli = sc.nextLine().trim();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine().trim();
        System.out.print("Numri i faqeve: ");
        int numFaqeve = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Lloji: ");
        String lloji = sc.nextLine().trim();
        System.out.print("Cmimi (EUR): ");
        double cmimi = Double.parseDouble(sc.nextLine().trim());

        lista.add(new Libri(autori, titulli, isbn, numFaqeve, lloji, cmimi));
        System.out.println("Libri u shtua me sukses!");
    }

    private static void hiqLibrin(Scanner sc) {
        if (lista.isEmpty()) {
            System.out.println("Lista eshte bosh, nuk ka asnje liber per te hequr.");
            return;
        }
        shfaqLibrat();
        System.out.print("Shkruaj titullin e librit per ta hequr: ");
        String titulli = sc.nextLine().trim();
        boolean hequr = lista.removeIf(l -> l.getTitulli().equalsIgnoreCase(titulli));
        System.out.println(hequr ? "Libri u hoq me sukses!"
                                 : "Libri me titull '" + titulli + "' nuk u gjet.");
    }
}
