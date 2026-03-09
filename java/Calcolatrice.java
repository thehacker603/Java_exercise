import java.util.Scanner;

public class Calcolatrice {

    public static void main(String[] args) {
        int pin=1234;

                Scanner scanner = new Scanner(System.in);
                System.out.println("inserisci il pin del account");
                int accountpin= scanner.nextInt();
                if (accountpin==pin) {
                    System.out.println ("ciao inserisci l'importo");
                    double importo = scanner.nextDouble();
                    System.out.println ("inserisci quanto prelevare");
                    double prelievo = scanner.nextDouble();
                    if(importo>prelievo){
                        System.out.println("operazione eseguita");
                    }
                    else{ System.out.println("operazioe bloccata");};
            }
            else{
                System.out.println("pin errato operazione negata");
            }
        }
    }
