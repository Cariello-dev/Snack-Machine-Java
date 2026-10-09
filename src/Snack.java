import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

class Snack {

    private static int contador ;
    private String nombre ;
    private double precio ;

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        Snack.contador = contador;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "contador=" + contador +
                ", idSnack=" +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }


    public Snack(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
        contador++;
    }



}
class Snacks{

public static ArrayList<Snack> inventario = new ArrayList<>();

static{
    inventario.add(new Snack("Oreo",38));
    inventario.add(new Snack("Festival",38));
}

Scanner sc = new Scanner(System.in);
public void agregarSnacks(){
    System.out.print("Dame El nombre del producto que quieres agregar :" );
    String nombreSnack = sc.nextLine();
    System.out.print("Ahora dame el precio del producto :");
    double precioProducto = sc.nextDouble();
    inventario.add(new Snack(nombreSnack,precioProducto));



}
public void mostrarSnacks(){
    if(!inventario.isEmpty()){
        System.out.println(inventario);
    }
    else{
        System.out.println("No tiene Nada Adentro Ingrese Un Snack");
    }

}

    public static ArrayList<Snack> getInventario() {
        return inventario;
    }
}




class MaquinaSnacks {

    ArrayList<Snack> Carrito = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Snacks snack = new Snacks();


    void agregarSnack() {

        System.out.print("Ingrese el ID del snack: ");
        int id = sc.nextInt();

        for (Snack producto : Snacks.getInventario()) {
            if (producto.getContador() == id) {
                Carrito.add(producto);
                System.out.println("Snack agregado al carrito.");
                return;
            }
        }

        System.out.println("Snack no encontrado.");
    }

    void mostrarTickets() {
        double total = 0;

        for (Snack producto : Carrito) {
            System.out.println(producto);
            total += producto.getPrecio();
        }

        System.out.println("Total: $" + total);
    }

    void comprarSnack() {
        double total = 0;

        for (Snack producto : Carrito) {
            total += producto.getPrecio();
        }

        System.out.println("Total a pagar: $" + total);
        System.out.print("Ingrese el dinero: ");
        double dinero = sc.nextDouble();

        if (dinero >= total) {
            System.out.println("Compra realizada.");
            System.out.println("Cambio: $" + (dinero - total));
            Carrito.clear();
        } else {
            System.out.println("Dinero insuficiente.");
        }
    }

    public static void main(String[] args) {

        MaquinaSnacks maquina = new MaquinaSnacks();

        boolean opcion = false;

        while (!opcion) {

            System.out.println("""
                    
                    1.Ver Snacks
                    2.Agregar Snacks
                    3.Agregar Al Carrito
                    4.Mostrar Ticket
                    5.Comprar Snack
                    6.Salir
                    
                    Ingrese un Valor:
                    """);

            int eleccion = maquina.sc.nextInt();
            maquina.sc.nextLine();

            switch (eleccion) {

                case 1:
                    maquina.snack.mostrarSnacks();
                    break;

                case 2:
                    maquina.snack.agregarSnacks();
                    break;

                case 3:
                    maquina.agregarSnack();
                    break;

                case 4:
                    maquina.mostrarTickets();
                    break;

                case 5:
                    maquina.comprarSnack();
                    break;

                case 6:
                    opcion = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
