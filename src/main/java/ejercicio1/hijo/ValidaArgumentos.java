package ejercicio1.hijo;

public class ValidaArgumentos {
    public static void main(String[] args) {
        //Comprueba que haya mínimo 1 argumento si no lanza el código 1
        if (args.length > 0) {
            try {
                //Transforma el argumento a entero, si no se transforma y da error lo toma como una cadena, si es cadena lanza el código 2
                int entero = Integer.parseInt(args[0]); //Solo miro el primer argumento, el enunciado no dice nada sobre ello, además solo miro enteros, de los float no dice nada el enunciado
                //Si es negativo lanza el código 3 y si es positivo lanza el código 4
                if (entero >= 0) {
                    System.exit(4);
                } else {
                    System.exit(3);
                }
            } catch (NumberFormatException e) {
                System.exit(2);
            }
        } else {
            System.exit(1);
        }
    }
}