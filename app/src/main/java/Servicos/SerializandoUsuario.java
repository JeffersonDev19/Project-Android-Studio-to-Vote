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

public class SerializandoUsuario {

    public static void serializeToUsuario(final Usuario usuario) {
        final Gson gson = new Gson();

        // If we want to print the json formatted
        // final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Getting json as String
        final String json = gson.toJson(usuario);
        System.out.println(json);

        // Saving to a file
        try {
            final Writer writer = new FileWriter("../Jsons/usuario.json");
            gson.toJson(usuario, writer);
            writer.close();
        } catch (IOException e) {
            // Ooops, there's something wrong
            e.printStackTrace();
        }
    }

    public static Usuario deserializeToUsuario(final File jsonFile) {
        final Gson gson = new Gson();
        Usuario usuario = null;
        try {
            final Reader reader = new FileReader(jsonFile);
            usuario = gson.fromJson(reader, Usuario.class);
        } catch (FileNotFoundException e) {
            // Oooops
            e.printStackTrace();
        }
        return usuario;

    }
}