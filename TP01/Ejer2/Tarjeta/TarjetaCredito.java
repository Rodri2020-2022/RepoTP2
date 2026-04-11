package Ejer2.Tarjeta;

import Ejer2.Comensal;

public interface TarjetaCredito {
    float pagar(float monto);
    float aplicarDescuento(float montoBebidas, float montoPlatos);
    void asignarTitular(Comensal comensalTitular);
    String tipo();
}
