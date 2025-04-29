package oop2.tp3.ejercicio3;

public class GastoDesayuno implements Gasto{
    int monto;
    String nombre = "Desayuno";
    public GastoDesayuno(int monto){
        this.monto = monto;
    }
    @Override
    public int sumarMontoComida() {
        return this.monto;
    }

    @Override
    public int monto() {
        return this.monto;
    }

    @Override
    public String nombreGasto() {
        return this.nombre;
    }

    @Override
    public String marcaExcesoComidas() {
        if (monto > 1000){
            return "X";
        }
        return " ";
    }

}