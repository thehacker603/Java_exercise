
// ===== Classe Main =====
import java.util.Scanner;

public class Main_parcheggio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parcheggio p = new Parcheggio("Parcheggio Centro", 5);
        int scelta;

        do {
            System.out.println("\n1. Aggiungi auto");
            System.out.println("2. Inserisci auto in posizione");
            System.out.println("3. Elimina auto");
            System.out.println("4. Numero auto presenti");
            System.out.println("5. Visualizza auto");
            System.out.println("6. Cerca auto per targa");
            System.out.println("7. Cerca auto per marca");
            System.out.println("0. Esci");
            scelta = sc.nextInt();

            switch (scelta) {
                case 1 -> {
                    Auto a = leggiAuto(sc);
                    System.out.println(p.aggiungiAuto(a) ? "Auto aggiunta" : "Parcheggio pieno");
                }
                case 2 -> {
                    Auto a = leggiAuto(sc);
                    System.out.print("Posizione: ");
                    int pos = sc.nextInt();
                    System.out.println(p.inserisciAuto(a, pos) ? "Inserita" : "Errore inserimento");
                }
                case 3 -> {
                    System.out.print("Posizione: ");
                    int pos = sc.nextInt();
                    System.out.println(p.eliminaAuto(pos) ? "Eliminata" : "Errore eliminazione");
                }
                case 4 -> System.out.println("Auto presenti: " + p.numeroAutoPresenti());
                case 5 -> p.visualizzaAuto();
                case 6 -> {
                    System.out.print("Targa: ");
                    String t = sc.next();
                    Auto a = p.cercaPerTarga(t);
                    System.out.println(a != null ? a : "Non trovata");
                }
                case 7 -> {
                    System.out.print("Marca: ");
                    String m = sc.next();
                    Auto[] res = p.cercaPerMarca(m);
                    for (Auto a : res) System.out.println(a);
                }
            }
        } while (scelta != 0);

        sc.close();
    }

    private static Auto leggiAuto(Scanner sc) {
        System.out.print("Targa: ");
        String t = sc.next();
        System.out.print("Modello: ");
        String mod = sc.next();
        System.out.print("Marca: ");
        String mar = sc.next();
        System.out.print("Cilindrata: ");
        int c = sc.nextInt();
        return new Auto(t, mod, mar, c);
    }
}
