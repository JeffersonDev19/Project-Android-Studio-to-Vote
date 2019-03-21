package Servicos;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import Objeto.Usuario;
import Objeto.Voto;

public class SerializandoVoto {

    public static void serializeToUsuario(final Voto voto) {
        final Gson gson = new Gson();

        // If we want to print the json formatted
        // final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Getting json as String
        final String json = gson.toJson(voto);
        System.out.println(json);

        // Saving to a file
        try {
            final Writer writer = new FileWriter("../Jsons/voto.json");
            gson.toJson(voto, writer);
            writer.close();
        } catch (IOException e) {
            // Ooops, there's something wrong
            e.printStackTrace();
        }
    }

    public static Voto deserializeToUsuario(final File jsonFile) {
        final Gson gson = new Gson();
        Voto voto = null;
        try {
            final Reader reader = new FileReader(jsonFile);
            voto = gson.fromJson(reader, Voto.class);
        } catch (FileNotFoundException e) {
            // Oooops
            e.printStackTrace();
        }
        return voto;

    }
}