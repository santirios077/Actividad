package POO;

import java.io.*;
import java.util.*;

interface IPlantilla {
    void anadirJugador(Jugador jugador) throws Exception;

    void eliminarJugador(int dorsal);

    Jugador buscarJugador(int dorsal);

    void listarPorTipo(String tipo);

    void guardarEnArchivo(String nombreArchivo) throws IOException;

    void cargarDesdeArchivo(String nombreArchivo) throws IOException, ClassNotFoundException;
}

abstract class Jugador implements Serializable {
    protected String nombre;
    protected int dorsal;
    protected int edad;

    public Jugador(String nombre, int dorsal, int edad) throws DorsalInvalidoException {
        if (dorsal < 0 || dorsal > 24)
            throw new DorsalInvalidoException("Dorsal fuera de rango");
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public abstract String getTipo();

    public String toString() {
        return getTipo() + " - Nombre: " + nombre + ", Dorsal: " + dorsal + ", Edad: " + edad;
    }
}

class JugadorSenior extends Jugador {
    private double salario;

    public JugadorSenior(String nombre, int dorsal, int edad, double salario) throws DorsalInvalidoException {
        super(nombre, dorsal, edad);
        if (edad < 18)
            throw new IllegalArgumentException("Un senior debe tener al menos 18 años");
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public String getTipo() {
        return "Senior";
    }
}

class JugadorJunior extends Jugador {
    private int antiguedad;

    public JugadorJunior(String nombre, int dorsal, int edad, int antiguedad) throws DorsalInvalidoException {
        super(nombre, dorsal, edad);
        this.antiguedad = antiguedad;
    }

    public String getTipo() {
        return "Junior";
    }
}

class JugadorAlevin extends JugadorJunior {
    private String nacionalidad;

    public JugadorAlevin(String nombre, int dorsal, int edad, int antiguedad, String nacionalidad)
            throws DorsalInvalidoException {
        super(nombre, dorsal, edad, antiguedad);
        if (edad < 16)
            throw new IllegalArgumentException("Alevin debe tener al menos 16 años");
        this.nacionalidad = nacionalidad;
    }

    public String getTipo() {
        return "Alevin";
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}

class DorsalInvalidoException extends Exception {
    public DorsalInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class Plantilla implements IPlantilla {
    private List<Jugador> jugadores = new ArrayList<>();

    public void anadirJugador(Jugador jugador) throws Exception {
        if (jugadores.size() >= 24)
            throw new Exception("Plantilla llena");
        for (Jugador j : jugadores)
            if (j.getDorsal() == jugador.getDorsal())
                throw new Exception("Dorsal repetido");

        if (jugador instanceof JugadorJunior && !(jugador instanceof JugadorAlevin)) {
            long count = jugadores.stream().filter(j -> j instanceof JugadorJunior && !(j instanceof JugadorAlevin))
                    .count();
            if (count >= 5)
                throw new Exception("Máximo de juniors alcanzado");
            }
        if (jugador instanceof JugadorAlevin) {
            long count = jugadores.stream().filter(j -> j instanceof JugadorAlevin).count();
            if (count >= 2)
                throw new Exception("Máximo de alevines alcanzado");
        }
        jugadores.add(jugador);
        validarCondicionesEspeciales();
    }

    private void validarCondicionesEspeciales() throws Exception {
        long alevines = jugadores.stream().filter(j -> j instanceof JugadorAlevin).count();
        long alevinesEsp = jugadores.stream().filter(
                j -> j instanceof JugadorAlevin && ((JugadorAlevin) j).getNacionalidad().equalsIgnoreCase("español"))
                .count();
        if (alevines == 2 && alevinesEsp == 0)
            throw new Exception("Debe haber al menos un alevin español");

        double maxSalario = jugadores.stream().filter(j -> j instanceof JugadorSenior)
                .mapToDouble(j -> ((JugadorSenior) j).getSalario()).max().orElse(0);
        double masaSalarial = jugadores.stream().filter(j -> j instanceof JugadorSenior)
                .mapToDouble(j -> ((JugadorSenior) j).getSalario()).sum();        
        if (maxSalario > 0 && masaSalarial > maxSalario * 10)
            throw new Exception("Masa salarial excedida");
    }

    public void eliminarJugador(int dorsal) {
        jugadores.removeIf(j -> j.getDorsal() == dorsal);
    }

    public Jugador buscarJugador(int dorsal) {
        return jugadores.stream().filter(j -> j.getDorsal() == dorsal).findFirst().orElse(null);
    }

    public void listarPorTipo(String tipo) {
        jugadores.stream().filter(j -> j.getTipo().equalsIgnoreCase(tipo)).forEach(System.out::println);
    }

    public void guardarEnArchivo(String nombreArchivo) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
        out.writeObject(jugadores);
        out.close();
    }

    public void cargarDesdeArchivo(String nombreArchivo) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo));
        jugadores = (List<Jugador>) in.readObject();
        in.close();
    }
}

public class Inicio {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Plantilla plantilla = new Plantilla();
        int opcion;

        do {
            System.out.println(
                    "\n1. Añadir jugador\n2. Eliminar jugador\n3. Buscar jugador\n4. Listar por tipo\n5. Guardar\n6. Cargar\n0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.println("Tipo (senior/junior/alevin):");
                String tipo = sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Dorsal: ");
                int dorsal = sc.nextInt();
                System.out.print("Edad: ");
                int edad = sc.nextInt();

                if (tipo.equalsIgnoreCase("senior")) {
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    plantilla.anadirJugador(new JugadorSenior(nombre, dorsal, edad, salario));
                } else if (tipo.equalsIgnoreCase("junior")) {
                    System.out.print("Antiguedad: ");
                    int ant = sc.nextInt();
                    plantilla.anadirJugador(new JugadorJunior(nombre, dorsal, edad, ant));
                } else if (tipo.equalsIgnoreCase("alevin")) {
                    System.out.print("Antiguedad: ");
                    int ant = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nacionalidad: ");
                    String nac = sc.nextLine();
                    plantilla.anadirJugador(new JugadorAlevin(nombre, dorsal, edad, ant, nac));
                }
            } else if (opcion == 2) {
                System.out.print("Dorsal a eliminar: ");
                plantilla.eliminarJugador(sc.nextInt());
            } else if (opcion == 3) {
                System.out.print("Dorsal a buscar: ");
                Jugador j = plantilla.buscarJugador(sc.nextInt());
                System.out.println(j != null ? j : "No encontrado");
            } else if (opcion == 4) {
                System.out.print("Tipo a listar: ");
                plantilla.listarPorTipo(sc.nextLine());
            } else if (opcion == 5) {
                plantilla.guardarEnArchivo("plantilla.dat");
            } else if (opcion == 6) {
                plantilla.cargarDesdeArchivo("plantilla.dat");
            }
        } while (opcion != 0);
    }
}