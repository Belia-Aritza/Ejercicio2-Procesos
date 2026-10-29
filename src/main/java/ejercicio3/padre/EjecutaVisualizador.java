package ejercicio3.padre;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.io.IOException;

public class EjecutaVisualizador {
    ProcessBuilder pb;
    Process pb1;

    public EjecutaVisualizador() {
        pb = new ProcessBuilder("java", "ejercicio3.hijo.Visualizador");
        File carpetaTrabajo = new File("build/classes/java/main");
        pb.directory(carpetaTrabajo);
        pb.inheritIO();
    }

    public EjecutaVisualizador(String primerArgumento, String segundoArgumento) {
        pb = new ProcessBuilder("java", "ejercicio3.hijo.Visualizador", primerArgumento, segundoArgumento);
        File carpetaTrabajo = new File("build/classes/java/main");
        pb.directory(carpetaTrabajo);
        pb.inheritIO();
    }

    public void IniciarProceso() {
        try {
            pb1 = pb.start();
        } catch (IOException e) {
            System.out.println("ERROR AL INICIAR EL PROCESO: " + e.getMessage());
        }
    }

    public static void main() {
        EjecutaVisualizador padre;

        String primerArgumento;
        String segundoArgumento;

        System.out.print("Escribe una palabra(cadena) o dejalo vacio: ");
        primerArgumento = Entrada.cadena();


        //En el segundo caso el programa no contempla que este vacío el parametro 2 asi que lanza un error y pone porque es.
        if (primerArgumento.isEmpty()) {
            padre = new EjecutaVisualizador();
        } else {
            System.out.print("Escribe un numero(entero): ");
            segundoArgumento = Entrada.cadena();
            if (segundoArgumento.isEmpty()) {
                throw new IllegalArgumentException ("ERROR EL SEGUNDO ARGUMENTO NO ES ENTERO O ESTA VACÍO.");
            }
            padre = new EjecutaVisualizador(primerArgumento, segundoArgumento);
        }
        padre.IniciarProceso();
    }
}
