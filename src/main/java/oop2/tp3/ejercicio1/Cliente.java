package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }

    public List<Alquiler> alquileres(){
        List<Alquiler> alquileres = Collections.unmodifiableList(this.alquileres);
        return alquileres;
    }

}