import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;


public class Juego {
    private final Podio podio;
    private static  Pista pista;
    private Estado estado;

    public Juego (Integer num_carriles, Integer kilometros, String nomb_pista){
        Map<Integer, Carril> carriles=generarCarriles(num_carriles, kilometros);
        pista=new Pista(UUID.randomUUID().toString(), nomb_pista, carriles);
        this.podio = new Podio();
        estado=Estado.NO_INICIADO;
    }
    public static void AgregarCarroACarril(Integer carril, Carro carro){
        if(Objects.isNull(carro.conductor())){
            throw new IllegalArgumentException("El carro no tiene conductor");
        }
        pista.AgregarCarroACarril(carril, carro); 
    }

    public Podio iniciar_juego(){
        ValidarCarriles();
        iniciar_juego();
        do{
           estado=Estado.INICIADO;
           pista.carriles().forEach(moverEnCarril());
        }while (estado.equals(Estado.INICIADO));
        return podio;
    }


    private Map<Integer, Carril> generarCarriles(Integer num_carriles, Integer kilometros){
        Map<Integer, Carril>carriles=new HashMap<>();
        for (int i = 1; i <= num_carriles ; i++) {
            carriles.put(i, new Carril(i, kilometros));
        }return carriles;

    }


    private void fin_juego(){
        estado = Estado.FINALIZADO;
    }

    private void definirPodio(Carro carro){
        if(Objects.isNull(podio.primero())){
            podio.setPrimero(carro.conductor());
            carro.pararMarcha();
        }
        else if(Objects.isNull(podio.segundo())){
            podio.setSegundo(carro.conductor());
            carro.pararMarcha();
        }
        else if(Objects.isNull(podio.tercero())){
            podio.setTercero(carro.conductor());
            carro.pararMarcha();
            fin_juego();
        }
    }

    private void definirGanador(Carril carril, Carro carro){
        if(carro.marcha()){
            double progreso= carril.ProgresoCarro(carro.placa());
            if(progreso>=100){
                definirPodio(carro);
            }
        }

    }
    private void ValidarCarriles(){
        int cant_carros=0;
        for (Carril carril: pista.carriles().values()){
              cant_carros=carril.carros().size() + cant_carros;

        }if(cant_carros <= 2){
            throw new IllegalStateException("No hay la cantidad de carros suficeintes");

        }

    }


    private void iniciarCarros(){
        pista.carriles().values().forEach(carril -> carril.carros().forEach(Carro::iniciar));  //disponible para que arranque
    }

    public BiConsumer<Integer, Carril>moverEnCarril(){
        return (id, carril)->carril.carros().forEach(moverCarro(carril));
    }


    public Consumer<Carro> moverCarro(Carril carril) {
        return carro -> {
            int dado = carro.conductor().LanzarDado();
            IntStream.range(0, dado * 100).forEach(carro.AumentarMetros());
            definirGanador(carril, carro);
        };
    }

    public enum Estado {
        INICIADO, FINALIZADO, NO_INICIADO
    }

}
