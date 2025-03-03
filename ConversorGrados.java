import java.util.Scanner;

public class ConversorGrados {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("ingresa los grados Celsius para poderlos convertir a Fahrenheit: ");
    double Celsius = scanner.nextDouble();
    double Fahrenheit = ((Celsius*9/5) + 32) ;
    System.out.print("La temperatura en Fahrenheit es: " + Fahrenheit + "°F" ); 
    scanner.close();
}
}
