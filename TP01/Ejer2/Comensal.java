package Ejer2;

public class Comensal {
    private String nombre, dni;
    private TarjetaCredito tarjeta;

    public Comensal(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarTarjeta(TarjetaCredito tarj){
        this.tarjeta = tarj;
        this.tarjeta.asignarTitular(this);
    }

    public void pagarPedido(Pedido pedido){
        pedido.recibirPago(tarjeta);
    }

    public String getNombre() {
        return nombre;
    }
}
