import java.util.LinkedList;
import java.util.List;

public class Exercise2 {

    public static void main(String[] args) {
        LinkedList<String> shortList = new LinkedList<>(List.of("Ana", "Bora", "Celo"));
        LinkedList<String> longList = new LinkedList<>(List.of("Ana", "Bora", "Celo", "Dori"));

        removeIfThreeOrLess(shortList);
        removeIfThreeOrLess(longList);

        System.out.println("Lista me 3 elemente pas fshirjes: " + shortList);
        System.out.println("Lista me 4 elemente pas fshirjes: " + longList);
    }

    private static <T> void removeIfThreeOrLess(LinkedList<T> list) {
        boolean removeAll = list.size() <= 3;
        list.removeIf(item -> removeAll);
    }
}

