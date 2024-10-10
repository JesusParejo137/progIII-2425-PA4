import com.coti.tools.Esdia;
import datos.Persona;

public class App {
    public static void main(String[] args) throws Exception {

        Persona[] personas = new Persona[3];

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