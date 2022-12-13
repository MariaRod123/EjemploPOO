import java.util.Map;

public class Pista {

    private final String id;
    private Map<Integer, Carril> carriles;
    private String nomb_pista;


    public Pista(String id, String nomb_pista, Map<Integer, Carril> carriles){
        this.id=id;
        this.nomb_pista=nomb_pista;
        this.carriles=carriles;

    }
    public void CambiarNombPista(String nomb_pista){
        this.nomb_pista=nomb_pista;

    }

    public String id() {
        return id;
    }


    public String nomb_pista() {
        return nomb_pista;
    }

    public Map<Integer, Carril> carriles() {
        return carriles;
    }


    public void AgregarCarroACarril(Integer num_carril, Carro carro){
        carriles.get(num_carril).AgregarCarro(carro);

    }
}


