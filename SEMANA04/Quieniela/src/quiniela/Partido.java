package quiniela;

public class Partido {
    
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocales;
    private int golesVisitantes;

    //Método constructor con nombres de los equipos (omisible)
    /* 
    public Partido(String equipo1, String equipo2) {
        this.equipoLocal = equipo1;
        this.equipoVisitante = equipo2;
    }
    */

    //Método constructor con la información completa del partido
    public Partido(String equipo1, String equipo2, int goles1, int goles2) {
        this.equipoLocal = equipo1;
        this.equipoVisitante = equipo2;
        this.golesLocales = goles1;
        this.golesVisitantes = goles2;
    }

    public String getResultado() {
        //Si local gana, devuelve 1; si visitante gana, devuelve 2; si hay empate, devuelve X
        if (this.golesLocales > this.golesVisitantes) {
            return "1";
        } else if (this.golesLocales < this.golesVisitantes) {
            return "2";
        } else {
            return "X";
        }
    }

    //getters y setters
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocales() {
        return golesLocales;
    }

    public void setGolesLocales(int golesLocales) {
        this.golesLocales = golesLocales;
    }

    public int getGolesVisitantes() {
        return golesVisitantes;
    }

    public void setGolesVisitantes(int golesVisitantes) {
        this.golesVisitantes = golesVisitantes;
    }
    public String lineaPartidoQuiniela() {
        return String.format("| %-20s| %-20s| %-1s |", equipoLocal, equipoVisitante,getResultado());
    }

}
