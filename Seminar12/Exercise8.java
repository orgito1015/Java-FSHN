import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;
import java.util.Queue;

public class Exercise8 {

    public static void main(String[] args) {
        test("level");
        test("java");
        test("A man, a plan, a canal: Panama");
    }

    private static void test(String text) {
        System.out.println(text);
        System.out.println("Stack: " + isPalindromeWithStack(text));
        System.out.println("Queue: " + isPalindromeWithQueue(text));
    }

    private static boolean isPalindromeWithStack(String text) {
        String normalized = normalize(text);
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeWithQueue(String text) {
        String normalized = normalize(text);
        Queue<Character> queue = new ArrayDeque<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            queue.offer(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    private static String normalize(String text) {
        return text.replaceAll("[^\\p{L}\\p{Nd}]", "").toLowerCase(Locale.ROOT);
    }
}

