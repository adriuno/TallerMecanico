package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {
    private List<Revision> coleccionRevisiones;

    public Revisiones() {
        coleccionRevisiones = new ArrayList<>();
    }
    public List<Revision> get() {
        return new ArrayList<>(coleccionRevisiones);
    }
    public List<Revision> get(Cliente cliente) {
        List<Revision> revisionesClientes = new ArrayList<>();
        for (Revision revision : coleccionRevisiones) {
            if (revision.getCliente().equals(cliente)) {
                revisionesClientes.add(revision);
            }
        }
        return revisionesClientes;
    }
    public List<Revision> get(Vehiculo vehiculo) {
        List<Revision> vehiculos = new ArrayList<>();
        for (Revision revision : coleccionRevisiones) {
            if (revision.getVehiculo().equals(vehiculo)) {
                vehiculos.add(revision);
            }
        }
        return vehiculos;
    }
    public void insertar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No se puede insertar una revisión nula.");
        comprobarRevision(revision.getCliente(), revision.getVehiculo(), revision.getFechaInicio());
        coleccionRevisiones.add(revision);
    }
    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws OperationNotSupportedException {
        for (Revision revision : coleccionRevisiones) {
            if (revision.getCliente().equals(cliente)) {
                if (!revision.estaCerrada()) {
                    throw new OperationNotSupportedException("El cliente tiene otra revisión en curso.");
                }
                if (revision.estaCerrada() && (!fechaRevision.isAfter(revision.getFechaFin()))) {
                    throw new OperationNotSupportedException("El cliente tiene una revisión posterior.");
                }
            }
            if (revision.getVehiculo().equals(vehiculo)) {
                if (!revision.estaCerrada()) {
                    throw new OperationNotSupportedException("El vehículo está actualmente en revisión.");
                }
                if (revision.estaCerrada() && (!fechaRevision.isAfter(revision.getFechaFin()))) {
                    throw new OperationNotSupportedException("El vehículo tiene una revisión posterior.");
                }
            }
        }
    }
    private Revision getRevision(Revision revision) {
        Objects.requireNonNull(revision, "La revisión no puede ser nula.");
        int indice = coleccionRevisiones.indexOf(revision);
        return indice == -1 ? null : coleccionRevisiones.get(indice);
    }

    public void anadirHoras(Revision revision, int horas) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (getRevision(revision) == null) {
            throw new OperationNotSupportedException("No existe ninguna revisión igual.");
        }
        getRevision(revision);
        revision.anadirHoras(horas);
    }
    public void anadirPrecioMaterial(Revision revision, float precioMaterial) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (getRevision(revision) == null) {
            throw new OperationNotSupportedException("No existe ninguna revisión igual.");
        }
        revision.anadirPrecioMaterial(precioMaterial);
    }
    public void cerrar(Revision revision, LocalDate fechaFin) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (getRevision(revision) == null) {
            throw new OperationNotSupportedException("No existe ninguna revisión igual.");
        }
        revision.cerrar(fechaFin);
    }
    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revision, "No se puede buscar una revisión nula.");
        return coleccionRevisiones.contains(revision) ? getRevision(revision) : null;
    }
    public void borrar(Revision revision) throws OperationNotSupportedException {
        Objects.requireNonNull(revision, "No se puede borrar una revisión nula.");
        if (!coleccionRevisiones.contains(revision)) {
            throw new OperationNotSupportedException("No existe ninguna revisión igual.");
        }
        coleccionRevisiones.remove(revision);
    }
}
