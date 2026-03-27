/**
 * Ushtrimi 4 — Test class for MenaxhimProjekti
 *
 * Shpjegim:
 * - Krijon dy objekte MenaxhimProjekti (njëri me parametra, tjetri pa).
 * - Shton anëtarë të ekipit me shtoAnetar().
 * - Printon informacionin e projektit.
 * - Teston isProjektIMadh() me dy buxhete të ndryshme.
 */
public class Ushtrimi4 {

    public static void main(String[] args) {
        // Objekt me konstruktor me parametra
        MenaxhimProjekti p1 = new MenaxhimProjekti("Sistemi i Bibliotekës", 75000.0);
        p1.shtoAnetar("Ana Koci");
        p1.shtoAnetar("Besnik Hoxha");
        p1.shtoAnetar("Klara Deda");

        System.out.println(p1);
        System.out.println("Projekt i madh? " + p1.isProjektIMadh()); // true

        System.out.println();

        // Objekt me konstruktor pa parametra dhe vendosje me setters
        MenaxhimProjekti p2 = new MenaxhimProjekti();
        p2.setEmriProjektit("Faqja Web e Shkollës");
        p2.setBuxhetiTotal(20000.0);
        p2.shtoAnetar("Eris Basha");
        p2.shtoAnetar("Flori Çela");

        System.out.println(p2);
        System.out.println("Projekt i madh? " + p2.isProjektIMadh()); // false
    }
}
