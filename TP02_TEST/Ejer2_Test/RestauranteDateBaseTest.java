package Ejer2_Test;

import Ejer2.Comensal;
import Ejer2.EnDiscoRegistroDePago;
import Ejer2.Items.Bebida;
import Ejer2.Items.Plato;
import Ejer2.Menu.Menu;
import Ejer2.Pedido;
import Ejer2.Propina;
import Ejer2.Tarjeta.TarjetaCredito;
import Ejer2.Tarjeta.TarjetaMASTERCARD;
import Ejer3.RegistroPedidosDAO;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RestauranteDateBaseTest {
    @Test
    void main() throws SQLException {
        TarjetaCredito tarjeta1 = new TarjetaMASTERCARD(1000100010001000L,
                70000.20f);
        System.out.println(tarjeta1.toString());

        Comensal cl1 = new Comensal("Rodrigo","43138364");
        cl1.asignarTarjeta(tarjeta1);

        Plato plato1 = Menu.MILANESA_GIGANTE;
        Plato plato2 = Menu.MILANESA;
        Bebida bebida1 = Menu.PEPSI_BOTELLA;

        Pedido p1 = new Pedido(cl1.getNombre(),
                new EnDiscoRegistroDePago("C:/Users/Rodrigo/OneDrive/Desktop/TextDoc2026_2.txt")
                ,plato1, plato2, bebida1);
        cl1.pagarPedidoYPropina(p1, Propina.PROPINA_5porCiento);

        System.out.println(tarjeta1.toString());

        RegistroPedidosDAO registroPedidoDAO = new RegistroPedidosDAO();
        registroPedidoDAO.create(p1);
    }
}
