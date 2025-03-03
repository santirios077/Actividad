//SANTIAGO RIOS MANRIQUE 20242227989 - SANTIAGO SOLORZANO SANCHEZ 20242228127
import java.util.Scanner;

public class ParqueaderoCamiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] camiones = new double[100][5];

        for (int i = 0; i < 100; i++) {
            System.out.println("Ingrese los datos del camión " + (i + 1) + " (Ingrese -1 para terminar):");

            System.out.print("Tipo de servicio (1 = Descarga, 2 = Carga): ");
            double tipoServicio = scanner.nextDouble();
            if (tipoServicio == -1)
                break;

            System.out.print("Tipo de producto (1 = Perecedero, 2 = No perecedero): ");
            double tipoProducto = scanner.nextDouble();

            System.out.print("Peso transportado en toneladas: ");
            double pesoTransportado = scanner.nextDouble();

            System.out.print("Tiempo de permanencia en horas: ");
            double tiempoPermanencia = scanner.nextDouble();

            System.out.print("Largo del camión en metros: ");
            double largoCamion = scanner.nextDouble();

            double costoParqueadero = 0;
            calcularCostoParqueadero(tipoServicio, tiempoPermanencia, largoCamion, costoParqueadero);

            camiones[i][0] = tipoServicio;
            camiones[i][1] = tipoProducto;
            camiones[i][2] = pesoTransportado;
            camiones[i][3] = tiempoPermanencia;
            camiones[i][4] = costoParqueadero;
        }

        System.out.println("Resumen de costos de parqueadero:");
        for (int i = 0; i < 100; i++) {
            if (camiones[i][0] == 0)
                break;
            System.out.println("Camión " + (i + 1) + ": Costo Parqueadero = " + camiones[i][4]);
        }
        scanner.close();
    }

    public static void calcularCostoParqueadero(double tipoServicio, double tiempo, double largo, double costo) {
        if (tipoServicio == 2) {
            if (tiempo > 3) {
                costo = (tiempo - 3) * 4000;
                if (largo > 4) {
                    costo *= 1.25;
                }
            }
        } else {
            costo = 0;
        }
    }
}