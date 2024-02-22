package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehiculos {
    private List<Vehiculo> vehiculos;

    public Vehiculos() {
        vehiculos = new ArrayList<>();
    }
    public List<Vehiculo> get() {
        return new ArrayList<>(vehiculos);
    }
    public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "No se puede insertar un vehículo nulo.");
        if (vehiculos.contains(vehiculo)) {
            throw new OperationNotSupportedException("Ya existe un vehículo con esa matrícula.");
        }
        vehiculos.add(vehiculo);
    }
    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "No se puede buscar un vehículo nulo.");
        int indice = vehiculos.indexOf(vehiculo);
        return indice == -1 ? null : vehiculos.get(indice);
    }
    public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
        Objects.requireNonNull(vehiculo, "No se puede borrar un vehículo nulo.");
        if (!vehiculos.contains(vehiculo)) {
            throw new OperationNotSupportedException("No existe ningún vehículo con esa matrícula.");
        }
        vehiculos.remove(vehiculo);
    }
}
