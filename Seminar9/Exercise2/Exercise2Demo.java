public class Exercise2Demo {
    public static void main(String[] args) {
        Menaxher menaxher = new Menaxher("Elda", "Hoxha", 202, "Financë", 7);

        System.out.println("Zgjedhja e emrave të klasave:");
        System.out.println("A = Personi");
        System.out.println("B = Menaxher");
        System.out.println("Hierarkia: Personi -> Punonjes -> Menaxher");
        System.out.println(menaxher);
    }
}
