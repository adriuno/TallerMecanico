package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Vista {
    Controlador controlador;
    public Vista() throws OperationNotSupportedException {
        comenzar();
    }

    public void setControlador(Controlador controlador) {
        Objects.requireNonNull(controlador, "El controlador no puede ser nulo.");
        this.controlador = controlador;
    }
    public void comenzar() throws OperationNotSupportedException {
        Consola.mostrarMenu();
        ejecutar(Consola.elegirOpcion());

    }
    public void terminar() {
        System.out.println("Cerrando Vista. Que tenga un buen día.");
    }
    private void ejecutar(Opcion opcion) throws OperationNotSupportedException {
        switch (opcion) {
            case INSERTAR_CLIENTE -> insertarCliente();
            case INSERTAR_VEHICULO -> insertarVehiculo();
            case INSERTAR_REVISION -> insertarRevision();
            case BUSCAR_CLIENTE -> buscarCliente();
            case BUSCAR_VEHICULO -> buscarVehiculo();
            case BUSCAR_REVISION -> buscarRevision();
            case MODIFICAR_CLIENTE -> modificarCliente();
            case ANADIR_HORAS_REVISION -> anadirHoras();
            case ANADIR_PRECIO_MATERIAL_REVISION -> anadirPrecioMaterial();
            case CERRAR_REVISION -> cerrarRevision();
            case BORRAR_CLIENTE -> borrarCliente();
            case BORRAR_REVISION -> borrarRevision();
            case BORRAR_VEHICULO -> borrarVehiculo();
            case LISTAR_CLIENTES -> listarClientes();
            case LISTAR_VEHICULOS -> listarVehiculos();
            case LISTAR_REVISIONES -> listarRevisiones();
            case LISTAR_REVISIONES_CLIENTE -> listarRevisionesCliente();
            case LISTAR_REVISIONES_VEHICULO -> listarRevisionesVehiculo();
            case SALIR -> salir();
            default -> System.out.print("Error, tiene que escoger de entre las opciones válidas.");
        }
    }
    private void insertarCliente() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Insertar Cliente.");
        controlador.insertar(Consola.leerCliente());
        System.out.println("Se ha insertado un cliente.");
    }
    private void insertarVehiculo() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Insertar Vehículo.");
        controlador.insertar(Consola.leerVehiculo());
        System.out.println("Se ha insertado un vehículo.");
    }
    private void insertarRevision() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Insertar Revisión.");
        controlador.insertar(Consola.leerRevision());
        System.out.println("Se ha insertado una revisión.");
    }
    private void buscarCliente() {
        System.out.println("Ha seleccionado la opción: Buscar Cliente.");
        controlador.buscar(Consola.leerCliente());
        System.out.println("Los datos del Cliente son: ");
        System.out.println(controlador.buscar(Consola.leerCliente()));
    }
    private void buscarVehiculo() {
        System.out.print("Ha seleccionado la opción: Buscar Vehículo.");
        controlador.buscar(Consola.leerVehiculo());
        System.out.println("Los datos del vehículos son: ");
        System.out.println(controlador.buscar(Consola.leerVehiculo()));
    }
    private void buscarRevision() {
        System.out.println("Ha seleccionado la opción: Buscar Revisión.");
        controlador.buscar(Consola.leerRevision());
        System.out.println("Los datos de la revision son: ");
        System.out.println(controlador.buscar(Consola.leerRevision()));
    }
    private void modificarCliente() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Modificar Cliente.");
        System.out.println("A continuación se le pedirán los datos para modificar al Cliente:");
        controlador.modificar(Consola.leerCliente(), Consola.leerNuevoNombre(), Consola.leerNuevoTelefono());

    }
    private void anadirHoras() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Añadir Horas.");
        controlador.anadirHoras(Consola.leerRevision(), Consola.leerHoras());
        System.out.println("Se han añadido a la revisión las horas introducidas.");
    }
    private void anadirPrecioMaterial() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Añadir Precio del Material.");
        controlador.anadirPrecioMaterial(Consola.leerRevision(), Consola.leerPrecioMaterial());
        System.out.println("Se ha añadido el precio del material a la revisión introducida.");
    }
    private void cerrarRevision() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Cerrar Revisión.");
        controlador.cerrar(Consola.leerRevision(), Consola.leerFechaCierre());
        System.out.println("Se ha cerrado la revisión introducida.");
    }
    private void borrarCliente() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Borrar Cliente.");
        controlador.borrar(Consola.leerCliente());
        System.out.println("Se ha borrado el Cliente introducido.");
    }
    private void borrarVehiculo() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Borrar Vehículo.");
        controlador.borrar(Consola.leerVehiculo());
        System.out.println("Se ha borrado el Vehículo introducido.");
    }
    private void borrarRevision() throws OperationNotSupportedException {
        System.out.println("Ha seleccionado la opción: Borrar Revisión.");
        controlador.borrar(Consola.leerRevision());
        System.out.println("Se ha borrado la Revisión introducida.");
    }
    private void listarClientes() {
        System.out.println("Ha seleccionado la opción: Listar Clientes.");
        System.out.println("A continuación se mostrarán los clientes almacenados: ");
        System.out.println();
        System.out.println("Lista de Clientes");
        System.out.println(controlador.getClientes());
    }
    private void listarVehiculos() {
        System.out.println("Ha seleccionado la opción: Listar Vehículos");
        System.out.println("A continuación se mostrarán los vehículos almacenados: ");
        System.out.println();
        System.out.println("Lista de Vehículos");
        System.out.println(controlador.getVehiculos());
    }
    private void listarRevisiones() {
        System.out.println("Ha seleccionado la opción: Listar Revisiones.");
        System.out.println("A continuación se mostrarán las revisiones almacenadas: ");
        System.out.println();
        System.out.println("Lista de Revisiones");
        System.out.println(controlador.getRevisiones());
    }
    private void listarRevisionesCliente() {
        System.out.println("Ha seleccionado la opción: Lista de Revisiones del Cliente.");
        System.out.println("Se le pedirá el Cliente del cuál quiere conocer las revisiones.");
        controlador.getRevisiones(Consola.leerCliente());
        System.out.println("A continuación se mostrarán las revisiones almacenadas para ese cliente.");
        System.out.println();
        System.out.println("Lista de Revisiones");
        System.out.println(controlador.getRevisiones(Consola.leerCliente()));
    }
    private void listarRevisionesVehiculo() {
        System.out.println("Ha seleccionado la opción: Lista de Revisiones del Vehículo.");
        System.out.println("Se le pedirá el Vehículo del cuál quiere conocer las revisiones.");
        controlador.getRevisiones(Consola.leerVehiculo());
        System.out.println("A continuación se mostrarán las revisiones almacenadas para ese vehículo.");
        System.out.println();
        System.out.println("Lista de Revisiones");
        System.out.println(controlador.getRevisiones(Consola.leerVehiculo()));
    }
    private void salir() {
        System.out.println("Saliendo.");
    }


}
