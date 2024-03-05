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
        comenzar();
    }

    public void comenzar() {
        revisiones = new Revisiones();
        vehiculos = new Vehiculos();
        clientes = new Clientes();
    }
    public void terminar() {
        System.out.print("El modelo ha terminado de ejecutarse.");
    }
    public void insertar(Cliente cliente) throws OperationNotSupportedException {
        Objects.requireNonNull(cliente, "El cliente a insertar no puede ser nulo.");
        clientes.insertar(new Cliente(cliente));
    }
    public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
        vehiculos.insertar(vehiculo);
    }
    public void insertar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "La revisión a insertar no puede ser nula.");
        Cliente cliente = clientes.buscar(revision.getCliente());
        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());
        revisiones.insertar(new Revision(cliente, vehiculo, revision.getFechaInicio()));

    }
    public Cliente buscar(Cliente cliente) {
        Objects.requireNonNull(clientes.buscar(cliente), "No existe un cliente igual.");
        return new Cliente(cliente);
    }
    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculos.buscar(vehiculo), "El vehículo no puede ser nulo buscar.");
        return vehiculo;
    }
    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revisiones.buscar(revision), "La revisión no puede ser nula buscar.");
        return new Revision(revision);
    }
    public boolean modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
        return clientes.modificar(cliente, nombre, telefono);
    }

    public void anadirHoras(Revision revision, int horas) throws OperationNotSupportedException {
        revisiones.anadirHoras(revision, horas);
    }
    public void anadirPrecioMaterial(Revision revision, float precioMaterial) throws OperationNotSupportedException {
        revisiones.anadirPrecioMaterial(revision, precioMaterial);
    }
    public void cerrar(Revision revision, LocalDate fechaFin) throws OperationNotSupportedException {
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
        return vehiculos.get();
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