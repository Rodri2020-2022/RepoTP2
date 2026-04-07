package Ejer2_Test;

import Ejer2.*;
import org.junit.jupiter.api.Test;

public class RestauranteTest {
    @Test
    void main(){
        var tarjeta1 = new TarjetaMASTERCARD(1000100010001000L,
                59500.20f);
        System.out.println(tarjeta1.toString());

        var cl1 = new Comensal("Rodrigo","43138364");
        cl1.asignarTarjeta(tarjeta1);

        Plato plato1 = Menu.MILANESA_GIGANTE;
        Plato plato2 = Menu.MILANESA;
        Bebida bebida1 = Menu.PEPSI_BOTELLA;

        Pedido p1 = new Pedido(cl1.getNombre(), plato1, plato2, bebida1);
        cl1.pagarPedido(p1);
        System.out.println(tarjeta1.toString());

    }
}