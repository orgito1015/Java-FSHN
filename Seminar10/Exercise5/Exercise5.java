public class Exercise5 {

    public static int pmp(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) return a;
        return pmp(b, a % b);
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        System.out.println("Numri 1: " + a);
        System.out.println("Numri 2: " + b);
        System.out.println("PMP: " + pmp(a, b));
    }
}
