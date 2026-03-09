import java.util.ArrayList;
import java.util.Scanner;

public class Maincont {

    private static ArrayList<Contatti> contatList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
                do {
            System.out.println("\n--- Rubrica Contatti ---");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Mostra contatti");
            System.out.println("3. Cerca contatto");
            System.out.println("4. Elimina contatto");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            choice = sc.nextInt();
            sc.nextLine(); // pulisce buffer

            switch (choice) {
                case 1 -> addContact();
                case 2 -> showContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Chiusura programma...");
                default -> System.out.println("Scelta non valida!");
            }
        } while (choice != 5);
    }
    private static void addContact(){
        System.out.println("nome");
        String nome = sc.nextLine();

        System.out.println("cognome");
        String cognome =sc.nextLine();

        System.out.println("email");
        String email=sc.nextLine();

        System.out.println("telefono");
        String telefono =sc.nextLine();

        contatList.add(new Contatti(nome, email, telefono, cognome));
        System.out.println("contatto "+nome +"agginto");
    }

    public static void showContacts(){
        for (Contatti c : contatList) {
            System.out.println(c);
        }
    }

    public static void searchContact(){
        System.out.println("inserisci il nome da cercare");
        String nome= sc.nextLine();

        for(Contatti c : contatList){
            if (c.getNome()==nome) {
                System.out.println("contatto trovato"+ c);
            }
        }
    }

    public static void deleteContact(){
        System.out.println("inserisci il contatto da eliminare");
        String nome= sc.nextLine();

        contatList.removeIf(c-> c.getNome().equalsIgnoreCase(nome));
        System.out.println("contatto "+nome+" é stato eliminato");
    }
}
