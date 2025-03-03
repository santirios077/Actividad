import java.util.Scanner;

public class CalculoMatricula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el promedio del alumno: ");
        double promedio = scanner.nextDouble();

        System.out.print("Ingrese el número de materias reprobadas: ");
        int materiasReprobadas = scanner.nextInt();

        System.out.print("Ingrese el tipo de estudiante (tecnología/profesional): ");
        String tipoEstudiante = scanner.next().toLowerCase();

        int creditos = 0;
        double descuento = 0;
        double costoPorCincoCreditos = tipoEstudiante.equals("tecnología") ? 18000 : 30000;

        if (tipoEstudiante.equals("tecnología")) {
            if (promedio >= 9.5) {
                creditos = 55;
                descuento = 0.25;
            } else if (promedio >= 9) {
                creditos = 50;
                descuento = 0.10;
            } else if (promedio > 7) {
                creditos = 50;
            } else {
                if (materiasReprobadas <= 3) {
                    creditos = 45;
                } else {
                    creditos = 40;
                }
            }
        } else if (tipoEstudiante.equals("profesional")) {
            creditos = 55;
            if (promedio >= 9.5) {
                descuento = 0.20;
            }
        } else {
            System.out.println("Tipo de estudiante no válido.");
            scanner.close();
            return;
        }

        double costoTotal = (creditos / 5) * costoPorCincoCreditos;
        double totalPagar = costoTotal - (costoTotal * descuento);


        System.out.println("Créditos asignados: " + creditos);
        System.out.println("Total a pagar después del descuento: $" + totalPagar);

        scanner.close();
    }
}
