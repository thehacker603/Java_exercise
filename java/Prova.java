import java.util.Scanner;

public class Prova{
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println ("ciao inserisci l'importo");
            double importo = scanner.nextDouble();
            System.out.println ("inserisci quanto prelevare");
            double prelievo = scanner.nextDouble();
            if(importo>prelievo){
                System.out.println("operazione eseguita");
            }
            else{ System.out.println("operazioe bloccata");};
    }
}