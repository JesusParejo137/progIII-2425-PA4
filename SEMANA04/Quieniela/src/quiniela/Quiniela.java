package quiniela;

public class Quiniela {

    final int NUMERO_PARTIDOS = 15;
    private Partido[] partidos;

    //Método que instancia los elementos de la lista "partidos" creando un número por defecto de ellos
    public Quiniela() {
        this.partidos = new Partido[NUMERO_PARTIDOS];
    }
    //Igual que el anterior pero el número de partidos es proporcionado por el usuario
    public Quiniela(int numeroPartidos) {
        this.partidos = new Partido[numeroPartidos];
    }
    public int getNUMERO_PARTIDOS() {
        return NUMERO_PARTIDOS;
    }
    public Partido[] getPartidos() {
        return partidos;
    }
    public void mostrarQuiniela() {
        int totalLength = 49;
        String lineaSeparacion = "|" + "-".repeat(totalLength-2) + "|";
        System.out.println(lineaSeparacion);
        System.out.println("|" + " ".repeat((totalLength-5-5)/2) + "QUINIELA" + " ".repeat((totalLength-5-4)/2) + "|");
        System.out.println(lineaSeparacion);

        for (Partido partido : partidos) {
            //Imprimir cada línea del array
            System.out.println(partido.lineaPartidoQuiniela());
        }

        System.out.println(lineaSeparacion);
    }
}
