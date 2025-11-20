import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenPorFecha implements EstrategiaOrden {

    @Override
    public List<Cita> ordenar(List<Cita> originales) {
        List<Cita> lista = new ArrayList<>(originales);
        lista.sort(Comparator.comparing(Cita::getFecha));
        return lista;
    }
}
