package ejercicio1.padre;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EjecutaValidaArgumentos {
    ProcessBuilder pb;
    Process pb1;


    public EjecutaValidaArgumentos() {
        pb = new ProcessBuilder("java", "ejercicio1.hijo.ValidaArgumentos");
        File carpetaTrabajo = new File("build/classes/java/main");
        pb.directory(carpetaTrabajo);
        pb.inheritIO();
    }

    public EjecutaValidaArgumentos(String argumento) {
        pb = new ProcessBuilder("java", "ejercicio1.hijo.ValidaArgumentos", argumento);
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

    public int esperarHijo() {
        int codigoSalida;
        try {
            codigoSalida = pb1.waitFor();
        } catch (InterruptedException e) {
            System.out.println("ERROR, SE INTERRUMPIO LA ESPERA DEL PROCESO HIJO: " + e.getMessage());
            codigoSalida = 101; //error tratado más adelante
        }
        return codigoSalida;
    }

    public String traductorCodigoDeSalida(int codigoSalida) {
        String codigoSalidaString;
        switch (codigoSalida) {
            case 4 -> codigoSalidaString = "Valor de salida: 4\nNúmero mayor o igual que 0...";
            case 1 -> codigoSalidaString = "Valor de salida: 1\nNo hay argumentos...";
            case  2 -> codigoSalidaString = "Valor de salida: 2\nEs una cadena...";
            case 3 -> codigoSalidaString = "Valor de salida: 3\nNúmero menor que 0...";
            case 101 -> codigoSalidaString = "";
            default -> {
                System.out.println("ERROR AL RECIBIR EL CÓDIGO DE SALIDA EN EL MÉTODO traductorCodigoDeSalida()");
                codigoSalidaString = "";
            }
        }
        return codigoSalidaString;
    }

    //    public void escucharHijo() {
//        InputStream salida = pb1.getInputStream();
//        InputStreamReader lectorSalida = new InputStreamReader(salida);
//        BufferedReader bufferDeSalida = new BufferedReader(lectorSalida);
//        String linea;
//        try {
//            if (bufferDeSalida.readLine() != null) {
//                linea = bufferDeSalida.
//            }
//        } catch (IOException e) {
//            System.out.println("ERROR AL LEER EL BUFFER DE SALIDA DEL PROCESO HIJO: " + e.getMessage());
//        }
//    }
    public static void main() {
        String salida;
        String argumento;
        EjecutaValidaArgumentos padre;
        //como no decia el metodo para pasar el argumento lo he hecho por medio de lectura del teclado a traves de consola
        argumento = Entrada.cadena();
        //por las características de la librería entrada, no se puede usar simplemente (argumento == "")
        if (argumento.isEmpty()) {
             padre = new EjecutaValidaArgumentos();
        } else {
            padre = new EjecutaValidaArgumentos(argumento);
        }
        padre.IniciarProceso();
        salida = padre.traductorCodigoDeSalida(padre.esperarHijo());
        System.out.println(salida);
    }
}

