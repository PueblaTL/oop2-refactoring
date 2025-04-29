package oop2.tp3.ejercicio3;

public class GastoCena implements Gasto {
    int monto;
    String nombre = "Cena";
    public GastoCena(int monto){
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
        if (this.monto > 5000){
            return "X";
        }
        return " ";
    }

}