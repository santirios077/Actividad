import java.util.Scanner;

public class Llantas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de llantas que deseas comprar: ");
        int cantLlantas = scanner.nextInt();
        double precioPorLlanta;
        if (cantLlantas < 5) {
            precioPorLlanta = 100;
        } else if (cantLlantas <= 10) {
            precioPorLlanta = 75;
        } else {
            precioPorLlanta = 50;
        }
        double totalPagar = cantLlantas * precioPorLlanta;
        System.out.println("Precio por llanta: $" + precioPorLlanta);
        System.out.println("Total a pagar: $" + totalPagar);
        scanner.close();
    }
}