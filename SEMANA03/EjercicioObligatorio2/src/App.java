import com.coti.tools.Esdia;
import datos.Persona;

public class App {
    public static void main(String[] args) throws Exception {

        Persona[] personas = new Persona[3];

        //Antes de dar valores a los atributos podemos ver que se han inicializado por defecto tal y como se ha establecido con el constructor
        personas[0] = new Persona();
        System.out.printf("La persona %s tiene un peso de %.2f kilos y mide %.2f\n", personas[0].getNombre(), personas[0].getPeso(), personas[0].getTalla());

        for (int i = 0; i < personas.length; i++) {
            personas[i] = new Persona();
            String promtNombre = String.format("Ingrese el nombre de la persona %d: \n", i+1);
            String nombre = Esdia.readString_ne(promtNombre);
            personas[i].setNombre(nombre);

            String promptPeso = String.format("Ingrese el peso de %s: \n", personas[i].getNombre());
            double peso = Esdia.readDouble(promptPeso);
            personas[i].setPeso(peso);

            String promptTalla = String.format("Ingree la talla de %s: \n", personas[i].getNombre());
            double talla = Esdia.readDouble(promptTalla);
            personas[i].setTalla(talla);
        }

        System.out.format("El más pesado es %s.\n", personas[Persona.masPesado(personas)].getNombre());
        System.out.format("El más alto es %s.\n", personas[Persona.masAlto(personas)].getNombre());
    }
}