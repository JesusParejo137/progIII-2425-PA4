/*
 * Programación III - Grado en Ingeniería de Sistemas (Univ. Salamanca)
 * Copyright (C) Dr. J.R. García-Bermejo Giner
 */
package minisorttest;

/**
 *
 * @author pieter
 */
public class Persona implements Comparable<Persona> {

    String nombre;
    int edad;
    float talla;

    // Automatico
    public Persona(String nombre, int edad, float talla) {
        this.nombre = nombre;
        this.edad = edad;
        this.talla = talla;
    }

    // Automático
    @Override
    public String toString() {
        return "\nPersona"
                + "{" 
                + "nombre=" + nombre 
                + ", edad=" + edad 
                + ", talla=" + talla 
                + "}";
    }

    // Implementación de Comparable<Persona>.
    // Ventaja:permite ordenar arrays o colecciones de personas
    // Inconveniente: es fijo y requiere tener acceso al codigo fuente de Persona
    //
    @Override
    public int compareTo(Persona per) {
        return this.nombre.compareTo(per.getNombre());
        //return Integer.compare(this.edad, per.getEdad());
    }

// Getters generados automáticamente

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getTalla() {
        return talla;
    }
  

}
