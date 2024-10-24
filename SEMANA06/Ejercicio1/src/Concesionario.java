import java.util.HashMap;
import java.util.Map;

import com.coti.tools.Esdia;

import static com.coti.tools.Esdia.*;

public class Concesionario {
    private static HashMap<String, Coche> coches = new HashMap<>();
    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = Esdia.readInt("Ingrese una opción: ");
            switch (opcion) {
                case 1:
                    añadirCoche();
                    break;
                case 2:
                    eliminarCoche();
                    break;
                case 3:
                    modificarCoche();
                    break;
                case 4:
                    mostrarCoches();
                    break;
                default:
                    break;
            }
        } while(opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("--- MENÚ CRUD ---");
        System.out.println("1. Añadir coche");
        System.out.println("2. Eliminar coche");
        System.out.println("3. Modificar coche");
        System.out.println("4. Listar coches");
        System.out.println("5. Salir");
    }
    public static void añadirCoche() {
        String modelo = Esdia.readString("Ingrese el modelo del coche: ");
        String color = Esdia.readString("Ingrese el color del coche: ");
        int anio = Esdia.readInt("Ingrese el año del coche: ");
        String matricula = Esdia.readString("Ingrese la matrícula del coche: ");

        //Instanciar nuevo elemento en el array "coches" declarado previamente
        Coche nuevoCoche = new Coche(modelo, color, anio);
        coches.put(matricula, nuevoCoche);
        System.out.println("Coche añadido exitosamente!");
    }
    public static void eliminarCoche() {
        String matricula = Esdia.readString("Ingrese la matrícula del coche a eliminar: ");

        if (coches.containsKey(matricula)) {
            coches.remove(matricula);
            System.out.println("Coche eliminado!");
        } else {
            System.out.println("No se ha encontrado ningún coche con esa matrícula");
        }
    }

    public static void modificarCoche() {
        String matricula = Esdia.readString("Ingrese la matrícula del coche a modificar: ");
        if (coches.containsKey(matricula)) {
            String nuevoModelo = Esdia.readString("Ingrese el nuevo modelo: ");
            String nuevoColor = Esdia.readString("Ingrese nuevo color: ");
            int anio = Esdia.readInt("Ingrese el nuevo año: ");

            Coche cocheModificado = new Coche(nuevoModelo, nuevoColor, anio);
            coches.put(matricula, cocheModificado);
            System.out.println("Coche modificado exitosamente!");
        } else {
            System.out.println("No se ha encontrado ningún coche con esa matrícula");
        }
    }
    
    public static void mostrarCoches() {
        if (coches.isEmpty()) {
            System.out.println("No hay coches en el concesionario.");
            return;
        } else {
            for (Map.Entry<String, Coche> entry : coches.entrySet()) {
                String matricula = entry.getKey();
                Coche value = entry.getValue();
                System.out.println(String.format("Matrícula: %9s - %s", matricula, value.toString()));
            }
        }
    }
}
