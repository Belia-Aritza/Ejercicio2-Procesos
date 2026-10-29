package ejercicio3.hijo;

public class Visualizador {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Cadena introducida vacia\n" + "Valor de salida: 1\n" + "Final Incorrecto");
            System.exit(1);
        } else {
            //no he hecho una comprabacion para ver si el segundo argumento está vacío porque en el enunciado no pone que hay que hacer en caso de que lo sea.
            int numeroDeVeces;
            int numeroDeVecesCopia;
            int numeroDeLinea = 1;
            numeroDeVeces = Integer.parseInt(args[1]);
            numeroDeVecesCopia = numeroDeVeces;
            while (numeroDeVecesCopia > 0) {
                System.out.println(numeroDeLinea + ". " + args[0]);
                numeroDeLinea++;
                numeroDeVecesCopia--;
            }
            System.out.println("Valor de salida: 0\n" +
                    "Final Correcto");
            System.exit(0);
        }
    }
}
