// ===== Classe Parcheggio =====
class Parcheggio {
    private String nome;
    private int numeroMaxPosti;
    private Auto[] posti;

    public Parcheggio(String nome, int numeroMaxPosti) {
        this.nome = nome;
        this.numeroMaxPosti = numeroMaxPosti;
        posti = new Auto[numeroMaxPosti];
    }

    // Aggiunge un'auto nel primo posto libero
    public boolean aggiungiAuto(Auto a) {
        for (int i = 0; i < posti.length; i++) {
            if (posti[i] == null) {
                posti[i] = a;
                return true;
            }
        }
        return false; // parcheggio pieno
    }

    // Inserisce un'auto in posizione x
    public boolean inserisciAuto(Auto a, int x) {
        if (x >= 0 && x < posti.length && posti[x] == null) {
            posti[x] = a;
            return true;
        }
        return false;
    }

    // Elimina un'auto in posizione x
    public boolean eliminaAuto(int x) {
        if (x >= 0 && x < posti.length && posti[x] != null) {
            posti[x] = null;
            return true;
        }
        return false;
    }

    // Restituisce il numero di auto presenti
    public int numeroAutoPresenti() {
        int count = 0;
        for (Auto a : posti) {
            if (a != null) count++;
        }
        return count;
    }


    // Visualizza tutte le auto
    public void visualizzaAuto() {
        for (int i = 0; i < posti.length; i++) {
            if (posti[i] != null)
                System.out.println("Posto " + i + ": " + posti[i]);
        }
    }

    // Ricerca auto per targa
    public Auto cercaPerTarga(String targa) {
        for (Auto a : posti) {
            if (a != null && a.getTarga().equalsIgnoreCase(targa))
                return a;
        }
        return null;
    }

    // Restituisce vettore di auto di una certa marca
    public Auto[] cercaPerMarca(String marca) {
        int count = 0;
        for (Auto a : posti)
            if (a != null && a.getMarca().equalsIgnoreCase(marca)) count++;

        Auto[] risultato = new Auto[count];
        int i = 0;
        for (Auto a : posti)
            if (a != null && a.getMarca().equalsIgnoreCase(marca))
                risultato[i++] = a;

        return risultato;
    }
}

