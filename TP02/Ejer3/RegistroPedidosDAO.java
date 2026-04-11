package Ejer3;

import Ejer2.Pedido;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroPedidosDAO {

    public void create(Pedido pedido) throws SQLException {
        System.out.println("Ejecutando ------> create(Pedido pedido);");
        System.out.println("");

        try{
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(
                            "INSERT INTO pedido("
                                    + "id, "
                                    + "fecha, "
                                    + "precio, "
                                    + "detallePago) "
                                    + "VALUES (?, ?, ?, ?)");

            statement.setInt(1, pedido.getNroPedido());
            statement.setDate(2, Date.valueOf(pedido.getFechaPago()));
            statement.setFloat(3, pedido.getPrecioTotal());
            statement.setString(4, pedido.tarjetaCreditoUsada());

            int cantidad = statement.executeUpdate();
            if(cantidad > 0) {
                System.out.println("Pedido creado exitosamente");
            } else {
                throw new RuntimeException("Error al crear pedido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error SQL");
        } finally {
            System.out.println("Desconectar servidor");
            ConnectionManager.disconnect();
        }

    }
}
