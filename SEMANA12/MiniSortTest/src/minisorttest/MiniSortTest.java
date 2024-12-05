/*
 * Programación III - Grado en Ingeniería de Sistemas (Univ. Salamanca)
 * Copyright (C) Dr. J.R. García-Bermejo Giner
 */
package minisorttest;

import static com.coti.tools.Esdia.underline2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author pieter
 */
public class MiniSortTest {

    public void sortConUnArgumento() {
        underline2("Uso de Arrays.sort() y Collections.sort() con un solo argumento");
        //
        // Método sort con dos argumentos.
        //
        // Se declara un array de cadenas
        String[] array = {"Oseas", "Joel", "Amos", "Abdias", "Jonas", "Miqueas"};
        // Se muestra array antes de ordenar
        System.out.printf("Array sin ordenar                 : %s%n", 
                Arrays.toString(array));
        
        // Se ordena array
        Arrays.sort(array);
        // Se muestra array después de ordenar
        System.out.printf("Array después de ordenar          : %s%n", 
                Arrays.toString(array));
        
        // Se ordena array al reves (requiere dos argumentos, usa el compareTo() de la clase)
        Arrays.sort(array, Comparator.reverseOrder());
        // Se muestra array después de ordenar al revés
        System.out.printf("Array después de ordenar al reves : %s%n", 
                Arrays.toString(array));
       
        // Se declara un array de Personas
        Persona[] arrayDePersonas = {new Persona("Numbre", 22, 1.60f),
            new Persona("Nimbre", 21, 1.50f),
            new Persona("Nambre", 19, 1.59f)
        };
        // Se crea un ArrayList de igual contenido
        List<Persona> coleccionDePersonas = Arrays.asList(arrayDePersonas);
        // Se muestra el ArrayList sin ordenar
        System.out.printf("Coleccion de personas sin ordenar                         :%n%s%n%n",
                coleccionDePersonas);
        // Se ordena el ArrayList (un solo argumento, se usa el compareTo() 
        // Persona luego solo ordenamos por edad
        Collections.sort(coleccionDePersonas);
        // Se muestra el ArrayList de Personas ya ordenado (insistimos, por edad nada mas)
        System.out.printf("Coleccion de personas después de ordenar por edad         :%n%s%n%n",
                coleccionDePersonas);
        // Ahora se ordena la lista de personas por orden descendente de edades, requiere dos argumentos
        Collections.sort(coleccionDePersonas, Comparator.reverseOrder());
        System.out.printf("Coleccion de personas después de ordenar por edad al revés:%n%s%n%n", 
                coleccionDePersonas);

    } // End of method con un argumento
    public void sortArraysConDosArgumentos() {
        underline2("Uso de Arrays.sort() con dos argumentos");
        //
        // Método sort con dos argumentos.
        //
        Persona[] arrayDePersonas = {new Persona("Numbre", 22, 1.60f),
            new Persona("Nambre", 21, 1.50f),
            new Persona("Nambre", 23, 1.50f),
            new Persona("Nembre", 44, 1.50f),
            new Persona("Nimbre", 19, 1.59f)
        };
        // Se muestra el array sin ordenar
        System.out.printf("Array de personas sin ordenar                         :%n%s%n%n",
                Arrays.toString(arrayDePersonas));
        // Se ordena el array con dos argumentos. Primero por nombre
        var c1 = Comparator.comparing(Persona::getNombre);
        var c2 = c1.reversed();
        var c3 = c1.thenComparing(Persona::getEdad);
        var c4 = c2.thenComparing(Persona::getEdad);
        Arrays.sort(arrayDePersonas, c1);
        // Se muestra el array de Personas ordenado por nombre
        System.out.printf("Array de personas ordenado por nombre         :%n%s%n%n",
                Arrays.toString(arrayDePersonas));
        // Ahora se ordena por nombre pero al revés
        Arrays.sort(arrayDePersonas, c2);
        // Se muestra el array de personas ordenada descendentemente por nombre
        System.out.printf("Array de personas después de ordenar por nombre al revés:%n%s%n%n",
                Arrays.toString(arrayDePersonas));
        // Ahora se ordena la lista de personas primero por nombre y luego por edad
        Arrays.sort(arrayDePersonas, c3);
        System.out.printf("Array de personas después de ordenar por nombre y edad:%n%s%n%n",
                Arrays.toString(arrayDePersonas));
        // Ahora se ordena descendentemnte por nombre y ascendentemente por edad
        Arrays.sort(arrayDePersonas, c4);
        System.out.printf("Array de personas después de ordenar descendentemente"
                + " por nombre y ascendentemente por edad:%n%s%n%n",
                Arrays.toString(arrayDePersonas));

    }
    public void sortColeccionesConDosArgumentos() {
        underline2("Uso de Collections.sort() con dos argumentos");
        //
        // Método sort con dos argumentos.
        //
        // Se declara un array de Personas
        Persona[] arrayDePersonas = {new Persona("Nambre", 22, 1.60f),
            new Persona("Nimbre", 21, 1.50f),
            new Persona("Nambre", 19, 1.59f)
        };
        var c1 = Comparator.comparing(Persona::getNombre);
        var c2 = c1.reversed();
        var c3 = c1.thenComparing(Persona::getEdad);
        var c4 = c2.thenComparing(Persona::getEdad);
       // Se crea un ArrayList<Persona> de igual contenido
        List<Persona> coleccionDePersonas = Arrays.asList(arrayDePersonas);
        // Se muestra el ArrayList sin ordenar
        System.out.printf("Coleccionnn de personas sin ordenar                         :%n%s%n%n",
                coleccionDePersonas);
        // Se ordena el ArrayList con dos argumentos. Primero por nombre
        Collections.sort(coleccionDePersonas, c1);
        // Se muestra el ArrayList de Personas ordenado por nombre
        System.out.printf("Coleccion de personas ordenado por nombre         :%n%s%n%n", 
                coleccionDePersonas);
        // Ahora se ordena por nombre pero al revés
        Collections.sort(coleccionDePersonas, c2);
        // Se muestra la colección de personas ordenada descendentemente por nombre
        System.out.printf("Coleccion de personas después de ordenar por nombre al revés:%n%s%n%n",
                coleccionDePersonas);
        // Ahora se ordena la lista de personas primero por nombre y luego por edad
        Collections.sort(coleccionDePersonas, c3);
        System.out.printf("Coleccion de personas después de ordenar por nombre y edad:%n%s%n%n",
                coleccionDePersonas);
        // Ahora se ordena descendentemnte por nombre y ascendentemente por edad
        Collections.sort(coleccionDePersonas, c4);
        System.out.printf("Coleccion de personas después de ordenar descendentemente"
                + " por nombre y ascendentemente por edad:%n%s%n%n", coleccionDePersonas);

    }
    public void sortColeccionesDosArgumentosNuevo() {
        underline2("Uso de Collections.sort() con dos argumentos, nueva sintaxis");
        //
        // Método sort con dos argumentos.
        //
        // Se declara un array de Personas
        Persona[] arrayDePersonas = {new Persona("Nambre", 22, 1.60f),
            new Persona("Nambre", 21, 1.50f),
            new Persona("Nimbre", 19, 1.59f)
        };
        // Se crea un ArrayList<Persona> de igual contenido
        List<Persona> coleccionDePersonas = Arrays.asList(arrayDePersonas);
        // Se muestra el ArrayList sin ordenar
        System.out.printf("Coleccion de personas sin ordenar                         :%n%s%n%n",
                coleccionDePersonas);
        // Se ordena el ArrayList con dos argumentos. Primero por nombre
        var c1 = Comparator.comparing(Persona::getNombre);
        var c2 = c1.reversed();
        var c3 = c1.thenComparing(Persona::getEdad);
        var c4 = c2.thenComparing(Persona::getEdad);
        coleccionDePersonas.sort(c1);
        // Se muestra el ArrayList de Personas ordenado por nombre
        System.out.printf("Coleccion de personas ordenado por nombre         :%n%s%n%n", 
                coleccionDePersonas);
        // Ahora se ordena por nombre pero al revés
        coleccionDePersonas.sort(c2);
        // Se muestra la colección de personas ordenada descendentemente por nombre
        System.out.printf("Coleccion de personas después de ordenar por nombre al revés:%n%s%n%n",
                coleccionDePersonas);
        // Ahora se ordena la lista de personas primero por nombre y luego por edad
        coleccionDePersonas.sort(c3);
        System.out.printf("Coleccion de personas después de ordenar por nombre y edad:%n%s%n%n", 
                coleccionDePersonas);
        // Ahora se ordena descendentemnte por nombre y ascendentemente por edad
        coleccionDePersonas.sort(c4);
        System.out.printf("Coleccion de personas después de ordenar "
                + "descendentemente por nombre y ascendentemente por edad:%n%s%n%n",
                coleccionDePersonas);

    }

 }
