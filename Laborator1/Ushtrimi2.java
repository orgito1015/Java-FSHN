/**
 * Ushtrimi 2 — Weather Category (Kategoria e Motit)
 *
 * Detyrë: Shkruaj një metodë statike kategoriaEMotit(char kodi) që merr
 * kodin e motit si karakter dhe kthen përshkrimin përkatës:
 *   'S' → "Diell" (Sunny)
 *   'R' → "Shi"   (Rain)
 *   'C' → "Vranësira" (Cloudy)
 *   'W' → "Erë"  (Wind)
 *   'N' → "Borë" (Snow)
 *   çdo karakter tjetër → "Kod i panjohur" (Unknown code)
 *
 * Bonus: Metoda funksionon edhe me shkronja të vogla.
 *
 * Shpjegim:
 * - Character.toUpperCase(kodi) konverton shkronjën e vogël në të madhe,
 *   kështu që 's' trajtohet njësoj si 'S'.
 * - Struktura switch/case kontrollon vlerën e kodit dhe kthen vargun
 *   përkatës të motit.
 * - Rasti default kap çdo kod tjetër të panjohur.
 */
public class Ushtrimi2 {

    /**
     * Kthen kategorine e motit bazuar ne kodin e dhene.
     *
     * @param kodi karakteri qe perfaqeson kodin e motit
     * @return pershkrimi i kategorise se motit
     */
    public static String kategoriaEMotit(char kodi) {
        switch (Character.toUpperCase(kodi)) {
            case 'S': return "Diell";
            case 'R': return "Shi";
            case 'C': return "Vranësira";
            case 'W': return "Erë";
            case 'N': return "Borë";
            default:  return "Kod i panjohur";
        }
    }

    public static void main(String[] args) {
        // Teste me shkronja te medha
        System.out.println(kategoriaEMotit('S')); // Diell
        System.out.println(kategoriaEMotit('R')); // Shi
        System.out.println(kategoriaEMotit('C')); // Vranësira
        System.out.println(kategoriaEMotit('W')); // Erë
        System.out.println(kategoriaEMotit('N')); // Borë
        System.out.println(kategoriaEMotit('X')); // Kod i panjohur

        // Bonus: teste me shkronja te vogla
        System.out.println(kategoriaEMotit('s')); // Diell
        System.out.println(kategoriaEMotit('r')); // Shi
        System.out.println(kategoriaEMotit('n')); // Borë
    }
}
