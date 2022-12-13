import java.util.Objects;
import java.util.function.IntConsumer;

public class Carro {
// modelamiento de objetos para la clase Carro
    private final Color color;
    private final String placa;
    private Conductor conductor;
    private Integer metros;
    private boolean marcha;


    public Carro(Color color, String placa, Integer metros) {
        this.color =Objects.requireNonNull(color);  //para validar, el campo no debe ser nulo
        this.placa =Objects.requireNonNull(placa);
        this.metros=Objects.requireNonNull(metros);
        this.marcha=false;

        if(metros < 0){
            throw new IllegalArgumentException("No pueden ser negativo los metrajes");
        }
    }

    //sobrecarga de método carro
    public Carro(Color color, String placa) {
        this.color = color;
        this.placa = placa;
        this.metros= 0;
    }


    public void Agregar_conductor(Conductor conductor){
        this.conductor= Objects.requireNonNull(conductor);

    }

    public void iniciar(){
        this.marcha=true;
    }

    public IntConsumer AumentarMetros(){
        if(this.marcha){
        this.metros= metros + 1;}

        return null;
    }

    public double kilometros(){
        return Math.ceil((double) metros)/1000;

    }

    public void pararMarcha(){
        this.marcha=false;

    }

    public double metros(){
        return metros;

    }

    public Conductor conductor() {
        return conductor;
    }

    public Color color(){
        return color;
    }


    public String placa() {
        return placa;
    }

    public boolean marcha(){
        return marcha;
    }


    public enum Color {
        ROJO, AZUL, VERDE, BLANCO


    }

    @Override
    public String toString() {
        return "Carro{" +
                "color=" + color +
                ", placa='" + placa + '\'' +
                ", conductor=" + conductor +
                ", metros=" + metros +
                ", marcha=" + marcha +
                '}';
    }
}
