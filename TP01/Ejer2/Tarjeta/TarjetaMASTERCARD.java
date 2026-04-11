package Ejer2.Tarjeta;

import Ejer2.Comensal;

public class TarjetaMASTERCARD implements TarjetaCredito {
    private Long nroTarjeta;
    private String titular;
    private float saldoDisponible;
    static final float DESCUENTO_PLATOS = (float) 2/100;

    public TarjetaMASTERCARD(Long nroTarjeta, float montoDisponible) {
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
        return montoBebidas + descuento(montoPlatos);
    }

    private static float descuento(float monto) {
        return monto - (monto * DESCUENTO_PLATOS);
    }

    public void asignarTitular(Comensal comensalTitular){
        this.titular = comensalTitular.getNombre().toUpperCase();
    }

    @Override
    public String tipo() {
        return "MASTERCARD";
    }

    @Override
    public String toString() {
        return "TarjetaMASTERCARD {" +
                "NRO: " + nroTarjeta +
                ", De: " + titular + '\'' +
                ", Saldo =" + String.format("%.2f", saldoDisponible) +
                '}';
    }
}
