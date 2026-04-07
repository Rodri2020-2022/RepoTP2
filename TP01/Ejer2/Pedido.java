package Ejer2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int nroPedido;
    private String nombreTitular;
    private List<Bebida> bebidas;
    private List<Plato> platos;

    private float precioTotalBebidas;
    private float precioTotalPlatos;
    private float precioTotal;

    private boolean pagado;

    public Pedido(String nombreTitular, ItemMenu... items) {
        this.nroPedido = (int) (Math.random() * 100);
        this.nombreTitular = nombreTitular;
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();

        List.of(items).forEach(item -> item.agregarAPedido(this));
        calcularPrecioTotal();
    }

    private void calcularPrecioTotal(){
        this.precioTotal = precioTotalBebidas + precioTotalPlatos;
    }

    public void agregarBebida(Bebida bebida) {
        bebidas.add(bebida);
        this.precioTotalBebidas += bebida.getPrecio();
    }
    public void agregarPlato(Plato plato) {
        platos.add(plato);
        this.precioTotalPlatos += plato.getPrecio();
    }

    public void recibirPago(TarjetaCredito tarjeta){
        float pagoConDescuento = tarjeta.aplicarDescuento(precioTotalBebidas, precioTotalPlatos);
        tarjeta.pagar(pagoConDescuento);
        pagado = true;
    }

}
