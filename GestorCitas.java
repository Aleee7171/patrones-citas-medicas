import java.util.List;

public class GestorCitas {

    private static GestorCitas instancia;

    private final CitaDAO citaDAO = new CitaDAO(); 
    private EstrategiaOrden estrategiaOrden = new OrdenPorFecha(); 

    private GestorCitas() {
    }

    public static GestorCitas getInstancia() {
        if (instancia == null) {
            instancia = new GestorCitas();
        }
        return instancia;
    }

    public void setEstrategiaOrden(EstrategiaOrden estrategia) {
        this.estrategiaOrden = estrategia;
    }

    public void crearCita(String paciente, String fecha) {
        Cita c = new Cita(paciente, fecha);
        citaDAO.guardar(c);
    }

    public void mostrarCitas() {
        List<Cita> citas = citaDAO.listar();
        if (citas.isEmpty()) {
            System.out.println("No hay citas.");
            return;
        }
        List<Cita> ordenadas = estrategiaOrden.ordenar(citas);
        System.out.println("\n--- CITAS ---");
        for (Cita c : ordenadas) {
            c.mostrar();
        }
    }
}
