package proyectobd;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProyectoBD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("***************************");
            System.out.println("       Menu principal       ");
            System.out.println("***************************");
            System.out.println("1.....Ingresar producto");
            System.out.println("2.....Mostrar productos");
            System.out.println("3.....Buscar producto");
            System.out.println("4.....Modificar producto");
            System.out.println("5.....Eliminar producto");
            System.out.println("6.....Salir del menu principal");
            System.out.print("Seleccione una opcion del menu: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        ingresarProducto(scanner);
                        break;
                    case 2:
                        ConexionBD.listarProductos();
                        break;
                    case 3:
                        System.out.print("Ingrese el codigo del producto a buscar: ");
                        String codigo = scanner.nextLine();
                        ConexionBD.buscarProducto(codigo); // Llamada al metodo de busqueda
                        break;
                    case 4:
                        modificarProducto(scanner);
                        break;
                    case 5:
                        eliminarProducto(scanner);
                        break;
                    case 6:
                        System.out.println("Saliendo del menu...");
                        break;
                    default:
                        System.out.println("Opcion no valida, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un numero valido.");
                scanner.nextLine();  // Limpiar el buffer en caso de error
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static void ingresarProducto(Scanner scanner) {
        System.out.print("Ingrese el codigo del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese la fecha de vencimiento (YYYY-MM-DD): ");
        String fecha = scanner.nextLine();

        ConexionBD.insertarProducto(codigo, nombre, precio, cantidad, fecha);
    }

    private static void modificarProducto(Scanner scanner) {
        System.out.print("Ingrese el codigo del producto a modificar: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        ConexionBD.actualizarProducto(codigo, nombre, precio);
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el codigo del producto a eliminar: ");
        String codigo = scanner.nextLine();

        ConexionBD.eliminarProducto(codigo);
    }
}
