import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ushtrimi 2 – FigurëGjeometrike (Console)
 *
 * Programi:
 *   1. Kerkon nga perdoruesi numrin e figurave gjeometrike n.
 *   2. Per cdo figure, kerkon zgjedhjen (1=Rreth, 2=Drejtkendesh, 3=Trekendesh)
 *      dhe vlerat perkatese.
 *   3. Gjen figuren gjeometrike me perimetrin me te madh.
 *
 * Ekstra: Kontrollon ne rastin e trekendeshit nese vlerat jane brinje te
 *         nje trekendeshi te vlefshëm.
 *
 * Shënim: Perdoruesi mund te zgjedhe n-here te njejten figure gjeometrike.
 */
public class Exercise2Console {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Shkruaj numrin e figurave gjeometrike (n): ");
        int n = Integer.parseInt(sc.nextLine().trim());

        List<FiguraGjeometrike> figurat = new ArrayList<>();
        int i = 0;

        while (i < n) {
            System.out.println("\n--- Figura " + (i + 1) + " nga " + n + " ---");
            System.out.println("Zgjidhni llojen e figures:");
            System.out.println("  1 – Rreth");
            System.out.println("  2 – Drejtkendesh");
            System.out.println("  3 – Trekendesh");
            System.out.print("Zgjedhja: ");

            int lloji;
            try {
                lloji = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Vlere e pasakte, provo perseri.");
                continue;
            }

            double a = 0, b = 0, c = 0;
            try {
                switch (lloji) {
                    case 1:
                        System.out.print("Rrezja (r): ");
                        a = Double.parseDouble(sc.nextLine().trim());
                        break;
                    case 2:
                        System.out.print("Gjatesia (a): ");
                        a = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("Gjeresia (b): ");
                        b = Double.parseDouble(sc.nextLine().trim());
                        break;
                    case 3:
                        System.out.print("Brinja a: ");
                        a = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("Brinja b: ");
                        b = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("Brinja c: ");
                        c = Double.parseDouble(sc.nextLine().trim());
                        // Ekstra: kontroll validiteti
                        FiguraGjeometrike test = new FiguraGjeometrike(a, b, c, 3);
                        if (!test.eshteTriangulIVlefshëm()) {
                            System.out.println("Kujdes: " + a + ", " + b + ", " + c
                                + " NUK formojne nje trekendesh te vlefshëm!");
                            System.out.print("Deshironi te vendosni vlera te reja? (po/jo): ");
                            if (sc.nextLine().trim().equalsIgnoreCase("po")) {
                                continue;
                            }
                        }
                        break;
                    default:
                        System.out.println("Zgjedhje e pasakte (1-3), provo perseri.");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vlere numerike e pasakte, provo perseri.");
                continue;
            }

            figurat.add(new FiguraGjeometrike(a, b, c, lloji));
            i++;
        }

        System.out.println("\n=== Rezultatet ===");
        FiguraGjeometrike meMeILarte = figurat.get(0);
        for (FiguraGjeometrike fg : figurat) {
            System.out.println(fg);
            if (fg.llogaritPerimetrin() > meMeILarte.llogaritPerimetrin()) {
                meMeILarte = fg;
            }
        }

        System.out.println("\n>>> Figura me perimetrin me te madh: " + meMeILarte);
        sc.close();
    }
}
