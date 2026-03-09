public class Impiegato {
    // Attributi privati
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String reparto;
    private double stipendioMensile;
    private int annoAssunzione;
    private int ferieResidue;
    private int oreLavorate;

    // Costruttore di default
    public Impiegato() {
        this.nome = "";
        this.cognome = "";
        this.codiceFiscale = "";
        this.reparto = "";
        this.stipendioMensile = 0.0;
        this.annoAssunzione = 0;
        this.ferieResidue = 30;
        this.oreLavorate = 0;
    }

    // Costruttore con parametri
    public Impiegato(String nome, String cognome, String codiceFiscale, String reparto,
                     double stipendioMensile, int annoAssunzione) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.reparto = reparto;
        this.stipendioMensile = stipendioMensile;
        this.annoAssunzione = annoAssunzione;
        this.ferieResidue = 30;
        this.oreLavorate = 0;
    }

    // Costruttore di copia
    public Impiegato(Impiegato i) {
        this(i.nome, i.cognome, i.codiceFiscale, i.reparto, i.stipendioMensile, i.annoAssunzione);
        this.ferieResidue = i.ferieResidue;
        this.oreLavorate = i.oreLavorate;
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getCodiceFiscale() { return codiceFiscale; }
    public void setCodiceFiscale(String codiceFiscale) { this.codiceFiscale = codiceFiscale; }

    public String getReparto() { return reparto; }
    public void setReparto(String reparto) { this.reparto = reparto; }

    public double getStipendioMensile() { return stipendioMensile; }
    public void setStipendioMensile(double stipendioMensile) { this.stipendioMensile = stipendioMensile; }

    public int getAnnoAssunzione() { return annoAssunzione; }
    public void setAnnoAssunzione(int annoAssunzione) { this.annoAssunzione = annoAssunzione; }

    public int getFerieResidue() { return ferieResidue; }
    public void setFerieResidue(int ferieResidue) { this.ferieResidue = ferieResidue; }

    public int getOreLavorate() { return oreLavorate; }
    public void setOreLavorate(int oreLavorate) { this.oreLavorate = oreLavorate; }

    // Metodi richiesti

    public String toString() {
        return nome + " " + cognome + " (" + codiceFiscale + ")";
    }

    public boolean equals(Impiegato i) {
        return this.codiceFiscale.equalsIgnoreCase(i.codiceFiscale);
    }

    public int compareTo(Impiegato i) {
        return Double.compare(this.stipendioMensile, i.stipendioMensile);
    }

    public void registraOre(int ore) {
        this.oreLavorate += ore;
    }

    public void azzeraOre() {
        this.oreLavorate = 0;
    }

    public double calcolaPagaMensile() {
        double pagaOraria = stipendioMensile / 160;
        if (oreLavorate > 160) {
            int oreExtra = oreLavorate - 160;
            return stipendioMensile + (oreExtra * 1.25 * pagaOraria);
        } else {
            return pagaOraria * oreLavorate;
        }
    }

    public boolean haDirittoAFerie() {
        return ferieResidue > 0;
    }

    public void usaFerie(int giorni) {
        if (giorni <= ferieResidue) ferieResidue -= giorni;
    }

    public String statoImpiegato() {
        return String.format(
            "%s %s - Reparto: %s | Ferie residue: %d | Ore lavorate: %d | Paga stimata: %.2f €",
            nome, cognome, reparto, ferieResidue, oreLavorate, calcolaPagaMensile()
        );
    }

    // Metodi sulle stringhe
    public String generaMatricola() {
        String cognome3 = cognome.length() >= 3 ? cognome.substring(0, 3).toUpperCase() : cognome.toUpperCase();
        String vocali = nome.replaceAll("[^AEIOUaeiou]", "").toUpperCase();
        String nome2 = vocali.length() >= 2 ? vocali.substring(0, 2) : vocali;
        String anno3 = String.valueOf(annoAssunzione).substring(1, 4);
        return cognome3 + "-" + nome2 + "-" + anno3;
    }

    public String inizialiNomeCognome() {
        return (nome.charAt(0) + "" + cognome.charAt(0)).toUpperCase();
    }

    public boolean confrontaReparto(String altroReparto) {
        return this.reparto.equalsIgnoreCase(altroReparto);
    }

    public String descrizioneCompatta() {
        return String.format("%s %s - Reparto: %s - Stipendio: %.2f €",
                cognome.toUpperCase(), nome.toUpperCase(), reparto, stipendioMensile);
    }

    public boolean codiceFiscaleValido() {
        return codiceFiscale.toUpperCase().matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$");
    }
}
