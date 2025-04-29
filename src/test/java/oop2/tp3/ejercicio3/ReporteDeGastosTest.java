package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteDeGastosTest {
    @Test
    public void TestGastosDesayuno(){
        var reporte = new ReporteDeGastos(List.of(new GastoDesayuno(1000)));
        String reporteImpreso = reporte.generarReporte();
        String reporteEsperado = "Expenses " + LocalDate.now()  + "\n" + "Desayuno" + "\t" + 1000 + "\t" + " " + "\n"
                + "Gastos de comida: " + 1000 + "\n" + "Total de gastos: " + 1000 + "\n";
        assertEquals(reporteEsperado, reporteImpreso);
    }
    @Test
    public void TestGastosCena(){

        var reporte = new ReporteDeGastos(List.of(new GastoCena(2000)));
        String reporteImpreso = reporte.generarReporte();
        String reporteEsperado = "Expenses " + LocalDate.now()  + "\n" + "Cena" + "\t" + 2000 + "\t" + " " + "\n"
                + "Gastos de comida: " + 2000 + "\n" + "Total de gastos: " + 2000 + "\n";
        assertEquals(reporteEsperado, reporteImpreso);
    }
    @Test
    public void TestGastosAlquilerAuto(){
        var reporte = new ReporteDeGastos(List.of(new GastoAlquilerAuto(5000)));
        String reporteImpreso = reporte.generarReporte();
        String reporteEsperado = "Expenses " + LocalDate.now()  + "\n" + "Alquiler de Autos" + "\t" + 5000 + "\t" + "\n"
                + "Gastos de comida: " + 0 + "\n" + "Total de gastos: " + 5000 + "\n";
        assertEquals(reporteEsperado, reporteImpreso);
    }
    @Test
    public void TestGastosCenaExceso(){
        var reporte = new ReporteDeGastos(List.of(new GastoCena(10000)));
        String reporteImpreso = reporte.generarReporte();
        String reporteEsperado = "Expenses " + LocalDate.now()  + "\n" + "Cena" + "\t" + 10000 +"\t"+ "X" + "\n"
                + "Gastos de comida: " + 10000 + "\n" + "Total de gastos: " + 10000 + "\n";
        assertEquals(reporteEsperado, reporteImpreso);
    }

}