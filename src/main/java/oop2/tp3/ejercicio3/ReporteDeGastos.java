package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private String reporte;
    private List<Gasto>gastos;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public String generarReporte() {
        int total = 0;
        int gastosDeComida = 0;
        this.reporte = "Expenses " + LocalDate.now()  + "\n";
        for (Gasto gasto : this.gastos) {
            gastosDeComida += gasto.sumarMontoComida();
            String nombreGasto = gasto.nombreGasto();
            String marcaExcesoComidas = gasto.marcaExcesoComidas();
            reporte += nombreGasto + "\t" + gasto.monto() + "\t" + marcaExcesoComidas + "\n";
            total += gasto.monto();
        }
        reporte += "Gastos de comida: " + gastosDeComida + "\n";
        reporte += "Total de gastos: " + total + "\n";
        return this.reporte;
    }

}