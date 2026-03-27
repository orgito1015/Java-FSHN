/**
 * Ushtrimi 1 — Konvertimi i Temperaturës (Celsius → Fahrenheit)
 *
 * Detyrë:
 * - Shkruaj një metodë statike celsiusNefahrenheit(double celsius) që konverton
 *   temperaturën nga Celsius në Fahrenheit.
 * - Formula: F = C * 9/5 + 32
 * - Testoje me disa vlera (0°C, 100°C, -40°C).
 *
 * Shpjegim:
 * - Formula standarde e konvertimit: shumëzon Celsius me 1.8 dhe shton 32.
 * - Metoda kthen tipin double.
 * - String.format("%.2f", ...) formon rezultatin me 2 shifra dhjetore.
 */
public class UshtrimiS1_1 {

    /**
     * Konverton temperature nga Celsius ne Fahrenheit.
     *
     * @param celsius temperatura ne Celsius
     * @return temperatura ekuivalente ne Fahrenheit
     */
    public static double celsiusNeFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    public static void main(String[] args) {
        System.out.println(celsiusNeFahrenheit(0));    // 32.0
        System.out.println(celsiusNeFahrenheit(100));  // 212.0
        System.out.println(celsiusNeFahrenheit(-40));  // -40.0
        System.out.println(celsiusNeFahrenheit(37));   // 98.6

        // Me formatim
        System.out.printf("37°C = %.2f°F%n", celsiusNeFahrenheit(37));
    }
}
