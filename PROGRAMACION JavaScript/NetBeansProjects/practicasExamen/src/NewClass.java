import java.io.File;

public class NewClass {
    public static void main(String[] args) {
        // Especifica la ruta del directorio que deseas listar
        String rutaDirectorio = "C:\\EJERCICIOS\\UNI1\\ejemplo1.txt";

        // Crea un objeto File que representa el directorio
        File directorio = new File(rutaDirectorio);

        // Verifica si el directorio existe y es un directorio válido
        if (directorio.exists() && directorio.isDirectory()) {
            // Obtiene una lista de archivos en el directorio
            File[] archivos = directorio.listFiles();

            // Muestra la lista de archivos en el directorio
            System.out.println("Archivos en el directorio " + rutaDirectorio + ":");

            for (File archivo : archivos) {
                System.out.println(archivo.getName());
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio válido.");
        }
    }
}
