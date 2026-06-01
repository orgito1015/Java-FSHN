import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise5 {

    public static void main(String[] args) {
        Map<String, String> tiranaAreas = new LinkedHashMap<>();
        tiranaAreas.put("1001", "Qender");
        tiranaAreas.put("1002", "Blloku");
        tiranaAreas.put("1003", "Pazari i Ri");
        tiranaAreas.put("1004", "Ali Demi");
        tiranaAreas.put("1005", "Laprake");
        tiranaAreas.put("1006", "Kombinat");

        tiranaAreas.forEach((postalCode, area) -> System.out.println(postalCode + " -> " + area));
    }
}

