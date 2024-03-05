package org.iesalandalus.programacion.tallermecanico.vista;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Opcion {
    INSERTAR_CLIENTE(1,"Insertar Cliente"),
    BUSCAR_CLIENTE(2,"Buscar Cliente"),
    BORRAR_CLIENTE(3,"Borrar Cliente"),
    LISTAR_CLIENTES(4,"Listar Clientes"),
    MODIFICAR_CLIENTE(5,"Modificar Cliente"),
    INSERTAR_VEHICULO(6, "Insertar Vehículo"),
    BUSCAR_VEHICULO(7,"Buscar Vehículo"),
    BORRAR_VEHICULO(8,"Borrar Vehículo"),
    LISTAR_VEHICULOS(9,"Listar Vehículos"),
    INSERTAR_REVISION(10,"Insertar Revisión"),
    BUSCAR_REVISION(11,"Buscar Revisión"),
    BORRAR_REVISION(12,"Borrar Revisión"),
    LISTAR_REVISIONES(13,"Listar Revisiones"),
    LISTAR_REVISIONES_CLIENTE(14,"Listar Revisiones del Cliente"),
    LISTAR_REVISIONES_VEHICULO(15,"Listar Revisiones del Vehículo"),
    ANADIR_HORAS_REVISION(16,"Añadir Horas a la Revisión"),
    ANADIR_PRECIO_MATERIAL_REVISION(17,"Añadir Precio de Material a la Revisión"),
    CERRAR_REVISION(18,"Cerrar Revisión"),
    SALIR(19,"Salir");
    private String mensaje;
    private int numeroOpcion;
    private static Map<Integer, Opcion> opciones = new HashMap<>();
    private Opcion(int numeroOpcion, String mensaje) {
        this.mensaje = mensaje;
        this.numeroOpcion = numeroOpcion;
    }
    public static boolean esValida(int numeroOpcion) {
        return numeroOpcion >= 1 && numeroOpcion <= 19;
    }
    public static Opcion get(int numeroOpcion) {
        if (!esValida(numeroOpcion)) {
            throw new IllegalArgumentException("No es un número de opción válido. Escoja un valor del 1-19.");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("%s - %s%n", this.numeroOpcion, this.mensaje);
    }
}
