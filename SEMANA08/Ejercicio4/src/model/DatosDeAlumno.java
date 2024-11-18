package model;
import java.util.ArrayList;
import java.util.List;

public class DatosDeAlumno {
    private DatosPersonales datosPersonales;
    private Direccion direccion;

    public DatosDeAlumno(DatosPersonales datosPersonales, Direccion direccion) {
        this.datosPersonales = datosPersonales;
        this.direccion = direccion;
    }

    public static List<DatosDeAlumno> generarLista(int cantidad) {
        List<DatosDeAlumno> lista = new ArrayList<>();
        List<String> nifExistentes = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            DatosPersonales dp = DatosPersonales.generarAleatorio(nifExistentes);
            Direccion dir = Direccion.generarAleatoria();
            lista.add(new DatosDeAlumno(dp, dir));
        }
        return lista;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Datos personales: " + datosPersonales + ", Dirección: " + direccion;
    }
}