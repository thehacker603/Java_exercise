import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlaylistMusicale {
    public static void main(String[] args) {
        Path inputFile = Path.of("canzoni.csv");
        Path outputFile = Path.of("playlist.csv");
        List<Canzone> canzoni = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            reader.readLine(); // Salta intestazione.

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] colonne = line.split(",");
                if (colonne.length < 4) {
                    continue;
                }

                Canzone canzone = new Canzone(
                        colonne[0].trim(),
                        colonne[1].trim(),
                        colonne[2].trim(),
                        Integer.parseInt(colonne[3].trim())
                );
                canzoni.add(canzone);
            }
        } catch (IOException | NumberFormatException exception) {
            System.err.println("Errore nella lettura del file canzoni.csv: " + exception.getMessage());
            return;
        }

        canzoni.sort(Comparator.comparing(Canzone::getTitolo, String.CASE_INSENSITIVE_ORDER));

        int durataTotale = 0;
        Canzone canzonePiuLunga = null;

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            writer.write("titolo,artista,genere,durata_sec");
            writer.newLine();

            for (Canzone canzone : canzoni) {
                writer.write(String.format(
                        "%s,%s,%s,%d",
                        canzone.getTitolo(),
                        canzone.getArtista(),
                        canzone.getGenere(),
                        canzone.getDurataSecondi()
                ));
                writer.newLine();

                durataTotale += canzone.getDurataSecondi();
                if (canzonePiuLunga == null || canzone.getDurataSecondi() > canzonePiuLunga.getDurataSecondi()) {
                    canzonePiuLunga = canzone;
                }
            }

            String titoloPiuLungo = canzonePiuLunga == null ? "" : canzonePiuLunga.getTitolo();
            writer.write(String.format("riepilogo,,durata_totale=%d,titolo_piu_lunga=%s", durataTotale, titoloPiuLungo));
            writer.newLine();
        } catch (IOException exception) {
            System.err.println("Errore nella scrittura del file playlist.csv: " + exception.getMessage());
        }
    }
}
