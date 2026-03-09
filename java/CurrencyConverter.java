import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("EUR", 1.0);
        rates.put("USD", 1.07);
        rates.put("GBP", 0.86);
        rates.put("JPY", 160.5);

        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci la valuta di partenza (EUR, USD, GBP, JPY): ");
        String from = sc.next().toUpperCase();

        System.out.print("Inserisci la valuta di destinazione: ");
        String to = sc.next().toUpperCase();

        System.out.print("Inserisci l'importo: ");
        double amount = sc.nextDouble();

        if (!rates.containsKey(from) || !rates.containsKey(to)) {
            System.out.println("Valuta non supportata!");
        } else {
            double converted = amount / rates.get(from) * rates.get(to);
            System.out.printf("%.2f %s = %.2f %s%n", amount, from, converted, to);
        }

        sc.close();
    }
}
