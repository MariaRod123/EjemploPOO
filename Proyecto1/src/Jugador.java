import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private final String id_jugador;
    private String email;
    private List<Integer> puntos;
    private final String nomb_usuario;


    public Jugador(String id_jugador, String email, String nomb_usuario){
        this.id_jugador=id_jugador;
        this.email= email;
        this.puntos = new ArrayList<>();
        this.nomb_usuario = nomb_usuario;

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void AgregarPuntos(Integer punto) {
        this.puntos.add(punto);
    }

    public Integer puntos() {
        return puntos.stream().reduce(Integer::sum).orElseThrow();
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id_jugador='" + id_jugador + '\'' +
                ", email='" + email + '\'' +
                ", puntos=" + puntos +
                ", nomb_usuario='" + nomb_usuario + '\'' +
                '}';
    }
}
