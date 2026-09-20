package ;
public class studente {
    private String nome;
    private String cognome;
    private int voto;

    public studente() {
        this("", "", 0);
    }

    public studente(String nome, String cognome, int voto) {
        this.nome = nome;
        this.cognome = cognome;
        this.voto = voto;
    }

    public studente(studente s) {
        this(s.nome, s.cognome, s.voto);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public int getVoto() { return voto; }
    public void setVoto(int voto) { this.voto = voto; }

    @Override
    public String toString() {
        return "studente [nome=" + nome + ", cognome=" + cognome + ", voto=" + voto + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        studente other = (studente) obj;
        return voto == other.voto;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(voto);
    }
}
