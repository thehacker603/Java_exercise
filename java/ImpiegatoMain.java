public class ImpiegatoMain {
    public static void main(String[] args) {
        Impiegato i1 = new Impiegato("Mario", "Rossi", "RSSMRA85C10H501U", "Informatica", 1800, 2018);
        Impiegato i2 = new Impiegato("Lucia", "Bianchi", "BNCLCU90F20H501S", "Amministrazione", 2000, 2015);

        System.out.println("== Test Impiegati ==");
        System.out.println(i1.statoImpiegato());
        System.out.println(i2.statoImpiegato());

        i1.registraOre(170);
        System.out.println("\nDopo 170 ore lavorate:");
        System.out.println(i1.statoImpiegato());

        i1.usaFerie(5);
        System.out.println("\nDopo ferie:");
        System.out.println(i1.statoImpiegato());

        i2.registraOre(170);

        System.out.println("\nMatricola: " + i1.generaMatricola());
        System.out.println("Iniziali: " + i1.inizialiNomeCognome());
        System.out.println("Codice fiscale valido? " + i1.codiceFiscaleValido());
        System.out.println("Stesso reparto di Lucia? " + i1.confrontaReparto(i2.getReparto()));
        System.out.println("sono uguali" + i1.equals(i2));
        System.out.println("stesso codice"+ i1.compareTo(i2));
        System.out.println("ha delle ferie "+ i1.haDirittoAFerie());
        System.out.println("stipendio mario " + i1.calcolaPagaMensile());
        System.out.println("stipndio lucia "+ i2.calcolaPagaMensile());
    }
}
