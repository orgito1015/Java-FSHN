import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise9 {

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private static final class QueueUsingStacks<E> {
        private final Deque<E> input = new ArrayDeque<>();
        private final Deque<E> output = new ArrayDeque<>();

        void enqueue(E value) {
            input.push(value);
        }

        E dequeue() {
            moveIfNeeded();
            return output.pop();
        }

        E peek() {
            moveIfNeeded();
            return output.peek();
        }

        private void moveIfNeeded() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
    }
}

