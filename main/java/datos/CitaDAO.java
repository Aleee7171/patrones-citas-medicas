package main.java.datos;

import main.java.negocio.Cita;
import java.util.List;

public interface CitaDAO {
    void agregar(Cita cita);
    List<Cita> listarTodas();
}
