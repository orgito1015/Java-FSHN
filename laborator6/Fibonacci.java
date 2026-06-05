import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {

    public static int jepFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return jepFibonacci(n - 1) + jepFibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sa elemente te vargut Fibonacci deshironi? ");
        int n = scanner.nextInt();

        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(jepFibonacci(i));
        }

        System.out.println("Vargu Fibonacci: " + lista);

        System.out.print("Jepni nje numer per kerkim: ");
        int kerkimi = scanner.nextInt();

        if (lista.contains(kerkimi)) {
            System.out.println("Numri " + kerkimi + " ndodhet ne vargun Fibonacci.");
        } else {
            System.out.println("Numri " + kerkimi + " nuk ndodhet ne vargun Fibonacci.");
        }

        scanner.close();
    }
}
