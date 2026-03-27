/**
 * Ushtrimi 2 — Kontrollimi nëse Numri është Çift apo Tek
 *
 * Detyrë:
 * - Shkruaj metodën statike isçift(int n) që kthen true nëse n është çift.
 * - Shkruaj metodën statike pershkruaj(int n) që kthen "çift" ose "tek".
 * - Testo me disa numra pozitivë, negativë dhe 0.
 *
 * Shpjegim:
 * - Operatori modulo (%) jep mbetjen e ndarjes. Nëse n % 2 == 0, numri është çift.
 * - Math.abs() siguron që funksionon edhe për numra negativë (megjithëse
 *   modulo funksionon saktë edhe pa të në Java).
 */
public class UshtrimiS1_2 {

    /**
     * Kthen true nese n eshte numer çift.
     */
    public static boolean isCift(int n) {
        return n % 2 == 0;
    }

    /**
     * Kthen vargun "çift" ose "tek" per numrin n.
     */
    public static String pershkruaj(int n) {
        return isCift(n) ? "çift" : "tek";
    }

    public static void main(String[] args) {
        int[] numrat = {0, 1, 4, 7, -2, -5, 100};
        for (int n : numrat) {
            System.out.println(n + " eshte " + pershkruaj(n));
        }
    }
}
