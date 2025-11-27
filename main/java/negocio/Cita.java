package main.java.negocio;

public class Cita {

    private final String paciente;
    private final String fecha; 

    public Cita(String paciente, String fecha) {
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void mostrar() {
        System.out.println(fecha + " - " + paciente);
    }
}
