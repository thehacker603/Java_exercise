public class Albero {
    private String specie;
    private double altezza;
    private boolean sempreverde;

    // Costruttore di default
    public Albero() {
        this.specie = "";
        this.altezza = 0.0;
        this.sempreverde = false;
    }

    // Costruttore con parametri
    public Albero(String specie, double altezza, boolean sempreverde) {
        this.specie = specie;
        this.altezza = altezza;
        this.sempreverde = sempreverde;
}

    // Costruttore di copia
    public Albero(Albero a) {
        this.specie = a.specie;
        this.altezza = a.altezza;
        this.sempreverde = a.sempreverde;
    }

    // Getter e Setter
    public String getSpecie() { return specie; }
    public void setSpecie(String specie) { this.specie = specie; }  
    public double getAltezza() { return altezza; }
    public void setAltezza(double altezza) { this.altezza = altezza; }
    public boolean isSempreverde() { return sempreverde; }
    public void setSempreverde(boolean sempreverde) { this.sempreverde = sempreverde;
    }

    // toString()
    @Override
    public String toString() {
        return "Albero{" +
                "specie='" + specie + '\'' +
                ", altezza=" + altezza + "m" +
                ", sempreverde=" + sempreverde;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Albero albero = (Albero) obj;
        return Double.compare(albero.altezza, altezza) == 0 &&
               sempreverde == albero.sempreverde &&
               specie.equals(albero.specie);
    }
    public void crescita(int giorni) {
        this.altezza += 0.12*giorni;
    }
    // Metodo per potare l'albero
    public void pota(double pota_dimnsione) {
        if (pota_dimnsione>0 && pota_dimnsione <= this.altezza) {
            this.altezza -= pota_dimnsione; // Riduce l'altezza 
        }
    }
    // Metodo per clonare l'albero
    public Albero clone() {
        return new Albero(this);
    }
}
