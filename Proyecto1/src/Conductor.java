import java.util.Random;

public class Conductor extends Jugador {

    private final String id;
    private String nombre;

    public Conductor(String id, String nombre, String email, String nomb_usuario){
        super (id, email, nomb_usuario);
        this.id = id;
        this.nombre= nombre;

    }


    public int LanzarDado(){
        Random r= new Random();
        return r.nextInt(6)+1;

    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String nombre(){
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}





