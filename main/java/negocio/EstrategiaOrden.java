package main.java.negocio;
import java.util.List;

public interface EstrategiaOrden {
    List<Cita> ordenar(List<Cita> originales);
}
