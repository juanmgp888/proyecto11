package es.santander.ascender.proyecto11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcesor implements IFileProcesor{

    @Override
    public String leerFile(String filePath) throws Exception {

        Path camino = Paths.get(filePath);     //Path.of(filePath); Java 11+

        List<String> ficheroEnt = Files.readAllLines(camino);
        String salida = String.join("\n", ficheroEnt);
        return salida;
    }

    @Override
    public String eliminarVocales(String input) {

        String sinVocales="";
        for (int i=0;i<input.length();i++){
            switch (input.charAt(i)){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                   break;
                default:
                    sinVocales +=input.charAt(i);
            }
        }
        return sinVocales;
    }

    @Override
    public void escribirAFile(String filePath, String content) throws Exception {

        Path ficheroTemp = Paths.get(filePath);     //Path.of(filePath); Java 11+

        try {
        Files.write(ficheroTemp, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
          } catch (IOException e) {
        throw new Exception("Error escribiendo el archivo: " + e.getMessage(), e);
          }  

        Files.readString(ficheroTemp);
    }
}    