import java.util.ArrayList;
import java.util.Iterator;

public class Concesionario {

    private static ArrayList<Coche> coches = new ArrayList<>();
    private int contador = 1;

    public Concesionario() {
        coches.add(new Coche(1, "Toyota", 2018));
        coches.add(new Coche(2, "Ford", 2020));
        coches.add(new Coche(3, "Honda", 2019));
    }

    public void agregarCoche(int id, String marca, int anio) {
        Coche coche = new Coche(id, marca, anio);
        coches.add(coche);
        System.out.println("Coche agregado exitosamente");
    }

    public void mostrarCoches() {
        if (contador == 0) {
            System.out.println("No hay coches en el concesionario");
        } else {
            for (Coche coche : coches) {
                System.out.println(coche.toString());
            }
        }
    }

    public void modificarCoche(int id, String nuevaMarca, int nuevoAnio, boolean nuevoDisponible) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                coche.setMarca(nuevaMarca);
                coche.setAnio(nuevoAnio);
                coche.setDisponible(nuevoDisponible);
                System.out.println("Coche modificado exitosamente");
                return;
            }
        }
        System.out.println("Coche no encontrado");
    }

    public void eliminarCoche(int id) {
        for (Coche coche : coches) {
            if (coche.getId() == id) {
                coches.remove(coche);
                System.out.println("Coche eliminado exitosamente");
                return;
            }
        }
        System.out.println("No se ha encontrado un coche con ese identificador en el concesionario");
    }

    public void eliminarMarca(String marca) {
        Iterator<Coche> iterator = coches.iterator();
        while (iterator.hasNext()) {
            Coche coche = iterator.next();
            if (coche.getMarca().equals(marca)) {
                iterator.remove();
                System.out.println("Se ha eliminado un coche");
            }
        }
    }
}
