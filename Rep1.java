import java.util.Scanner;

public class Rep1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int num = sc.nextInt();
        System.out.println("Solución con for");

        for (int i=1;i<=10;i++){
            System.out.println(num+"*"+i+"=" +(num*i));
        }
        System.out.println("Solución con while");

        int i=1;
        while (i<=10){
            System.out.println(num+"*"+i+"="+ (num+1));
            i++;
        }
        System.out.println(i);
    }

}
