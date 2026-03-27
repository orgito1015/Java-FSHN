/**
 * Ushtrimi 3 — Count Digits Below Four (Numëro Shifrat Nën Katër)
 *
 * Detyrë: Shkruaj një metodë numeroShifratNenKater(int n) që kthen numrin e
 * shifrave në n që janë më të vogla se 4 (d.m.th. 0, 1, 2 ose 3).
 *
 * Shembull: n = 15270 → rezultati është 3 (shifrat 1, 2 dhe 0 janë < 4).
 *
 * Shpjegim i algoritmit:
 * - Veprojmë me vlerën absolute të n (Math.abs) për të trajtuar numrat negativë.
 * - Nëse n = 0, testi direkt: 0 < 4, kthejmë 1.
 * - Me ciklin while izolojmë shifrat njëra pas tjetrës duke ndarë me 10 (n % 10
 *   jep shifrën e fundit, pastaj n /= 10 e heq atë).
 * - Numërojmë ato shifra që janë < 4.
 */
public class Ushtrimi3 {

    /**
     * Kthen numrin e shifrave ne n qe jane me te vogla se 4.
     *
     * @param n numri i plote (mund te jete negativ)
     * @return numri i shifrave 0, 1, 2, ose 3 qe gjenden ne n
     */
    public static int numeroShifratNenKater(int n) {
        n = Math.abs(n);

        // Rast special: 0 eshte nje shifte dhe eshte < 4
        if (n == 0) {
            return 1;
        }

        int count = 0;
        while (n > 0) {
            int shifra = n % 10;   // merr shifrën e fundit
            if (shifra < 4) {
                count++;
            }
            n /= 10;               // largo shifrën e fundit
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numeroShifratNenKater(15270));  // 3  (1, 2, 0)
        System.out.println(numeroShifratNenKater(9999));   // 0  (asnjë shifër < 4)
        System.out.println(numeroShifratNenKater(1230));   // 4  (1, 2, 3, 0)
        System.out.println(numeroShifratNenKater(0));      // 1  (0 < 4)
        System.out.println(numeroShifratNenKater(-1320));  // 4  (1, 3, 2, 0 — te katra < 4)
        System.out.println(numeroShifratNenKater(5678));   // 0
    }
}
