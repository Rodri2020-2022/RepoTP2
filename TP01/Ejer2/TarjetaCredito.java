package Ejer2;

public interface TarjetaCredito {
    float pagar(float monto);
    float aplicarDescuento(float montoBebidas, float montoPlatos);
    void asignarTitular(Comensal comensalTitular);
}
