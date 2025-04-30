package oop2.tp3.ejercicio1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculoDePagoTest {

    @Test
    public void Test(){
        //setup
        Libro elTunel = new Libro("El Túnel", Libro.REGULARES);
        Libro antesDelFin = new Libro("Antes del Fin", Libro.REGULARES);
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);
        Cobros cobro = new Cobros(yo);
        //ejercitación
        Object[] resultado = cobro.calcularDeudaYPuntosObtenidos();
        //verificación
        assertEquals(resultado[0], 10.0);
        assertEquals(resultado[1], 2);



    }
}