

import java.io.*;
import java.nio.file.*;
import java.util.*;
  
 
public class ArchivoPractica {
   
    // Crear un archivo nuevo
    public static void crearDato(String nombreDato) {
        try {
            File dato = new File(nombreDato);
            if (dato.createNewFile()) {
                System.out.println("Dato creado: " + dato.getName());
            } else {
                System.out.println("El dato ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el dato: " + e.getMessage());
        }
    }

// Escribir (sobrescribir) líneas en el archivo
        public static void escribirArchivo(String nombreArchivo, String[] lineas) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String linea : lineas) {
                writer.write(linea + System.lineSeparator());
            }
            System.out.println("Archivo escrito exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
// Añadir líneas al final del archivo
    public static void anexarArchivo(String nombreArchivo, String[] lineas) {
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            for (String linea : lineas) {
                writer.write(linea + System.lineSeparator());
            }
            System.out.println("Contenido añadido al archivo exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al anexar al archivo: " + e.getMessage());
        }
    }
// Leer y mostrar el contenido del archivo
    public static void leerArchivo(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println(" CONTENIDO DEL ARCHIVO ");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println(" FIN DEL CONTENIDO ");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
   }

// Borrar el archivo
    public static void borrarArchivo(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.delete()) {
                System.out.println("Archivo eliminado: " + archivo.getName());
            } else {
                System.out.println("No se pudo eliminar el archivo (puede que no exista).");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el archivo: " + e.getMessage());
        }
    }
// Método main para probar las funciones
    public static void main(String[] args) {
        String nombreArchivo = "estudiantes.txt";
       
        System.out.println(" PRUEBA DE MANEJO DE ARCHIVOS ");
       
        //  Crear archivo
        System.out.println("\n1. Creando archivo...");
        crearDato(nombreArchivo);
       
        //  Escribir datos iniciales
        System.out.println("\n2. Escribiendo datos iniciales...");
        String[] datosIniciales = {
            "Juan Perez, 85",
            "Maria Garcia, 92",
            "Carlos Lopez, 78"
        };
        escribirArchivo(nombreArchivo, datosIniciales);
        leerArchivo(nombreArchivo);
       
        //  Anexar más datos
        System.out.println("\n3. Anexando mas estudiantes...");
        String[] nuevosDatos = {
            "Ana Martinez, 88",
            "Pedro Rodriguez, 95",
            "Laura Sanchez, 81"
        };
        anexarArchivo(nombreArchivo, nuevosDatos);
        leerArchivo(nombreArchivo);
       
        //  Anexar notas adicionales
        System.out.println("\n4. Anexando notas del segundo parcial...");
        String[] notasParcial2 = {
            " NOTAS SEGUNDO PARCIAL ",
            "Juan Perez, 90",
            "Maria Garcia, 94",
            "Carlos Lopez, 82",
            "Ana Martinez, 87",
            "Pedro Rodriguez, 98",
            "Laura Sanchez, 85"
        };
        anexarArchivo(nombreArchivo, notasParcial2);
        leerArchivo(nombreArchivo);
       
        //  Sobrescribir con datos actualizados
        System.out.println("\n5. Sobrescribiendo con promedios finales...");
        String[] promediosFinales = {
            " PROMEDIOS FINALES ",
            "Juan Perez: 87.5",
            "Maria Garcia: 93.0",
            "Carlos Lopez: 80.0",
            "Ana Martinez: 87.5",
            "Pedro Rodriguez: 96.5",
            "Laura Sanchez: 83.0"
        };
        escribirArchivo(nombreArchivo, promediosFinales);
        leerArchivo(nombreArchivo);
       
        //  Mostrar información del archivo
        System.out.println("\n6. Informacion del archivo:");
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            System.out.println("Nombre: " + archivo.getName());
        }
       
        //  Opción para borrar el archivo 
        System.out.println("\n7. ¿Desea borrar el archivo? (s/n)");
        Scanner entrada = new Scanner(System.in);
        String respuesta = entrada.nextLine().toLowerCase();
       
        if (respuesta.equals("s") || respuesta.equals("si")) {
            System.out.println("Borrando archivo...");
            borrarArchivo(nombreArchivo);
        } else {
            System.out.println("Archivo conservado: " + nombreArchivo);
        }
       
       
        System.out.println("\n PRUEBA COMPLETADA ");
}
}  

