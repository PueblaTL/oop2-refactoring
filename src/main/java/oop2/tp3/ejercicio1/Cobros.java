package oop2.tp3.ejercicio1;

public class Cobros {
    static final double COSTO_ADICIONAL_POR_DIA = 1.5;
    static final int COSTO_BASE_REGULARES = 2;
    static final int COSTO_NUEVO_LANZAMIENTO = 3;
    static final double COSTO_BASE_INFANTILES = 1.5;
    static final int REGULARES_DIAS_SIN_COSTO_ADICIONAL = 2;
    static final int INFANTILES_DIAS_SIN_COSTO_ADICIONAL = 3;
    static final int DIAS_MINIMO = 1;
    private Cliente cliente;

    public Cobros(Cliente cliente) {
        this.cliente = cliente;
    }

    public Object[] calcularDeudaYPuntosObtenidos() {
        Object[] resultado = new Object[2];
        double total = 0;
        int puntosAlquilerFrecuente = 0;
        for (Alquiler alquiler : cliente.alquileres()) {
            total = calcularDeuda(alquiler, total);
            puntosAlquilerFrecuente = sumarPuntosPorAlquiler(alquiler, puntosAlquilerFrecuente);
        }
        resultado[0] = total;
        resultado[1] = puntosAlquilerFrecuente;
        return resultado;
    }

    private double calcularDeuda(Alquiler alquiler, double total) {
        double monto = 0;
        // determine amounts for each line
        if (isRegulares(alquiler)){
            monto = calcularMontoRegulares(alquiler, monto);
        }
        if (isNuevoLanzamiento(alquiler)) {
            monto = calcularMontoNuevoLanzamiento(alquiler, monto);
        }
        if (isInfantiles(alquiler)){
            monto = calcularMontoInfantiles(alquiler, monto);
        }
        total += monto;
        return total;
    }

    private boolean isInfantiles(Alquiler alquiler) {
        return Libro.INFANTILES == esAlquilerTipo(alquiler);
    }

    private boolean isNuevoLanzamiento(Alquiler alquiler) {
        return Libro.NUEVO_LANZAMIENTO == esAlquilerTipo(alquiler);
    }

    private boolean isRegulares(Alquiler alquiler) {
        return Libro.REGULARES == esAlquilerTipo(alquiler);
    }

    private double calcularMontoInfantiles(Alquiler alquiler, double monto) {
        monto += COSTO_BASE_INFANTILES;
        if (alquiler.diasAlquilados() > INFANTILES_DIAS_SIN_COSTO_ADICIONAL)
            monto += (alquiler.diasAlquilados() - INFANTILES_DIAS_SIN_COSTO_ADICIONAL) * COSTO_ADICIONAL_POR_DIA;
        return monto;
    }

    private double calcularMontoNuevoLanzamiento(Alquiler alquiler, double monto) {
        monto += alquiler.diasAlquilados() * COSTO_NUEVO_LANZAMIENTO;
        return monto;
    }

    private double calcularMontoRegulares(Alquiler alquiler, double monto) {
        monto += COSTO_BASE_REGULARES;
        if (alquiler.diasAlquilados() > REGULARES_DIAS_SIN_COSTO_ADICIONAL)
            monto += (alquiler.diasAlquilados() - REGULARES_DIAS_SIN_COSTO_ADICIONAL) * COSTO_ADICIONAL_POR_DIA;
        return monto;
    }

    private int esAlquilerTipo(Alquiler alquiler) {
        return alquiler.copia().libro().codigoPrecio();
    }

    private int sumarPuntosPorAlquiler(Alquiler alquiler, int puntosAlquilerFrecuente) {
        // sumo puntos por alquiler
        puntosAlquilerFrecuente++;
        // bonus por dos días de alquiler de un nuevo lanzamiento
        if (condicionNuevoLanzamientoSumarPuntos(alquiler)) {
            puntosAlquilerFrecuente++;
        }
        return puntosAlquilerFrecuente;
    }

    private boolean condicionNuevoLanzamientoSumarPuntos(Alquiler alquiler) {
        return isNuevoLanzamiento(alquiler) && alquiler.diasAlquilados() > DIAS_MINIMO;
    }
}