package Modelo;

public class Almacen {
    Libro[] libros;
    int contador = 0;
    int ritmoLectura = 1;

    //Método constructor
    public Almacen(int tamanio) {
        this.libros = new Libro[tamanio];
    }

    public void setRitmoLectura(int ritmo) {
        this.ritmoLectura = ritmo;
    }

    public void agregarLibro(Libro libro) {
        if (contador < libros.length) {
            libros[contador] = libro;
            contador++;
        } else {
            System.out.println("El almacén está lleno. No se pueden añadir más libros.");
        }
    }

    public void mostrarLibros() {

        int totalLength = 106;

        String lineaSeparacion = "|" + "-".repeat(totalLength) + "|";
        String inicial = String.format("| %-" + (totalLength-2) + "s |", "LIBROS EN EL ALMACÉN");

        System.out.println(lineaSeparacion);
        System.out.printf(inicial + "\n");
        System.out.println(lineaSeparacion);
        
        System.out.printf("| %-10s | %-15s | %-15s | %-14s | %-7s | %-15s | %-10s |\n", "Título", "Año Publicación", "Autor", "Premio Planeta", "Páginas", "Tiempo Lectura", "Precio");
        System.out.println(lineaSeparacion);

        for (int i = 0; i < contador; i++) {
            System.out.printf("| %-10s | %-15d | %-15s | %-14s | %-7d | %-15d | %-6.2f eur |\n", libros[i].getTitulo(),
                libros[i].getAnioPublicacion(),
                libros[i].getAutor().getNombreCompleto(),
                libros[i].getAutor().isPremioPlaneta() ? "Sí" : "No",
                libros[i].getNumeroPaginas(),
                libros[i].calcularTiempoLectura(ritmoLectura),
                libros[i].getPrecio()
            );
        }

        System.out.println(lineaSeparacion);
        System.out.println("| Tiempo de lectura total del almacén: " + calcularTiempoTotalLectura() + " min                                                             |");
        System.out.println("| Valor total del almacén: " + calcularValorTotal() + " eur                                                                       |");
        System.out.println(lineaSeparacion);
    }

    public int calcularTiempoTotalLectura() {
        int totalTiempo = 0;
        for (int i = 0; i < contador; i++) {
            totalTiempo += libros[i].calcularTiempoLectura(ritmoLectura);
        }
        return totalTiempo;
    }

    public double calcularValorTotal() {
        double totalValor = 0;
        for (int i = 0; i < contador; i++) {
            totalValor += libros[i].getPrecio();
        }
        return totalValor;
    }
}