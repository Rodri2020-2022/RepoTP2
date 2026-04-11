package Ejer2.Tarjeta;

import Ejer2.Comensal;

public class TarjetaCOMARCAPLUS implements TarjetaCredito {
    private Long nroTarjeta;
    private String titular;
    private float saldoDisponible;
    static final float DESCUENTO_TOTAL = (float) 2/100;

    public TarjetaCOMARCAPLUS(Long nroTarjeta, float montoDisponible) {
        this.nroTarjeta = nroTarjeta;
        this.saldoDisponible = montoDisponible;
    }

    @Override
    public float pagar(float monto){
        if(monto > saldoDisponible)
            throw new RuntimeException("Monto insuficiente");
        this.saldoDisponible = saldoDisponible - monto;
        return monto;
    }

    public float aplicarDescuento(float montoBebidas, float montoPlatos) {
        return descuento(montoBebidas + montoPlatos);
    }

    private static float descuento(float monto) {
        return monto - (monto * DESCUENTO_TOTAL);
    }

    public void asignarTitular(Comensal comensalTitular){
        this.titular = comensalTitular.getNombre().toUpperCase();
    }

    @Override
    public String tipo() {
        return "COMARCA_PLUS";
    }

    @Override
    public String toString() {
        return "TarjetaCOMARCAPLUS {" +
                "NRO: " + nroTarjeta +
                ", De: " + titular + '\'' +
                ", Saldo =" + String.format("%.2f", saldoDisponible) +
                '}';
    }
}
