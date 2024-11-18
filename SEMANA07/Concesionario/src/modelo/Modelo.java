/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author alfonso
 */
public class Modelo {

    ArrayList<Coche> coches = new ArrayList<>();

    public void crearCoche(String matricula, String marca, String modelo, int anio, double precioSinIVA) {
        Coche coche = new Coche(modelo, marca, matricula, anio, precioSinIVA);
        coches.add(coche);
    }

    public ArrayList<Coche> leerCoches() {
        return coches;
    }

    public void actualizarCoche(String matricula, String matriculaNueva, String mar, String mod, int a, float p) {
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getMatricula().equals(matricula)) {
                if (!matriculaNueva.isBlank()) {
                    coches.get(i).setMatricula(matriculaNueva);
                } else if (!mar.isBlank()) {
                    coches.get(i).setMarca(mar);
                } else if (!mod.isBlank()) {
                    coches.get(i).setModelo(mod);
                }else if (p!=0) {
                    coches.get(i).setAnio(a);
                }else if (a!=0) {
                    coches.get(i).setPrecioConIVA(p);
                }

            }
        }

    }

}
