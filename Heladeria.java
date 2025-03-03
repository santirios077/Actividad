import java.util.Scanner;

public class Heladeria {
    public static void main(String[] args) {
        int cantLimon = 0, cantNuez = 0, cantLulo = 0, cantFresa = 0, cantCrema = 0;
        Scanner sc = new Scanner(System.in);
        double ventaLimon = 0, ventaNuez = 0, ventaLulo = 0, VentaFresa = 0, VentaCrema = 0, VentaTotal = 0;
        boolean continua = true;

        while (continua) {
            boolean contvta = true;
            while (contvta) {
                System.out.println("Sabores");
                System.out.println("1-Limón");
                System.out.println("2- Nuez");
                System.out.println("3- Lulo");
                System.out.println("4- Fresa");
                System.out.println("5- Crema");
                int sabor = sc.nextInt();
                sc.nextLine();
                switch (sabor) {
                    case 1:
                        System.out.print("Cantidad vendida: ");
                        int cantFLimon = sc.nextInt();
                        sc.nextLine();
                        cantLimon = cantLimon + cantFLimon;
                        break;
                    case 2:
                        System.out.print("Cantidad vendida: ");
                        int cantFNuez = sc.nextInt();
                        sc.nextLine();
                        cantNuez = cantNuez + cantFNuez;
                        break;
                    case 3:
                        System.out.print("Cantidad vendida: ");
                        int cantFLulo = sc.nextInt();
                        sc.nextLine();
                        cantLulo = cantLulo + cantFLulo;
                        break;
                    case 4:
                        System.out.print("Cantidad vendida: ");
                        int cantFFresa = sc.nextInt();
                        sc.nextLine();
                        cantFresa = cantFresa + cantFFresa;
                        break;
                    case 5:
                        System.out.print("Cantidad vendida: ");
                        int cantFCrema = sc.nextInt();
                        sc.nextLine();
                        cantCrema = cantCrema + cantFCrema;
                        break;
                    default:
                        break;
                }
                System.out.println("Desea incluir otro sabor? (S/N)");
                String rta = sc.nextLine();
                if (rta.toUpperCase().equals("N")) {
                    contvta = false;
                }
            }
            System.out.println("Desea procesar otra factura? (S/N)");
            String rta = sc.next();
            if (rta.toUpperCase().equals("N")) {
                continua = false;
            }
            System.out.println("Sabor   Cantidad    valor");
            System.out.println("Limón   " + cantLimon + "    " + (cantLimon * 2500));
            System.out.println("Nuez   " + cantNuez + "    " + (cantNuez * 2500));
            System.out.println("Lulo   " + cantLulo + "    " + (cantLulo * 2500));
            System.out.println("Fresa   " + cantFresa + "    " + (cantFresa * 2000));
            System.out.println("Crema   " + cantCrema + "    " + (cantCrema * 3000));
            System.out.println("Ventas Totales=" + ((cantLimon * 2500) + (cantNuez * 2800) + (cantLulo * 2600)
                    + (cantFresa * 2000) + (cantCrema * 3000)));
        }
    }
}