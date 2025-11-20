import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenPorPaciente implements EstrategiaOrden {

    @Override
    public List<Cita> ordenar(List<Cita> originales) {
        List<Cita> lista = new ArrayList<>(originales);
        lista.sort(Comparator.comparing(Cita::getPaciente));
        return lista;
    }
}
