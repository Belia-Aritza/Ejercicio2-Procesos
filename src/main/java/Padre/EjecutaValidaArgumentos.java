package Padre;

import Hijo.ValidaArgumentos;

import java.io.InputStream;
import java.io.OutputStream;

public class EjecutaValidaArgumentos {
    String argumento;
    ProcessBuilder pb = new ProcessBuilder("java", "src/main/java/Hijo/ ValidaArgumentos.java", argumento);
//    Process pb1 = new Process()
    }
}
