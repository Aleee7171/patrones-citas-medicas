package main.java.negocio;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenPorFecha implements EstrategiaOrden {

    @Override
    public List<Cita> ordenar(List<Cita> originales) {
        List<Cita> copia = new ArrayList<>(originales);
        copia.sort(Comparator.comparing(Cita::getFecha));
        return copia;
    }
}
