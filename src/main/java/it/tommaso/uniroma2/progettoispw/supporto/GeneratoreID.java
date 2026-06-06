package it.tommaso.uniroma2.progettoispw.supporto;

import java.io.*;

public class GeneratoreID {


    private static final String FILE_ID = "resources/ultimo_id_assegnato";

    public static int generaId() throws IOException {

        int ultimoId = leggiUltimoId();
        int nuovoId = ultimoId + 1;

        salvaUltimoId(nuovoId);

        return nuovoId;
    }

    private static int leggiUltimoId() throws IOException {

        File file = new File(FILE_ID);

        // Prima esecuzione
        if (!file.exists()) {
            return 0;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String linea = reader.readLine();

            if (linea == null || linea.isBlank()) {
                return 0;
            }

            return Integer.parseInt(linea);
        }
    }

    private static void salvaUltimoId(int id) throws IOException {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_ID))) {

            writer.write(String.valueOf(id));
        }
    }
}

