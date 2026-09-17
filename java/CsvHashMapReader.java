import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class CsvHashMapReader {

    static class Client {
        int clientId;
        String name;
        String email;
        String country;

        Client(int clientId, String name, String email, String country) {
            this.clientId = clientId;
            this.name = name;
            this.email = email;
            this.country = country;
        }

        @Override
        public String toString() {
            return name + " (" + country + ")";
        }
    }

    static class Asset {
        int assetId;
        double currentValue;
        String symbol;

        Asset(int assetId, double currentValue, String symbol) {
            this.assetId = assetId;
            this.currentValue = currentValue;
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol + " = " + currentValue;
        }
    }

    static class Holding {
        int clientId;
        int assetId;
        double quantity;

        Holding(int clientId, int assetId, double quantity) {
            this.clientId = clientId;
            this.assetId = assetId;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) {
        Path clientsFile = Path.of("clients.csv");
        Path assetsFile = Path.of("crypto_assets.csv");
        Path holdingsFile = Path.of("holdings.csv");

        try {
            HashMap<Integer, Client> clients = readClients(clientsFile);
            HashMap<Integer, Asset> assets = readAssets(assetsFile);
            HashMap<Integer, Holding> holdings = readHoldings(holdingsFile);

            System.out.println("Clienti caricati: " + clients.size());
            System.out.println("Asset caricati: " + assets.size());
            System.out.println("Holding caricate: " + holdings.size());
            System.out.println();

            for (Holding holding : holdings.values()) {
                Client client = clients.get(holding.clientId);
                Asset asset = assets.get(holding.assetId);

                if (client != null && asset != null) {
                    System.out.printf(
                            "%s possiede %.4f %s (valore corrente: %.4f)%n",
                            client.name,
                            holding.quantity,
                            asset.symbol,
                            asset.currentValue
                    );
                }
            }
        } catch (IOException | NumberFormatException exception) {
            System.err.println("Errore nella lettura dei file CSV: " + exception.getMessage());
        }
    }

    private static HashMap<Integer, Client> readClients(Path file) throws IOException {
        HashMap<Integer, Client> clients = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            reader.readLine(); // Salta l'intestazione.

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] columns = line.split(",");
                int clientId = Integer.parseInt(columns[0].trim());
                Client client = new Client(
                        clientId,
                        columns[1].trim(),
                        columns[2].trim(),
                        columns[3].trim()
                );
                clients.put(clientId, client);
            }
        }

        return clients;
    }

    private static HashMap<Integer, Asset> readAssets(Path file) throws IOException {
        HashMap<Integer, Asset> assets = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            reader.readLine(); // Salta l'intestazione.

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] columns = line.split(",");
                int assetId = Integer.parseInt(columns[0].trim());
                Asset asset = new Asset(
                        assetId,
                        Double.parseDouble(columns[1].trim()),
                        columns[2].trim()
                );
                assets.put(assetId, asset);
            }
        }

        return assets;
    }

    private static HashMap<Integer, Holding> readHoldings(Path file) throws IOException {
        HashMap<Integer, Holding> holdings = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            reader.readLine(); // Salta l'intestazione.
            int holdingId = 1;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] columns = line.split(",");
                Holding holding = new Holding(
                        Integer.parseInt(columns[0].trim()),
                        Integer.parseInt(columns[2].trim()),
                        Double.parseDouble(columns[4].trim())
                );
                holdings.put(holdingId++, holding);
            }
        }

        return holdings;
    }
}
