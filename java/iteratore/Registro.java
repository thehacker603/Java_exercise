package iteratore;
public class Registro {
    private studente[] studenti;
    private int count;

    public Registro(int capacity) {
        studenti = new studente[capacity];
        count = 0;
    }

    public void addStudente(studente s) {
        if (count < studenti.length) {
            studenti[count++] = s;
        } else {
            System.out.println("Registro pieno!");
        }
    }
}
