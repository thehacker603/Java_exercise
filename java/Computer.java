public class Computer {
    // Attributi privati
    private String marca;
    private int ram; // in GB
    private int hardDisk; // in GB
    private double frequenzaCPU; // in GHz
    private String codiceSerie; // codice identificativo

    // Costruttore di default
    public Computer() {
        this.marca = "Sconosciuta";
        this.ram = 8;
        this.hardDisk = 256;
        this.frequenzaCPU = 2.5;
        this.codiceSerie = "N/A";
    }

    // Costruttore con parametri
    public Computer(String marca, int ram, int hardDisk, double frequenzaCPU, String codiceSerie) {
        this.marca = marca;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.frequenzaCPU = frequenzaCPU;
        this.codiceSerie = codiceSerie;
    }

    // Costruttore di copia
    public Computer(Computer c) {
        this.marca = c.marca;
        this.ram = c.ram;
        this.hardDisk = c.hardDisk;
        this.frequenzaCPU = c.frequenzaCPU;
        this.codiceSerie = c.codiceSerie;
    }

    // Getter e Setter
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    public int getHardDisk() { return hardDisk; }
    public void setHardDisk(int hardDisk) { this.hardDisk = hardDisk; }

    public double getFrequenzaCPU() { return frequenzaCPU; }
    public void setFrequenzaCPU(double frequenzaCPU) { this.frequenzaCPU = frequenzaCPU; }

    public String getCodiceSerie() { return codiceSerie; }
    public void setCodiceSerie(String codiceSerie) { this.codiceSerie = codiceSerie; }

    // toString()
    public String toString() {
        return "Computer{" +
                "marca='" + marca + '\'' +
                ", ram=" + ram + "GB" +
                ", hardDisk=" + hardDisk + "GB" +
                ", frequenzaCPU=" + frequenzaCPU + "GHz" +
                ", codiceSerie='" + codiceSerie + '\'' +
                '}';
    }

    // equals()
    public boolean equals(Computer c) {
        return this.marca.equalsIgnoreCase(c.marca) &&
               this.ram == c.ram &&
               this.hardDisk == c.hardDisk &&
               this.frequenzaCPU == c.frequenzaCPU;
    }

    // compareTo()
    public int compareTo(Computer c) {
        return Double.compare(this.frequenzaCPU, c.frequenzaCPU);
    }

    // aggiungiRam()
    public void aggiungiRam(int nuovaRam) {
        if (nuovaRam > 0)
            this.ram += nuovaRam;
    }

    // calcolarePrezzo()
    public double calcolarePrezzo() {
        return 420 + (ram * 3) + (hardDisk * 0.10);
    }

    // èPerformante()
    public boolean èPerformante() {
        return (frequenzaCPU > 4) && (ram > 16);
    }

    // nuovoComputerPotente()
    public Computer nuovoComputerPotente(Computer c) {
        return new Computer(c.marca, c.ram * 2, c.hardDisk * 2, c.frequenzaCPU, c.codiceSerie);
    }

    // codiceCompatto()
    public String codiceCompatto() {
        String codice = "";
        for (char ch : this.marca.toUpperCase().toCharArray()) {
            if ("AEIOU".indexOf(ch) >= 0) codice += ch; else{codice+="X";};
            if (codice.length() == 2) break;
        }
        String ultimeTre = codiceSerie.length() >= 3 ?
                codiceSerie.substring(codiceSerie.length() - 3) : codiceSerie;
        return codice + "-" + ram + "-" + ultimeTre;
    }

    // acronimoMarca()
    public String acronimoMarca() {
        String[] parole = marca.split(" ");
        String acronimo = "";
        for (String p : parole) {
            if (!p.isEmpty())
                acronimo += Character.toUpperCase(p.charAt(0));
        }
        return acronimo;
    }

    // confrontaMarca()
    public boolean confrontaMarca(String altraMarca) {
        return this.marca.equalsIgnoreCase(altraMarca);
    }

    // descrizioneCompatta()
    public String descrizioneCompatta() {
        double prestazioni = Math.min(100, (frequenzaCPU / 7.0) * 100); // stima fittizia %
        return String.format("%s (%.1fGHz) - %dGB RAM - %dGB HDD - %.0f%% prestazioni",
                marca.toUpperCase(), frequenzaCPU, ram, hardDisk, prestazioni);
    }

    // codiceSerieValido()
    public boolean codiceSerieValido() {
        return codiceSerie.matches("[A-Z0-9]{7}");
    }
}
