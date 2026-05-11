import java.time.LocalDate;

public class Exercise1Demo {
    public static void main(String[] args) {
        Adresa adresa = new Adresa("Rr. Dëshmorët e Kombit", "Tiranë");
        Punonjes punonjes = new Punonjes(
                "Ardit Kola",
                101,
                LocalDate.of(2022, 9, 1),
                "IT",
                95000,
                adresa
        );

        System.out.println("Relacioni midis klasave Punonjes dhe Adresa: AGREGIM");
        System.out.println(punonjes);
    }
}
