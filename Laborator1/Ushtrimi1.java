/**
 * Ushtrimi 1 — Email Dot Check (Kontrolli i pikës në email)
 *
 * Detyrë: Shkruaj një metodë statike perfshinPiken(String email) që merr një
 * adresë emaili si parametër dhe kthen true nëse ajo përmban një pikë ('.'),
 * përndryshe false.
 *
 * Shpjegim:
 * - Metoda perdor String.contains(".") per te kontrolluar nese vargu permban piken.
 * - String.contains() kthen true/false, keshtu metoda thjesht e kthen ate vlere.
 * - Testohet me disa shembuj ne main: email me pike, email pa pike, dhe null/bosh.
 */
public class Ushtrimi1 {

    /**
     * Kontrollon nese emaili permban pike ('.').
     *
     * @param email adresa e emailit qe do kontrollohet
     * @return true nese email permban '.', false ne rast tjeter
     */
    public static boolean perfshinPiken(String email) {
        if (email == null) {
            return false;
        }
        return email.contains(".");
    }

    public static void main(String[] args) {
        // Shembuj testimi
        System.out.println(perfshinPiken("student@fshn.edu.al")); // true  — ka pike
        System.out.println(perfshinPiken("studentfshnedu"));       // false — nuk ka pike
        System.out.println(perfshinPiken("a.b@c.com"));            // true  — ka pike
        System.out.println(perfshinPiken(""));                     // false — bosh
        System.out.println(perfshinPiken(null));                   // false — null
    }
}
