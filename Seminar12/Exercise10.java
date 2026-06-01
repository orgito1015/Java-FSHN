import java.util.ArrayDeque;
import java.util.Queue;

public class Exercise10 {

    public static void main(String[] args) {
        generateBinaryNumbers(10);
    }

    private static void generateBinaryNumbers(int n) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            System.out.println(current);
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }
}

