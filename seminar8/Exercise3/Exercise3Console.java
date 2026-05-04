import java.util.Scanner;

/**
 * Ushtrimi 3 – Prona dhe Klientet (Console)
 *
 * Demonstron perdorimin e klasave Klient dhe Prona.
 *
 * Programi:
 *   1. Krijon nje prone (emri jepet nga perdoruesi).
 *   2. Lejon shtimin e klienteve te interesuar (emri + oferta).
 *   3. Shfaq numrin total te klienteve dhe oferten maksimale.
 */
public class Exercise3Console {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Emri i prona-s: ");
        String emriPrones = sc.nextLine().trim();
        Prona prona = new Prona(emriPrones);

        String vazhdo = "po";
        do {
            System.out.println("\n--- Shto nje klient te ri ---");
            System.out.print("  Emri i klientit: ");
            String emri = sc.nextLine().trim();
            System.out.print("  Oferta (EUR):    ");
            double oferta;
            try {
                oferta = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Oferta duhet te jete nje numer. Provo perseri.");
                continue;
            }

            prona.shtoKlient(new Klient(emri, oferta));
            System.out.println("Klienti u shtua. Numri total i klienteve: " + prona.numëroKlientë());

            System.out.print("Deshironi te shtoni nje klient tjeter? (po/jo): ");
            vazhdo = sc.nextLine().trim().toLowerCase();
        } while (vazhdo.equals("po"));

        System.out.println("\n=== Informacioni i Prona-s ===");
        System.out.println("Emri i prona-s: " + prona.getEmri());
        System.out.println("Numri i klienteve te interesuar: " + prona.numëroKlientë());

        System.out.println("\nLista e klienteve:");
        for (Klient k : prona.getKlientet()) {
            System.out.println("  " + k);
        }

        Klient maks = prona.ofertaMaks();
        if (maks != null) {
            System.out.println("\nOferta maksimale: " + maks);
        }

        sc.close();
    }
}
