package main.java.datos;

import main.java.negocio.Cita;

import java.util.ArrayList;
import java.util.List;

public class CitaDAOImpl implements CitaDAO {

    // Singleton
    private static CitaDAOImpl instancia;

    private final List<Cita> citas;

    private CitaDAOImpl() {
        this.citas = new ArrayList<>();
    }

    public static CitaDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new CitaDAOImpl();
        }
        return instancia;
    }

    @Override
    public void agregar(Cita cita) {
        citas.add(cita);
    }

    @Override
    public List<Cita> listarTodas() {
        return new ArrayList<>(citas);
    }
}

