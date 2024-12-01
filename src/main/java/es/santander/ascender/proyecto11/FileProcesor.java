package es.santander.ascender.proyecto11;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileProcesor implements IFileProcesor{


    @Override
    public String leerFile(String filePath) throws Exception {
        // Tengo que devolver un String
        
        // Método readAllLines devuelve un tipo List<String>
        // Convertirlo en String para retornar el valor de salida del método.

        // Argumento de readAllLines es de tipo Path, => pasar el argumento recibido filePath a tipo Path
        Path camino = Path.of(filePath);

        // Files.readAllLines devuelve un tipo List<String>. Importamos paquete java.util.List;
        List<String> ficheroEnt = Files.readAllLines(camino);
        String salida = String.join("\n", ficheroEnt);
        return salida;
    }

    @Override
    public String eliminarVocales(String input) {
        // Recibimos una cadena String y devolvemos otra sin las vocales.
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
        
        // Crear archivo temporal de prueba
        // Del test: Path tempFile = Files.createTempFile("testEscribir", ".txt");
        Path ficheroTemp = Files.createTempFile("testEscribir", ".txt");

        // Escribir contenido en el archivo temporal
        // procesor.escribirAFile(tempFile.toString(), content);
        
        // Clase Files, método write con parámetros (Path, arreglo de bytes del contenido )
        // Antes transformar contenido pasado por parámetro a formato String, que es el que
        // requiere 'write'; (un arreglo de bytes). String tiene el método getBytes()
        
        Files.write(ficheroTemp, content.getBytes(),StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); // Si no existe lo crea y si existe lo sobreescribe

        // Leer el contenido del archivo temporal para verificar
        // String fileContent = Files.readString(tempFile);
        // Almacenamos el contenido del fichero en un String para verlo en depuración antes de finalmente ser borrado.
        // @SuppressWarnings("unused")
        String contenidoFichero = Files.readString(ficheroTemp);
        
        // Eliminar archivo temporal después de la prueba
        // Files.delete(tempFile);
        Files.delete(ficheroTemp);

//        throw new UnsupportedOperationException("Unimplemented method 'escribirAFile'");
    }
}
    /* POR MOTIVOS DIDÁCTICOS AÑADO ESTE TEXTO AL FINAL DEL CÓDIGO.

    JAVA 8 API
    java.nio.file.Files -> clase
    java.nio.file.Path (en singular) -> interfaz

    
    public static List<String> readAllLines(Path path)
                                    throws IOException

    Read all lines from a file. Bytes from the file are decoded into characters using the UTF-8 charset. 



    public static Path createTempFile(String prefix,
                                  String suffix,
                                  FileAttribute<?>... attrs)
                           throws IOException

    Creates an empty file in the default temporary-file directory, using the given prefix and suffix to 
    generate its name. The resulting Path is associated with the default FileSystem. 


    */