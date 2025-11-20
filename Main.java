import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorCitas gestor = GestorCitas.getInstancia(); // Singleton

        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== CITAS MEDICAS ===");
            System.out.println("1. Crear cita");
            System.out.println("2. Ver citas por FECHA");
            System.out.println("3. Ver citas por PACIENTE");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");

            String op = sc.nextLine();

            switch (op) {
                case "1": {
                    System.out.print("Paciente: ");
                    String paciente = sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD HH:MM): ");
                    String fecha = sc.nextLine();
                    gestor.crearCita(paciente, fecha);
                    System.out.println("Cita registrada.");
                    break;
                }
                case "2": {
                    gestor.setEstrategiaOrden(new OrdenPorFecha()); // Strategy
                    gestor.mostrarCitas();
                    break;
                }
                case "3": {
                    gestor.setEstrategiaOrden(new OrdenPorPaciente()); // Strategy
                    gestor.mostrarCitas();
                    break;
                }
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        System.out.println("Fin.");
    }
}
