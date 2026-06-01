import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise11 {

    public static void main(String[] args) {
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            stack1.push(c);
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop());
            if (!stack2.isEmpty()) {
                System.out.print(' ');
            }
        }
        System.out.println();
    }
}
