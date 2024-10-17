import paquete1.Clase1;
// import paquete1.Clase2; Da error porque Clase2 se crea privada en el ámbito de su paquete si no decimos que sea pública

public class App {
    public static void main(String[] args) throws Exception {

        Clase1 objeto = new Clase1();

        System.out.println(objeto.atributoPublic); //A este atributo podemos acceder desde cualquier clase de cualquier paqute

        /* Los siguientes atributos no son visibles desde nuestro main; cada una de ellas tiene un "scope" o ámbito distinto, es decir, una zona del código en la que son visibles:
        System.out.println(objeto.atributoSinModificador); - es visible únicamente en las clases de su mismo paquete, paquete1.
        System.out.println(objeto.atributoProtected); - es visible desde las clases que estén en el mismo paquete y desde las subclases de Clase1 (aunque estén en otro paquete)
        System.out.println(objeto.atributoPrivate); - es visible únicamente desde la propia clase, Clase1.
        */

        //Lo mismo sucede para los métodos:
        objeto.metodoPublic();
        /*
        objeto.metodoSinModificador();
        objeto.metodoProtected();
        objeto.metodoPrivate();
        */
    }
}