public class Canzone {
    private final String titolo;
    private final String artista;
    private final String genere;
    private final int durataSecondi;

    public Canzone(String titolo, String artista, String genere, int durataSecondi) {
        this.titolo = titolo;
        this.artista = artista;
        this.genere = genere;
        this.durataSecondi = durataSecondi;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenere() {
        return genere;
    }

    public int getDurataSecondi() {
        return durataSecondi;
    }
}
