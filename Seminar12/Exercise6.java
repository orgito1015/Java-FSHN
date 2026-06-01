import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise6 {

    private static final Map<String, Book> LIBRARY = new HashMap<>();

    public static void main(String[] args) {
        seedData();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Shto liber");
                System.out.println("2. Kerko liber");
                System.out.println("0. Dil");
                System.out.print("Zgjedhja: ");

                String choice = scanner.nextLine().trim();
                if ("0".equals(choice)) {
                    break;
                }
                if ("1".equals(choice)) {
                    addBook(scanner);
                } else if ("2".equals(choice)) {
                    searchBook(scanner);
                } else {
                    System.out.println("Zgjedhje e pavlefshme.");
                }
            }
        }
    }

    private static void seedData() {
        LIBRARY.put("9780134685991", new Book("9780134685991", "Effective Java", "Joshua Bloch"));
        LIBRARY.put("9780132350884", new Book("9780132350884", "Clean Code", "Robert C. Martin"));
    }

    private static void addBook(Scanner scanner) {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine().trim();
        System.out.print("Titulli: ");
        String title = scanner.nextLine().trim();
        System.out.print("Autori: ");
        String author = scanner.nextLine().trim();
        LIBRARY.put(isbn, new Book(isbn, title, author));
        System.out.println("Libri u shtua.");
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("ISBN per kerkim: ");
        String isbn = scanner.nextLine().trim();
        Book book = LIBRARY.get(isbn);
        if (book == null) {
            System.out.println("Libri nuk u gjet.");
            return;
        }
        System.out.println(book);
    }

    private static final class Book {
        private final String isbn;
        private final String title;
        private final String author;

        private Book(String isbn, String title, String author) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{isbn='" + isbn + "', title='" + title + "', author='" + author + "'}";
        }
    }
}

