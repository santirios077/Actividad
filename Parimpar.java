import java.util.Scanner;

public class Parimpar {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa un número: ");
    int num = scanner.nextInt();
    if (num%2 ==0) {
        System.out.print(num +(" es un número par"));
        
    }else{
        System.out.print(num + " es un número impar");
    }
    scanner.close();
}
}
