import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Clase Scanner para que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabraSecreta = "pollo";
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglo para letras adivinadas
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Inicializa el arreglo con guiones bajos
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Estructura de control iterativa
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas)+"("+palabraSecreta.length()+" letras)");
            System.out.println("Introduce una letra, por favor: ");

            // Lee la letra ingresada y la convierte a minúscula
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            // Verifica si la letra está en la palabra secreta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("Incorrecto, te quedan " + (intentosMaximos - intentos) + " intentos");
            }

            // Verifica si se ha adivinado toda la palabra
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        // Si el jugador no adivinó, muestra un mensaje
        if (!palabraAdivinada) {
            System.out.println("Perdiste. La palabra secreta era: " + palabraSecreta);
        }

        // Cierra el Scanner fuera del bucle
        scanner.close();
    }
}
