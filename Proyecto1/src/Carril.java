import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carril {
    private final Integer num;

    private final Integer kilometros;

    private List<Carro> carros;

   public Carril(Integer num, Integer kilometros){
       this.kilometros = Objects.requireNonNull(kilometros);
       this.carros= new ArrayList<>();
       this.num=Objects.requireNonNull(num);

       if(kilometros <= 0){
           throw new IllegalArgumentException("NO es un metro permitido");
       }


   }
   public void AgregarCarro(Carro carro){
       carros.add(carro);

   }

    public Integer kilometros() {
        return kilometros;
    }

    public Integer num() {
        return num;
    }

    public List<Carro>carros(){
       return carros;
   }


   public Double ProgresoCarro(String placa){
       for (Carro carro: this.carros) {
           if(carro.placa().equalsIgnoreCase(placa)){
               int metros=kilometros()*1000;
               return (100 * carro.metros())/metros;



           }
       }throw new IllegalArgumentException("No existe el carro");

   }




}

