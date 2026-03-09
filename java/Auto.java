public class Auto {
    // ===== Classe Auto =====
    private String targa;
    private String modello;
    private String marca;
    private int cilindrata;

    // Costruttore default
    public Auto() {
        this("", "", "", 0);
    }

    // Costruttore parametrizzato
    public Auto(String targa, String modello, String marca, int cilindrata) {
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.cilindrata = cilindrata;
        
    }

    // Costruttore di copia
    public Auto(Auto a) {
        this(a.targa, a.modello, a.marca, a.cilindrata);
    }

    // Getter e Setter
    public String getTarga() { return targa; }
    public void setTarga(String targa) { this.targa = targa; }

    public String getModello() { return modello; }
    public void setModello(String modello) { this.modello = modello; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getCilindrata() { return cilindrata; }
    public void setCilindrata(int cilindrata) { this.cilindrata = cilindrata; }

    @Override
    public String toString() {
        return "Auto [targa=" + targa + ", modello=" + modello + ", marca=" + marca + ", cilindrata=" + cilindrata + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Auto other = (Auto) obj;
        return targa.equalsIgnoreCase(other.targa);
    }
}

