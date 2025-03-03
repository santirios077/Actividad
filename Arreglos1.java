import java.util.Scanner;

public class Arreglos1 {
    public static void main(String[] args) {
        int a[] = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Llenando el arreglo...");
        // llenar el arreglo
        for (int i = 0; i < a.length; i++) {
            System.out.print("ingrese el dato" + (i + 1) + ": ");
            // a[i]=sc.nextInt();
            a[i] = (int) (Math.random() * 30 + 1);
        }
        System.out.println("Contenido del arreglo..");
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k]);
        }
    }
}
