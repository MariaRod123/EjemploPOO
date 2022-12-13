
public class Application {


    public static void main(String[] args) {
        int num_carriles=3;
        int kilometros=200;
        Juego juego= new Juego(num_carriles, kilometros, "Pista# URUGUAY");

        Carro rojo= new Carro(Carro.Color.ROJO, "ABC456");
        rojo.Agregar_conductor(new Conductor("C1", "PABLO","pablo@correo.com", "pab23"));

        Carro azul= new Carro(Carro.Color.AZUL, "HKH001");
        azul.Agregar_conductor(new Conductor("C2", "CHARLY","charly@correo.com", "charly25"));

        Carro verde= new Carro(Carro.Color.VERDE, "MTK189");
        verde.Agregar_conductor(new Conductor("C3", "TOBY","toby@correo.com", "toby"));

        Carro blanco= new Carro(Carro.Color.BLANCO, "TCR596");
        blanco.Agregar_conductor(new Conductor("C4", "AGUSTIN","agustin@correo.com", "agus"));


        Juego.AgregarCarroACarril(1, rojo);
        Juego.AgregarCarroACarril(2, azul);
        Juego.AgregarCarroACarril(3, verde);
        Juego.AgregarCarroACarril(4, blanco); //ver error

        Podio podio=juego.iniciar_juego();
        System.out.println(podio);

        
    }
}
