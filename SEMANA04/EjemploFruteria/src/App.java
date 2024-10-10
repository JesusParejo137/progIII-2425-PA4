import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scannerRef = new Scanner(System.in);

        Producto[] productos = new Producto[2];

        System.out.println("Introduce el precio/kg de cada tipo de fruta:");

        System.out.println("Manzana: ");
        productos[0] = new Producto("Manzanas", scannerRef.nextDouble());
        
        System.out.println("Pera: ");
        productos[1] = new Producto("Peras", scannerRef.nextDouble());

        boolean seguir = true;
        String YN;
        int contador = 0;

        while (seguir) {
            seguir = false;
            contador++;

            System.out.println("Bienvenido a la frutería!");
            System.out.println("Introduce la cantidad (en kg) de manzanas que desea: ");
            productos[0].setCantidad(scannerRef.nextDouble());
            System.out.println("Introduce la cantidad (en kg) de peras que desea: ");
            productos[1].setCantidad(scannerRef.nextDouble());
            System.out.println("Aquí tiene su factura:");
            mostrarFactura(productos, contador);

            System.out.println("Quiere atender a un nuevo cliente? (Y/N)");
            YN = scannerRef.nextLine();
            if (YN == "Y") {
                seguir = true;
            }
        }
    }

    private static void mostrarFactura(Producto[] productos, int contador) {
        char euro = '\u20ac';
        System.out.println("|------------------------------------------------------|");
        System.out.println("| Cliente                                          | " + contador + " |");
        System.out.println("|------------------------------------------------------|");
        for (int i = 0; i < productos.length; i++) {
            System.out.printf("| %8s | %.2f kg | precio/kg con IVA %.2f %c | %.2f |\n", productos[i].getNombre(), productos[i].getCantidad(), productos[i].getPrecioKgSinIva(), euro, productos[i].getPrecioTotal());
        }
        System.out.println("|------------------------------------------------------|");
        System.out.printf("| Total con IVA %.2f \n", productos[0].getPrecioTotal()+productos[1].getPrecioTotal());
        System.out.println("|------------------------------------------------------|");
    }
}