public class Exercise2 {

    public static String stringAnasjellteIterative(String text) {
        if (text == null) return null;
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = text.length() - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String text = "JAVA";
        System.out.println("Teksti: " + text);
        System.out.println("Anasjelltë (iterative): " + stringAnasjellteIterative(text));
    }
}
