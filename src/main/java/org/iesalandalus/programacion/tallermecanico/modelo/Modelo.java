package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Modelo {
    Revisiones revisiones;
    Vehiculos vehiculos;
    Clientes clientes;

    public Modelo() {
        revisiones = new Revisiones();
        vehiculos = new Vehiculos();
        clientes = new Clientes();
    }

    public void comenzar() {
        Modelo modelo = new Modelo();
    }
    public void terminar() {
        System.out.print("El modelo ha terminado de ejecutarse.");
    }
    public void insertar(Cliente cliente) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        cliente = new Cliente(cliente);
        clientes.insertar(cliente);
    }
    public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo.");
        vehiculos.insertar(vehiculo);
    }
    public void insertar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula insertar.");
        clientes.buscar(revision.getCliente());
        vehiculos.buscar(revision.getVehiculo());
        revisiones.insertar(new Revision(revision));

    }
    public Cliente buscar(Cliente cliente) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo buscar.");
        clientes.buscar(cliente);
        return new Cliente(cliente);
    }
    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo buscar.");
        vehiculos.buscar(vehiculo);
        return vehiculo;
    }
    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revision, "La revisión no puede ser nula buscar.");
        revisiones.buscar(revision);
        return new Revision(revision);
    }
    public boolean modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo modificar.");
        return clientes.modificar(cliente, nombre, telefono);
    }

    public void anadirHoras(Revision revision, int horas) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula añadir horas");
        revisiones.anadirHoras(revision, horas);
    }
    public void anadirPrecioMaterial(Revision revision, float precioMaterial) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula añadirPrecioMaterial");
        revisiones.anadirPrecioMaterial(revision, precioMaterial);
    }
    public void cerrar(Revision revision, LocalDate fechaFin) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula cerrar.");
        Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser nula cerrar.");
        revisiones.cerrar(revision, fechaFin);
    }
    public void borrar(Cliente cliente) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo borrar.");
        for (Revision revision : revisiones.get(cliente)) {
            revisiones.borrar(revision);
        }
        clientes.borrar(cliente);
    }
    public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo borrar.");
        for (Revision revision : revisiones.get(vehiculo)) {
            revisiones.borrar(revision);
        }
        vehiculos.borrar(vehiculo);
    }
    public void borrar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión no puede ser nula borrar.");
        revisiones.borrar(revision);
    }
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        for (Cliente cliente : clientes.get()) {
            listaClientes.add(new Cliente(cliente));
        }
        return listaClientes;
    }
    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos.get());
    }
    public List<Revision> getRevisiones() {
        List<Revision> listaRevision = new ArrayList<>();
        for (Revision revision : revisiones.get()) {
            listaRevision.add(new Revision(revision));
        }
        return listaRevision;
    }
    public List<Revision> getRevisiones(Cliente cliente) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo getRevisiones.");
        List<Revision> revisionCliente = new ArrayList<>();
        for (Revision revision : revisiones.get(cliente)) {
            revisionCliente.add(new Revision(revision));
        }
        return revisionCliente;
    }
    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo getRevisiones.");
        List<Revision> revisionVehiculo = new ArrayList<>();
        for (Revision revision : revisiones.get(vehiculo)) {
            revisionVehiculo.add(new Revision(revision));
        }
        return revisionVehiculo;
    }
}
