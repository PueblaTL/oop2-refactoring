package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testDeudaYpuntosConLibrosRegulares() {
        Libro libro1 = new Libro("El Túnel", Libro.REGULARES);
        CopiaLibro copia1 = new CopiaLibro(libro1);
        Alquiler alquiler1 = new Alquiler(copia1, 5); // más de 2 días

        Cliente cliente = new Cliente("Javier");
        cliente.alquilar(alquiler1);

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(6.5, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void testDeudaYpuntosConNuevoLanzamiento() {
        Libro libro = new Libro("Nuevo Best Seller", Libro.NUEVO_LANZAMIENTO);
        CopiaLibro copia = new CopiaLibro(libro);
        Alquiler alquiler = new Alquiler(copia, 2); // más de 1 día

        Cliente cliente = new Cliente("Ana");
        cliente.alquilar(alquiler);

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(6.0, (double) resultado[0]);
        assertEquals(2, (int) resultado[1]);
    }

    @Test
    void testDeudaYpuntosConInfantiles() {
        Libro libro = new Libro("Cuentos para niños", Libro.INFANTILES);
        CopiaLibro copia = new CopiaLibro(libro);
        Alquiler alquiler = new Alquiler(copia, 4); // más de 3 días

        Cliente cliente = new Cliente("Martín");
        cliente.alquilar(alquiler);

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(3.0, (double) resultado[0]);
        assertEquals(1, (int) resultado[1]);
    }

    @Test
    void testClienteConMultiplesAlquileres() {
        Cliente cliente = new Cliente("Laura");
        cliente.alquilar(new Alquiler(new CopiaLibro(new Libro("Libro Regular", Libro.REGULARES)), 1));
        cliente.alquilar(new Alquiler(new CopiaLibro(new Libro("Libro Infantil", Libro.INFANTILES)), 5));
        cliente.alquilar(new Alquiler(new CopiaLibro(new Libro("Nuevo Lanzamiento", Libro.NUEVO_LANZAMIENTO)), 1));

        Object[] resultado = cliente.calcularDeudaYPuntosObtenidos();

        assertEquals(2.0 + 4.5 + 3.0, (double) resultado[0]);
        assertEquals(3, (int) resultado[1]);
    }
}
