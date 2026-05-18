public class Exercise1 {

    public static String stringAnasjellte(String text) {
        if (text == null) return null;
        if (text.length() <= 1) return text;
        return stringAnasjellte(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        String text = "JAVA";
        System.out.println("Teksti: " + text);
        System.out.println("Anasjelltë (rekursive): " + stringAnasjellte(text));
    }
}
