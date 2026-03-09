import java.util.Stack;

public class Wallet_exception extends Exception {
    public Wallet_exception(String messaggio, Throwable c){
        super(messaggio, c, true ,true);
    }
}
public class Wallet {
    private double Balance;
    private Stack<Double> transactions;
    public Wallet (double Balance){
        this.Balance=Balance;
        this.transactions=new Stack<Double>();
    }
    public void withdraw (double importo) throws Wallet_exception{
        if (importo>Balance){
            throw new Wallet_exception("Saldo insufficiente", null);
        }
        Balance-=importo;
        transactions.push(importo);
    }
}
public class Digital_Wallet extends Wallet {
    private int saldo;
    public Digital_Wallet (int saldo){
        super(saldo);
        this.saldo=saldo;
    }
}
public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet(100);
        try {
            wallet.withdraw(150);
        } catch (Wallet_exception e) {
            System.out.println(e.getMessage());
        }
    }
    Double d =Double.parseDouble("1.00");
}// messege =messaggio di errore, cause la causa del errore, stacktrace = la traccia dello stack, suppressed= eccezioni soppresse, localizedmessage= messaggio localizzato, toString= rappresentazione testuale dell'eccezione, getclass= restituisce la classe dell'eccezione, getcause= restituisce la causa dell'eccezione, getstacktrace= restituisce la traccia dello stack