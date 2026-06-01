import java.util.LinkedList;
import java.util.ListIterator;

public class Exercise1 {

    public static void main(String[] args) {
        solveA();
        solveB();
        solveC();
    }

    private static void solveA() {
        LinkedList<String> student = new LinkedList<>();
        student.addFirst("AA");
        student.addFirst("BB");
        student.addFirst("CC");

        System.out.println("1a");
        while (!student.isEmpty()) {
            System.out.println(student.removeFirst());
        }
    }

    private static void solveB() {
        LinkedList<String> student = new LinkedList<>();
        student.addFirst("AA");
        student.addLast("BB");
        student.addFirst("CC");

        System.out.println("1b");
        System.out.println(student.removeLast());
        System.out.println(student.removeFirst());
        System.out.println(student.removeLast());
    }

    private static void solveC() {
        LinkedList<String> student = new LinkedList<>();
        ListIterator<String> iterator = student.listIterator();
        iterator.add("AA");
        iterator.add("BB");
        iterator.add("CC");
        iterator = student.listIterator();
        iterator.next();
        iterator.next();
        iterator.add("DD");
        iterator.next();
        iterator.add("EE");
        iterator = student.listIterator();
        iterator.next();
        iterator.remove();

        System.out.println("1c");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

