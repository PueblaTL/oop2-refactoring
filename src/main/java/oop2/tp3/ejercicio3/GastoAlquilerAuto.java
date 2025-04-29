package oop2.tp3.ejercicio3;

public class GastoAlquilerAuto implements Gasto {

        int monto;
        String nombre = "Alquiler de Autos";
        public GastoAlquilerAuto(int monto){
            this.monto = monto;
        }
        @Override
        public int sumarMontoComida() {
            return 0;
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
            return "";
        }

    }

