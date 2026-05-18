import java.util.Random;
import java.util.Scanner;

public class Exercise4 {

    static class Contact {
        String emri;
        String numriTelefonit;

        Contact(String emri, String numriTelefonit) {
            this.emri = emri;
            this.numriTelefonit = numriTelefonit;
        }

        @Override
        public String toString() {
            return emri + " -> " + numriTelefonit;
        }
    }

    public static void selectionSortSipasEmrit(Contact[] contacts) {
        for (int i = 0; i < contacts.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < contacts.length; j++) {
                if (contacts[j].emri.compareToIgnoreCase(contacts[minIndex].emri) < 0) {
                    minIndex = j;
                }
            }
            Contact temp = contacts[i];
            contacts[i] = contacts[minIndex];
            contacts[minIndex] = temp;
        }
    }

    public static int kerkoSipasEmrit(Contact[] contacts, String emri) {
        int left = 0;
        int right = contacts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = contacts[mid].emri.compareToIgnoreCase(emri);

            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }

    public static int kerkoSipasNumrit(Contact[] contacts, String numri) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i].numriTelefonit.equals(numri)) {
                return i;
            }
        }
        return -1;
    }

    private static Contact[] gjeneroKontakte(int total) {
        String[] prefikse = {
            "Ar", "El", "Di", "Bes", "Gen", "Jon", "Kle", "Mar", "Olt", "Ren",
            "Sok", "Tea", "Val", "Ani", "Led", "Ner", "Er", "Al", "Ina", "Tir"
        };
        String[] prapashtesa = {
            "a", "i", "on", "or", "an", "is", "in", "ena", "art", "mir",
            "tan", "jan", "lind", "esa", "ina", "ion", "rim", "dar", "el", "ra"
        };

        Random random = new Random();
        Contact[] contacts = new Contact[total];

        for (int i = 0; i < total; i++) {
            String emri = prefikse[random.nextInt(prefikse.length)]
                    + prapashtesa[random.nextInt(prapashtesa.length)]
                    + i;
            String numri = String.format("06%07d", random.nextInt(10_000_000));
            contacts[i] = new Contact(emri, numri);
        }

        return contacts;
    }

    public static void main(String[] args) {
        Contact[] contacts = gjeneroKontakte(1000);
        selectionSortSipasEmrit(contacts);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Kontaktet (1000) u krijuan dhe u renditën alfabetikisht sipas emrit.");
        System.out.println("Zgjidh kërkimin: 1) sipas emrit  2) sipas numrit të telefonit");
        System.out.print("Opsioni: ");

        String opsioni = scanner.nextLine().trim();

        if ("1".equals(opsioni)) {
            System.out.print("Vendos emrin: ");
            String emri = scanner.nextLine().trim();
            int index = kerkoSipasEmrit(contacts, emri);
            if (index >= 0) {
                System.out.println("U gjet: " + contacts[index]);
            } else {
                System.out.println("Emri nuk u gjet.");
            }
        } else if ("2".equals(opsioni)) {
            System.out.print("Vendos numrin e telefonit: ");
            String numri = scanner.nextLine().trim();
            int index = kerkoSipasNumrit(contacts, numri);
            if (index >= 0) {
                System.out.println("U gjet: " + contacts[index]);
            } else {
                System.out.println("Numri nuk u gjet.");
            }
        } else {
            System.out.println("Opsion i pavlefshëm.");
        }

        scanner.close();
    }
}
