/**
 * Ushtrimi 5 — Test class for AnetaresiaPalestres
 *
 * Shpjegim:
 * - Krijon dy objekte AnetaresiaPalestres.
 * - Shton ushtrime me shtoUshtrim().
 * - Printon informacionin.
 * - Teston isAnetarBesnik() me vite regjistrimi te ndryshme.
 */
public class Ushtrimi5 {

    public static void main(String[] args) {
        // Klient i regjistruar qe prej 2020 — anëtar besnik (2026-2020=6 >= 3)
        AnetaresiaPalestres a1 = new AnetaresiaPalestres("Genti Mara", 2020);
        a1.shtoUshtrim("Vrapim");
        a1.shtoUshtrim("Ngritje pesash");
        a1.shtoUshtrim("Yoga");

        System.out.println(a1);
        System.out.println("Anetar besnik? " + a1.isAnetarBesnik()); // true

        System.out.println();

        // Klient i regjistruar qe prej 2025 — jo anëtar besnik (2026-2025=1 < 3)
        AnetaresiaPalestres a2 = new AnetaresiaPalestres("Hera Leka", 2025);
        a2.shtoUshtrim("Pilates");

        System.out.println(a2);
        System.out.println("Anetar besnik? " + a2.isAnetarBesnik()); // false

        System.out.println();

        // Objekt me konstruktor pa parametra, vendosje me setters
        AnetaresiaPalestres a3 = new AnetaresiaPalestres();
        a3.setEmriKlientit("Iris Duro");
        a3.setVitiRegjistrimit(2023);
        a3.shtoUshtrim("Not");
        a3.shtoUshtrim("Cikël");

        System.out.println(a3);
        System.out.println("Anetar besnik? " + a3.isAnetarBesnik()); // true (2026-2023=3 >= 3)
    }
}
