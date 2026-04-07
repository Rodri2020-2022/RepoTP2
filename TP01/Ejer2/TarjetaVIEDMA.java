package Ejer2;

public class TarjetaVIEDMA implements TarjetaCredito {
    private Long nroTarjeta;
    private String titular;
    private float saldoDisponible;

    public TarjetaVIEDMA(Long nroTarjeta, float montoDisponible) {
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

    @Override
    public float aplicarDescuento(float montoBebidas, float montoPlatos) {
        return montoBebidas + montoPlatos;
    }

    public void asignarTitular(Comensal comensalTitular){
        this.titular = comensalTitular.getNombre().toUpperCase();
    }

    @Override
    public String toString() {
        return "TarjetaVIEDMA {" +
                "NRO: " + nroTarjeta +
                ", De: " + titular + '\'' +
                ", Saldo =" + String.format("%.2f", saldoDisponible) +
                '}';
    }
}
