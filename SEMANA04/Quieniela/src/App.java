import com.coti.tools.Esdia;

import quiniela.Partido;
import quiniela.Quiniela;

public class App {
    public static void main(String[] args) throws Exception {
        
        //crear quiniela: por defecto se creará con un array de "Partido" de longitud 15, pero si le pasamos un entero como argumento el array tendrá esa longitud
        Quiniela quiniela = new Quiniela(2);

        Partido[] partidos = quiniela.getPartidos();

        //Este ciclo instancia los partidos del array "partidos" con la información dada por el usuario
        for(int i = 0; i < partidos.length; i++) {
            String equipoLocal = Esdia.readString("Introduce el equipo local: ");
            String equipoVisitante = Esdia.readString("Introduce el equipo visitante: ");
            int golesLocales = Esdia.readInt("Introduce los goles del equipo local: ");
            int golesVisitantes = Esdia.readInt("Introduce los goles del equipo visitante: ");

            Partido partido = new Partido(equipoLocal, equipoVisitante, golesLocales, golesVisitantes);
            partidos[i] = partido;
        }

        quiniela.mostrarQuiniela();
    }
}
