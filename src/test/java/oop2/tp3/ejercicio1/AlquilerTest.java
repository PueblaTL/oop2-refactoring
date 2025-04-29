package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlquilerTest {
    Libro unLibro;
    CopiaLibro unaCopia;
    Cliente unCliente;
    Alquiler alquilerProgrJava;

    @BeforeEach

    public void incializarVariables() {
        unLibro = new Libro("Cuentos para niños", 0);
        unaCopia = new CopiaLibro(unLibro);
        unCliente = new Cliente("Jose");
        alquilerProgrJava = new Alquiler(unaCopia, 3);
        unCliente.alquilar(alquilerProgrJava);
    }

    @Test

    public void verificarLibro() {
        assertEquals(0, unLibro.codigoPrecio());
        assertEquals("Cuentos para niños", unLibro.nombre());
    }

    @Test
    public void verificarAspectosClientes() {
        var resultado = unCliente.calcularDeudaYPuntosObtenidos();
        assertEquals(3.5, resultado[0]);
        assertEquals(1, resultado[1]);
    }

    @Test
    public void verificarAlquiler() {
        assertEquals(3, alquilerProgrJava.diasAlquilados());
    }

}