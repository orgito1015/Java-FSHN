import java.util.LinkedList;
import java.util.ListIterator;

public class Exercise4 {

    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Tirana");
        cities.add("Durres");
        cities.add("Vlora");
        cities.add("Shkodra");
        cities.add("Elbasan");

        LinkedList<String> afterThird = new LinkedList<>(cities);
        insertAfterThird(afterThird, "Berat");

        LinkedList<String> sameLength = new LinkedList<>(cities);
        insertAfterFirstSameLength(sameLength, "Berat");

        System.out.println("Origjinali: " + cities);
        System.out.println("Pas elementit te trete: " + afterThird);
        System.out.println("Pas elementit te pare me gjatesi te njejte: " + sameLength);
    }

    private static void insertAfterThird(LinkedList<String> cities, String newCity) {
        ListIterator<String> iterator = cities.listIterator();
        int index = 0;
        while (iterator.hasNext() && index < 3) {
            iterator.next();
            index++;
        }
        iterator.add(newCity);
    }

    private static void insertAfterFirstSameLength(LinkedList<String> cities, String newCity) {
        int targetLength = newCity.length();
        ListIterator<String> iterator = cities.listIterator();
        while (iterator.hasNext()) {
            String city = iterator.next();
            if (city.length() == targetLength) {
                iterator.add(newCity);
                return;
            }
        }
        cities.addLast(newCity);
    }
}

