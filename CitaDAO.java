import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    private final List<Cita> citas = new ArrayList<>();

    public void guardar(Cita c) {
        citas.add(c);
    }

    public List<Cita> listar() {
        return new ArrayList<>(citas);
    }
}
