import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise3 {

    private static final List<String> MONTHS = List.of(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");

    public static void main(String[] args) {
        printAlphabeticalDescending();
        printCalendarDescending();
    }

    private static void printAlphabeticalDescending() {
        List<String> months = new ArrayList<>(MONTHS);
        months.sort(Comparator.reverseOrder());
        System.out.println("Renditja alfabetike zbritese:");
        System.out.println(months);
    }

    private static void printCalendarDescending() {
        List<String> months = new ArrayList<>(MONTHS);
        java.util.Collections.reverse(months);
        System.out.println("Renditja sipas kalendarit zbritese:");
        System.out.println(months);
    }
}

