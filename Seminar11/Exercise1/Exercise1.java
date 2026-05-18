import java.util.Arrays;

public class Exercise1 {

    static class River {
        String emri;
        double gjatesiaKm;

        River(String emri, double gjatesiaKm) {
            this.emri = emri;
            this.gjatesiaKm = gjatesiaKm;
        }

        @Override
        public String toString() {
            return emri + " (" + gjatesiaKm + " km)";
        }
    }

    public static void selectionSortZbrites(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void selectionSortLumenjSipasGjatesise(River[] lumenjte) {
        for (int i = 0; i < lumenjte.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < lumenjte.length; j++) {
                if (lumenjte[j].gjatesiaKm > lumenjte[maxIndex].gjatesiaKm) {
                    maxIndex = j;
                }
            }
            River temp = lumenjte[i];
            lumenjte[i] = lumenjte[maxIndex];
            lumenjte[maxIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numra = {12, 4, 89, 33, 7, 1};
        System.out.println("Array origjinal: " + Arrays.toString(numra));
        selectionSortZbrites(numra);
        System.out.println("Array i renditur zbritës: " + Arrays.toString(numra));

        River[] lumenjte = {
            new River("Drini", 285),
            new River("Vjosa", 272),
            new River("Mati", 115),
            new River("Shkumbini", 181)
        };

        System.out.println("\nLumenjtë para renditjes:");
        for (River r : lumenjte) {
            System.out.println("- " + r);
        }

        selectionSortLumenjSipasGjatesise(lumenjte);

        System.out.println("\nLumenjtë pas renditjes (sipas gjatësisë, zbritës):");
        for (River r : lumenjte) {
            System.out.println("- " + r);
        }
    }
}
