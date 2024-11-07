package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class QuinielaModel {

    private ArrayList<Partido> partidos;

    public QuinielaModel() {
        this.partidos = new ArrayList<>();
    }

    public int cargarPartidos(Path archivoPartidos) throws Exception {
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(archivoPartidos, StandardCharsets.UTF_8);
            for (String linea : lineas) {
                String[] equipo = linea.split("-");
                Partido p = new Partido(equipo[0],equipo[1]);
                this.partidos.add(p);
            }
        } catch (IOException e) {
            throw new Exception();
            // return -1; ...y no nos complicamos más
        }

        return this.partidos.size();

    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

}
