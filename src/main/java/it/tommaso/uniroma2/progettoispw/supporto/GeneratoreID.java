package it.tommaso.uniroma2.progettoispw.supporto;

import java.io.*;

public class GeneratoreID {


    public static GeneratoreID ottieniGeneratore(){
        if(GeneratoreID.ContenitoreGeneratoreID.istanza == null){
            GeneratoreID.ContenitoreGeneratoreID.istanza = new GeneratoreID();
        }

        return ContenitoreGeneratoreID.istanza;
    }

    private static class ContenitoreGeneratoreID{
        private static GeneratoreID istanza;
    }

    private GeneratoreID(){}


    private static final String FILE_ID = "resources/ultimo_id_assegnato";



    public int generaId() throws IOException {

        int ultimoId = leggiUltimoId();
        int nuovoId = ultimoId + 1;

        salvaUltimoId(nuovoId);

        return nuovoId;
    }

    private int leggiUltimoId() throws IOException {

        File file = new File(FILE_ID);

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String linea = reader.readLine();

            if (linea == null || linea.isBlank()) {
                return 0;
            }

            return Integer.parseInt(linea);
        }
    }

    private void salvaUltimoId(int id) throws IOException {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_ID))) {

            writer.write(String.valueOf(id));
        }
    }
}

