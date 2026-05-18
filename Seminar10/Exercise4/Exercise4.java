import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise4 {

    public static Set<String> anagramat(String str) {
        Set<String> rezultat = new LinkedHashSet<>();
        if (str == null) return rezultat;
        gjeneroAnagrama("", str, rezultat);
        return rezultat;
    }

    private static void gjeneroAnagrama(String prefix, String mbetur, Set<String> rezultat) {
        if (mbetur.isEmpty()) {
            rezultat.add(prefix);
            return;
        }

        for (int i = 0; i < mbetur.length(); i++) {
            char c = mbetur.charAt(i);
            String pjesaMajte = mbetur.substring(0, i);
            String pjesaDjathtas = mbetur.substring(i + 1);
            gjeneroAnagrama(prefix + c, pjesaMajte + pjesaDjathtas, rezultat);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        Set<String> rez = anagramat(str);

        System.out.println("Stringu: " + str);
        System.out.println("Anagramat:");
        for (String s : rez) {
            System.out.println(s);
        }
        System.out.println("Totali: " + rez.size());
    }
}
