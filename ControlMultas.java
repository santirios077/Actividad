import java.util.ArrayList;
import java.util.Scanner;

class Infraccion {
    String placa;
    int cuadrante;
    int limiteVelocidad;
    int velocidadReal;

    public Infraccion(String placa, int cuadrante, int limiteVelocidad, int velocidadReal) {
        this.placa = placa;
        this.cuadrante = cuadrante;
        this.limiteVelocidad = limiteVelocidad;
        this.velocidadReal = velocidadReal;
    }

    public int calcularMulta() {
        int exceso = velocidadReal - limiteVelocidad;
        if (exceso > 0) {
            return 500000 + (exceso * 20000);
        } else {
            return 0;
        }
    }

    public void mostrarInfo() {
        int multa = calcularMulta();
        if (multa > 0) {
            System.out.println("Vehículo con placa " + placa + " registró una velocidad de " + velocidadReal
                    + " km/h en una zona de " + limiteVelocidad + " km/h.");
            System.out.println("Multa calculada: $" + multa);
        } else {
            System.out.println("Vehículo con placa " + placa + " no excedió el límite de velocidad.");
        }
        System.out.println("------------------------------------------------------");
    }
}

public class ControlMultas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Infraccion> infracciones = new ArrayList<>();

        System.out.print("Ingrese la cantidad de infracciones registradas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese los datos de la infracción " + (i + 1) + ":");
            System.out.print("Placa del vehículo: ");
            String placa = scanner.nextLine();

            System.out.print("Cuadrante (1-4): ");
            int cuadrante = scanner.nextInt();

            System.out.print("Límite de velocidad (km/h): ");
            int limiteVelocidad = scanner.nextInt();

            System.out.print("Velocidad registrada (km/h): ");
            int velocidadReal = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            infracciones.add(new Infraccion(placa, cuadrante, limiteVelocidad, velocidadReal));
        }

        System.out.println("\nINFORME DE MULTAS DE VELOCIDAD:");
        System.out.println("------------------------------------------------------");
        for (Infraccion infraccion : infracciones) {
            infraccion.mostrarInfo();
        }

        scanner.close();
    }
}