import java.util.Random;
import java.util.Scanner;

public class Adivinadivinador {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    int numeroSecreto = random.nextInt(10) + 1;
    int intento;
    int intentosRealizados = 0;

    System.out.println("Bienvenidx al juego Adivina Adivinador!!!");
    System.out.println("Estoy pensando en un número entre el 1 y el 10. ¿Puedes adivinarlo?");
    do{
        System.out.print("Ingresa tu número: ");
        intento = scanner.nextInt();
        intentosRealizados++;

        if (intento > numeroSecreto) {
            System.out.println("El número es menor, sigue intentandolo. ");
        }else if (intento < numeroSecreto) {
            System.out.println("El número es mayor, sigue intentandolo. ");
        }else {
            System.out.println("¡Felicidades! Adivinaste el número " + intentosRealizados + " intenos.");
        }
    } while (intento != numeroSecreto);
    scanner.close();
}
}
