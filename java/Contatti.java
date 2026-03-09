public class Contatti {
    private String nome="";
    private String email="";
    private String telefono="";
    private String cognome="";
    
    public Contatti(String nome, String email, String telefono, String cognome){
        this.nome=nome;
        this.email=email;
        this.telefono= telefono;
        this.cognome=cognome;
    }
    public String getNome(){return nome;};
    public String getEmail(){return email;};
    public String getTelefono(){return telefono;};
    public String getCognome(){return cognome;};

    public void setPhone(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }

    public String toString() {
        return String.format("Nome: %s | Telefono: %s | Email: %s", nome, telefono, email);
    }
}

