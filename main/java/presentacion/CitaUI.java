package main.java.presentacion;

import main.java.datos.CitaDAOImpl;
import main.java.negocio.Cita;
import main.java.negocio.GestorCitas;
import main.java.negocio.OrdenPorFecha;
import main.java.negocio.OrdenPorPaciente;

import java.util.List;
import java.util.Scanner;

public class CitaUI {

    private final GestorCitas gestor;
    private final Scanner scanner;

    public CitaUI() {
        this.gestor = new GestorCitas(CitaDAOImpl.getInstancia());
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== CITAS MEDICAS ===");
            System.out.println("1. Crear cita");
            System.out.println("2. Ver citas por FECHA");
            System.out.println("3. Ver citas por PACIENTE");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    crearCita();
                    break;
                case "2":
                    gestor.setEstrategiaOrden(new OrdenPorFecha());
                    mostrarCitas();
                    break;
                case "3":
                    gestor.setEstrategiaOrden(new OrdenPorPaciente());
                    mostrarCitas();
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

        System.out.println("Fin.");
    }

    private void crearCita() {
        System.out.print("Nombre del paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        gestor.crearCita(paciente, fecha);
        System.out.println("Cita creada correctamente.");
    }

    private void mostrarCitas() {
        List<Cita> citas = gestor.obtenerCitasOrdenadas();

        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }

        System.out.println("\n--- LISTA DE CITAS ---");
        for (Cita c : citas) {
            c.mostrar();
        }
    }
}
