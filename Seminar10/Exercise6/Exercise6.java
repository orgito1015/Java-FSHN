public class Exercise6 {

    public static String decimalNeBinar(int n) {
        if (n < 0) {
            return "-" + decimalNeBinar(-n);
        }
        if (n == 0) return "0";
        return decimalNeBinarPozitiv(n);
    }

    private static String decimalNeBinarPozitiv(int n) {
        if (n == 0) return "";
        return decimalNeBinarPozitiv(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        int n = 25;
        System.out.println("Decimal: " + n);
        System.out.println("Binar (rekursive): " + decimalNeBinar(n));
    }
}
