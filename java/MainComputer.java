import java.util.*;
public class MainComputer {
    public static void main(String[] args) {
         Scanner tastiera= new Scanner(System.in);
        // Oggetti creati con diversi costruttori
        Computer c1 = new Computer();
        Computer c2 = new Computer("Dell", 16, 512, 3.8, "AB123CD");
        Computer c3 = new Computer(c2);

        // Stampa dei dati
        System.out.println("---- DATI COMPUTER ----");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Test metodi principali
        c2.aggiungiRam(8);
        System.out.println("\nRAM aggiornata: " + c2.getRam() + " GB");
        System.out.println("Prezzo: " + c2.calcolarePrezzo() + " €");
        System.out.println("È performante? " + c2.èPerformante());

        // Test di confronto
        System.out.println("\nUguali? " + c2.equals(c3));
        System.out.println("Comparazione frequenza (c2 vs c1): " + c2.compareTo(c1));

        // Test metodi stringa
        System.out.println("\nCodice compatto: " + c2.codiceCompatto());
        System.out.println("Acronimo marca: " + c2.acronimoMarca());
        System.out.println("Confronto marca con 'DELL': " + c2.confrontaMarca("DELL"));
        System.out.println("Descrizione compatta: " + c2.descrizioneCompatta());
        System.out.println("Codice serie valido? " + c2.codiceSerieValido());
        
        // New power computer
        Computer c4 = c2.nuovoComputerPotente(c2);
        System.out.println("\nNuovo computer potente:");
        System.out.println(c4);
        System.out.println("inserisci la ram da aggiungere");
        //add ram to c2
        int ram_new= tastiera.nextInt();
        c2.aggiungiRam(ram_new);
        System.out.println(c2.toString());

        System.out.println("il prezzo del pc e "+ c2.calcolarePrezzo());
        if (c2.èPerformante()) {
            System.out.println("c2 e performante");
        }
        else{
            System.out.println("c2 non e performante");
        }
        
    }
}
