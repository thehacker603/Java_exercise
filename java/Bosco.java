public class Bosco {

    private String nome;
    private Albero[] alberi;
    private int numeroAlberi;
    private final int NMAX = 20;

    // Costruttore di default
    public Bosco() {
        this.nome = "";
        this.alberi = new Albero[NMAX];
        this.numeroAlberi = 0;
    }

    // Costruttore con parametri
    public Bosco(String nome, Albero[] alberi, int numeroAlberi) {
        this.nome = nome;
        this.alberi = new Albero[NMAX];
        this.numeroAlberi = Math.min(numeroAlberi, NMAX);

        // Copia profonda degli alberi
        for(int i = 0; i < this.numeroAlberi; i++) {
            this.alberi[i] = new Albero(alberi[i]);
        }
    }

    // Costruttore di copia
    public Bosco(Bosco b) {
        this.nome = b.nome;
        this.numeroAlberi = b.numeroAlberi;
        this.alberi = new Albero[NMAX];

        for(int i = 0; i < numeroAlberi; i++) {
            this.alberi[i] = new Albero(b.alberi[i]);
        }
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumeroAlberi() { return numeroAlberi; }

    public Albero getAlbero(int index) {
        if (index >= 0 && index < numeroAlberi) {
            return new Albero(alberi[index]);
        }
        return null;
    }

    // Aggiunge un nuovo Albero al bosco
    public boolean aggiungiAlbero(Albero a) {
        if (numeroAlberi < NMAX) {
            alberi[numeroAlberi] = new Albero(a); // copia profonda
            numeroAlberi++;
            return true;
        }
        return false;
    }

    // Rimuove un albero in posizione index
    public boolean rimuoviAlbero(int index) {
        if (index >= 0 && index < numeroAlberi) {
            // Shifta gli elementi
            for (int i = index; i < numeroAlberi - 1; i++) {
                alberi[i] = alberi[i + 1];
            }
            alberi[numeroAlberi - 1] = null;
            numeroAlberi--;
            return true;
        }
        return false;
    }

    // Cambia specie di un albero specifico
    public boolean cambiaSpecieAlbero(int index, String nuovaSpecie) {
        if (index >= 0 && index < numeroAlberi) {
            alberi[index].setSpecie(nuovaSpecie);
            return true;
        }
        return false;
    }

    // Applica crescita a tutti gli alberi
    public void crescitaAnnuale() {
        for (int i = 0; i < numeroAlberi; i++) {
            alberi[i].crescita(365);
        }
    }

    // Altezza totale del bosco
    public double altezzaTotale() {
        double tot = 0;
        for (int i = 0; i < numeroAlberi; i++) {
            tot += alberi[i].getAltezza();
        }
        return tot;
    }

    public boolean isVuoto() {
        return numeroAlberi == 0;
    }

    // toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bosco{ nome='" + nome + "', alberi=[");
        for (int i = 0; i < numeroAlberi; i++) {
            sb.append(alberi[i].toString());
            if (i < numeroAlberi - 1) sb.append(", ");
        }
        sb.append("], numeroAlberi=" + numeroAlberi + " }");
        return sb.toString();
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Bosco b = (Bosco) obj;

        if (!this.nome.equals(b.nome)) return false;
        if (this.numeroAlberi != b.numeroAlberi) return false;

        for (int i = 0; i < numeroAlberi; i++) {
            if (!this.alberi[i].equals(b.alberi[i])) return false;
        }

        return true;
    }
    //taglia 
    public void taglia(double pota_dimnsione, int i )  {
            alberi[i].pota(pota_dimnsione);
        }
    }
