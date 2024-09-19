/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_crud2;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author YEIMER
 */
public class Ejemplo_crud2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int option;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Editar persona"); // Nueva opción para editar
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    agregarPersona(scanner); //agregar
                    break;
                case 2:
                    eliminarPersona(scanner); //elimiar 
                    break;
                case 3:
                    editarPersona(scanner); // editar
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void agregarPersona(Scanner scanner) {
        scanner.nextLine();  // Consumir el salto de línea
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el documento: ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        String edad = scanner.nextLine();
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();

        // Llamar al método de agregar
        agregar ag = new agregar();
        try {
            ag.agregarPersona(nombre, documento, edad, direccion, telefono);
            System.out.println("Persona agregada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar persona: " + e.getMessage());
        }
    }

    private static void eliminarPersona(Scanner scanner) {
        System.out.print("Ingrese el ID de la persona a eliminar: ");
        int id = scanner.nextInt();

        // Llamar al método de eliminar
        eliminar el = new eliminar();
        try {
            el.eliminarpersona(id);
            System.out.println("Persona eliminada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar persona: " + e.getMessage());
        }
    }

    private static void editarPersona(Scanner scanner) {
        System.out.print("Ingrese el ID de la persona a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea

        System.out.print("Ingrese el nuevo nombre (deje en blanco para no cambiar): ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo documento (deje en blanco para no cambiar): ");
        String documento = scanner.nextLine();
        System.out.print("Ingrese la nueva edad (deje en blanco para no cambiar): ");
        String edad = scanner.nextLine();
        System.out.print("Ingrese la nueva dirección (deje en blanco para no cambiar): ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el nuevo teléfono (deje en blanco para no cambiar): ");
        String telefono = scanner.nextLine();

        // Llamar al método de editar
        editar ed = new editar();
        try {
            ed.editarPersona(id, nombre, documento, edad, direccion, telefono);
            System.out.println("Persona editada correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al editar persona: " + e.getMessage());
 }
}
}