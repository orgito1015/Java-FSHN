public class Exercise3 {

    public static boolean permbanStringRekursive(String tekst, String target) {
        if (tekst == null || target == null) return false;
        if (target.isEmpty()) return true;
        if (tekst.length() < target.length()) return false;
        if (tekst.startsWith(target)) return true;
        return permbanStringRekursive(tekst.substring(1), target);
    }

    public static void main(String[] args) {
        String tekst = "PROGRAMIM NE JAVA";
        String target = "JAVA";

        System.out.println("Teksti: " + tekst);
        System.out.println("Target: " + target);
        System.out.println("Përmban target? " + permbanStringRekursive(tekst, target));
    }
}
