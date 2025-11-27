package main.java.negocio;


import main.java.datos.CitaDAO;

import java.util.List;

public class GestorCitas {

    private final CitaDAO citaDAO;
    private EstrategiaOrden estrategiaOrden;

    public GestorCitas(CitaDAO citaDAO) {
        this.citaDAO = citaDAO;
        this.estrategiaOrden = new OrdenPorFecha();
    }

    public void setEstrategiaOrden(EstrategiaOrden estrategiaOrden) {
        this.estrategiaOrden = estrategiaOrden;
    }

    public void crearCita(String paciente, String fecha) {
        Cita cita = new Cita(paciente, fecha);
        citaDAO.agregar(cita);
    }

    public List<Cita> obtenerCitasOrdenadas() {
        List<Cita> originales = citaDAO.listarTodas();
        return estrategiaOrden.ordenar(originales);
    }
}
