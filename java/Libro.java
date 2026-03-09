public class Libro {
    
    private String titolo;
    private String autore;
    private double prezzo;
    private String categoria;

    public Libro(){

        this.titolo = "";
        this.autore = "";
        this.prezzo= 0.0;
        this.categoria="";


    }

    public Libro(String titolo, String autore, double prezzo, String categoria){

        this.titolo=titolo;
        this.autore=autore;
        this.prezzo=prezzo;
        this.categoria=categoria;

    }

    public Libro(Libro l){
        
        this.titolo=l.titolo;
        this.autore=l.autore;
        this.prezzo=l.prezzo;
        this.categoria=l.categoria;
    }

    public String getTitolo(){

        return titolo;

    }

    public String getAutore(){

        return autore;

    }

    public double getPrezzo(){

        return prezzo;

    }

    public String getCategoria(){

        return categoria;

    }


    public void setTitolo(String titolo){

        this.titolo=titolo;
    }

    public void setAutore(String autore){

        this.autore=autore;

    }

    public void setPrezzo(double prezzo){

        this.prezzo=prezzo;

    }

    public void setCategoria(String categoria){

        this.categoria=categoria;

    }


    public void aggiornaTitolo(String titolo){

        if (this.prezzo<20) {
            System.out.println("prezzo conviene");
        }  
        this.titolo=titolo;

    }

    public String toString(){

        return "titolo "+ titolo +"autore " + autore + "prezzo " + prezzo + "categoria " + categoria;



    }

    public boolean isequals(Libro l){

        return this.titolo.equals(l.titolo);

    }


    }



