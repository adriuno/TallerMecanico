package org.iesalandalus.programacion.tallermecanico.vista;


import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Consola {
    private static final String CADENA_FORMATO_FECHA = "dd/MM/yyyy";
    private Consola() {}

    public static void mostrarCabecera(String mensaje) {
        System.out.print(mensaje);
        StringBuilder subrayado = new StringBuilder();
        subrayado.append("-".repeat(mensaje.length()));
        System.out.println(subrayado);
    }
    public static void mostrarMenu() {
        System.out.println("Bienvenido al menú del Taller Mecánico. Para realizar una acción, seleccione una opción.");
        System.out.println("--------------------");
        System.out.println("Opciones");
        System.out.println();
        System.out.println(Arrays.toString(Opcion.values()));
    }
    private static float leerReal(String mensaje) {
        System.out.print(mensaje);
        return Float.parseFloat(mensaje);
    }
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(mensaje);
    }
    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return mensaje;
    }
    private static LocalDate leerFecha(String mensaje) {
        System.out.printf("El formato de fecha válido es: %s", CADENA_FORMATO_FECHA);
        System.out.println(mensaje);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(CADENA_FORMATO_FECHA);
        LocalDate fecha = LocalDate.parse(mensaje, formato);
        return fecha;
    }
    public static Opcion elegirOpcion() {
        String opcion;
        int opcionEntero;
        do {
            System.out.print("Introduzca la opción a elegir: ");
            opcion = Entrada.cadena();
            opcionEntero = leerEntero(opcion);
        } while (opcionEntero < 1 || opcionEntero > 19);
        return Opcion.valueOf(opcion);
    }
    public static Cliente leerCliente() {
        String leerClienteNombre;
        System.out.print("Introduzca el nombre del cliente aquí: ");
        leerClienteNombre = Entrada.cadena();

        String leerClienteDNI;
        System.out.print("Introduzca el dni del cliente aquí: ");
        leerClienteDNI = Entrada.cadena();

        String leerClienteTelefono;
        System.out.print("Introduzca el teléfono del cliente aquí: ");
        leerClienteTelefono = Entrada.cadena();

        return new Cliente(leerClienteNombre, leerClienteDNI, leerClienteTelefono);
    }
    public static Cliente leerClienteDni() {
        String dni;
        System.out.print("Introduce el dni del cliente aquí: ");
        dni = Entrada.cadena();

        return Cliente.get(dni);
    }

    public static String leerNuevoNombre() {
        String nuevoNombre;
        System.out.print("Introduce el nuevo nombre aquí: ");
        nuevoNombre = Entrada.cadena();

        return nuevoNombre;
    }
    public static String leerNuevoTelefono() {
        String nuevoTelefono;
        System.out.print("Introduce el nuevo teléfono aquí: ");
        nuevoTelefono = Entrada.cadena();

        return nuevoTelefono;
    }

    public static Vehiculo leerVehiculo() {
        String leerMarca;
        String leerMatricula;
        String leerModelo;

        System.out.print("Introduce la marca del vehículo: ");
        leerMarca = Entrada.cadena();

        System.out.print("Introduce la matrícula del vehículo: ");
        leerMatricula = Entrada.cadena();

        System.out.print("Introduce el modelo del vehículo: ");
        leerModelo = Entrada.cadena();

        return new Vehiculo(leerMarca, leerModelo, leerMatricula);
    }

    public static Vehiculo leerVehiculoMatricula() {
        String leerMatricula;
        System.out.print("Introduce la matrícula del vehículo aquí: ");
        leerMatricula = Entrada.cadena();

        return Vehiculo.get(leerMatricula);
    }

    public static Revision leerRevision() {
        String leerFecha;
        System.out.print("Introduce la fecha de inicio de la revisión (Recuerde: el formato es dd/MM/yyyy): ");
        leerFecha = Entrada.cadena();

        return new Revision(leerCliente(), leerVehiculo(), LocalDate.parse(leerFecha));
    }
    public static int leerHoras() {
        int horas;
        System.out.print("Introduce el número de horas de la revisión aquí: ");
        horas = Entrada.entero();
        return horas;
    }

    public static float leerPrecioMaterial() {
        float precioMaterial;
        System.out.print("Introduce el precio del material aquí: ");
        precioMaterial = Entrada.real();

        return precioMaterial;
    }
    public static LocalDate leerFechaCierre() {
        String fechaCierre;
        System.out.print("Introduce la fecha de cierre de la revisión aquí: ");
        fechaCierre = Entrada.cadena();

        return LocalDate.parse(fechaCierre);
    }
}
