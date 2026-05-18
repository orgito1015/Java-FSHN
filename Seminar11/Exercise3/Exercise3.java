import java.util.Scanner;

class Student implements Comparable<Student> {
    private final String emri;

    public Student(String emri) {
        this.emri = emri;
    }

    public String getEmri() {
        return emri;
    }

    @Override
    public int compareTo(Student other) {
        return this.emri.compareToIgnoreCase(other.emri);
    }

    @Override
    public String toString() {
        return emri;
    }
}

public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] studentet = new Student[5];

        for (int i = 0; i < studentet.length; i++) {
            System.out.print("Vendos emrin e studentit " + (i + 1) + ": ");
            String emri = scanner.nextLine().trim();
            studentet[i] = new Student(emri);
        }

        Student iPari = studentet[0];
        Student iFundi = studentet[0];

        for (int i = 1; i < studentet.length; i++) {
            if (studentet[i].compareTo(iPari) < 0) {
                iPari = studentet[i];
            }
            if (studentet[i].compareTo(iFundi) > 0) {
                iFundi = studentet[i];
            }
        }

        System.out.println("\nStudenti i parë alfabetikisht: " + iPari.getEmri());
        System.out.println("Studenti i fundit alfabetikisht: " + iFundi.getEmri());

        scanner.close();
    }
}
