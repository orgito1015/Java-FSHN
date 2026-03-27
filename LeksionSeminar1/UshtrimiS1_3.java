/**
 * Ushtrimi 3 — Faktorial i Numrit
 *
 * Detyrë:
 * - Shkruaj metodën statike faktorial(int n) që llogarit n! (faktorialin).
 * - n! = 1 × 2 × 3 × ... × n  (me konventën 0! = 1)
 * - Testo: 0!, 1!, 5!, 10!
 *
 * Shpjegim:
 * - Cikli for grumbullon prodhimin nga 2 deri te n.
 * - Nëse n < 0, kthen -1 si shenjë gabimi (faktorial nuk ekziston për negative).
 * - Rezultati ruhet si long sepse faktorialët rriten shpejt.
 */
public class UshtrimiS1_3 {

    /**
     * Llogarit faktorialin e n.
     *
     * @param n numri i plote jo-negativ
     * @return n! ose -1 nese n < 0
     */
    public static long faktorial(int n) {
        if (n < 0) {
            return -1; // faktorial nuk ekziston per negative
        }
        long rezultat = 1;
        for (int i = 2; i <= n; i++) {
            rezultat *= i;
        }
        return rezultat;
    }

    public static void main(String[] args) {
        System.out.println("0! = " + faktorial(0));  // 1
        System.out.println("1! = " + faktorial(1));  // 1
        System.out.println("5! = " + faktorial(5));  // 120
        System.out.println("10! = " + faktorial(10)); // 3628800
        System.out.println("-1! = " + faktorial(-1)); // -1 (gabim)
    }
}
