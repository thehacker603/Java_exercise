import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Bosco bosco = new Bosco();  
        bosco.setNome("Bosco Utente");

        System.out.print("Quanti alberi vuoi inserire? (max 20): ");
        int n = input.nextInt();
        input.nextLine(); // pulisci buffer

        if (n > 20) n = 20;
        if (n < 1) n = 1;

        Albero ultimo = null; // memorizza l'ultimo albero inserito

        for (int i = 0; i < n; i++) {

            System.out.println("\n--- Albero n° " + (i + 1) + " ---");

            if (i > 0) {
                System.out.print("È uguale al precedente? (invio = sì, scrivi NO per cambiarlo): ");
                String risposta = input.nextLine().trim();

                if (risposta.equalsIgnoreCase("NO")) {
                    // Inserisci nuovo albero con caratteristiche diverse
                    ultimo = leggiAlberoDaUtente(input);
                } else {
                    // Copia il precedente
                    bosco.aggiungiAlbero(ultimo);
                    System.out.println("Albero copiato!");
                    continue;
                }

            } else {
                // Primo albero: chiede sempre le caratteristiche
                ultimo = leggiAlberoDaUtente(input);
            }

            bosco.aggiungiAlbero(ultimo);
        }

        System.out.println("\n===============================");
        System.out.println("🌳 BOSCO INSERITO DALL'UTENTE");
        System.out.println("===============================");
        System.out.println(bosco.toString());
        bosco.taglia(0.5, 2);
        System.out.println(bosco.toString());
    }

    // Metodo che chiede all'utente i dati dell'albero
    public static Albero leggiAlberoDaUtente(Scanner input) {

        System.out.print("Specie albero: ");
        String specie = input.nextLine();

        System.out.print("Altezza iniziale (in metri): ");
        double altezza = input.nextDouble();

        System.out.print("È sempreverde? (true/false): ");
        boolean sempreverde = input.nextBoolean();
        input.nextLine(); // pulisci buffer

        return new Albero(specie, altezza, sempreverde);
    }
}
