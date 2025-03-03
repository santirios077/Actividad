import java.util.Scanner;

public class TiendaComputadoras {
    public static void main(String[] args) {
        final double PRECIO_COMPUTADORA = 500.0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("ingrese el número de computadoras: ");
        int numComputadoras = scanner.nextInt();
        double descuento = 0.0;
        if (numComputadoras < 5) {
            descuento = 0.10; // 10% de descuento
        } else if (numComputadoras >= 5 && numComputadoras < 10) {
            descuento = 0.20; // 20% de descuento
        } else if (numComputadoras >= 10) {
            descuento = 0.40; // 40% de descuento
        }
        // Calculamos el total sin descuento multiplicando el número de computadoras por
        // el precio unitario.
        double totalSinDescuento = numComputadoras * PRECIO_COMPUTADORA;
        double montoDescuento = totalSinDescuento * descuento;
        double totalConDescuento = totalSinDescuento - montoDescuento;
    }
}