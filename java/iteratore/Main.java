import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeri = Arrays.asList(2, 3, 4);
        Consumer<Integer> stampa = n ->System.out.println(n.toString());// non modifichi il numero ma lo stampi o agfgiungi qualcosa alla stringa o al numero
        BinaryOperator<Integer> prodotto = (a, b) -> a * b;//binary operator prende due argomenti dello stesso tipo e restituisce un risultato dello stesso tipo
        Predicate<Integer> maggioreDiDue = n -> n > 2;//predicate prende un argomento e restituisce un booleano
        Integer prodottoab=prodotto.apply(2,3);//binary operator
        Boolean maggioreDiDueResult = maggioreDiDue.test(3);//predicate
        System.out.println(prodottoab);
        System.out.println(maggioreDiDueResult);
        stampa.accept(2);// consumer
    }
}