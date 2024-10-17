package paquete1;

public class Clase1 {
    public String atributoPublic = "Atributo público";
    String atributoSinModificador = "Atributo sin modificador";
    protected String atributoProtected = "Atributo protegido";
    private String atributoPrivate = "Atributo privado";

    public static void metodoPublic() {
        System.out.println("Esto es un método público");
    }
    static void metodoSinModificador() {
        System.out.println("Esto es un método sin modificador");
    }
    protected static void metodoProtected() {
        System.out.println("Esto es un método protegido");
    }
    private static void metodoPrivate() {
        System.out.println("Esto es un método privado");
    }
}