package controller;

import java.sql.*;
import java.util.ArrayList;
import database.Conexao;
import model.*;

public class PedidoController implements Controller<Boolean, Pedido>{
    public PedidoController(){}

    public Boolean insert(Pedido pedido){
        try{
            String sql = "INSERT INTO pedido SET " + "data_pedido = ?, " + "data_entrega = ?, " + "valor = ?, " + "codigo_cliente = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pedido.getDataPedido());
            statement.setString(2, pedido.getDataEntrega());
            statement.setDouble(3, pedido.getValorPedido());
            statement.setInt(4, pedido.getCodigoCliente());

            int[] inseridos = {2};
            inseridos[0] = statement.executeUpdate();

            sql = "SELECT MAX(codigo_pedido) FROM pedido";
            Statement newStatement = connection.createStatement();
            ResultSet result = newStatement.executeQuery(sql);

            ArrayList<Pedido> pedidos = new ArrayList<>();

            while(result.next()){
                Pedido pedidoWhile = new Pedido();

                pedidoWhile.setCodigoPedido(result.getInt("codigo_pedido"));
                pedidoWhile.setCodigoRastreio(result.getInt("codigo_rastreio"));
                pedidoWhile.setDataPedido(result.getString("data_pedido"));
                pedidoWhile.setDataEntrega(result.getString("data_entrega"));
                pedidoWhile.setValorPedido(result.getDouble("valor_pedido"));
                pedidoWhile.setCodigoCliente(result.getInt("codigo_cliente"));
                pedidoWhile.setMateriais(pedido.getMateriais());
                pedidoWhile.setQuantidadeItens(pedido.getQuantidadeItens());

                pedidos.add(pedidoWhile);
            }

            Pedido novoPedido = pedidos.get(0);

            ArrayList<Material> materiais = novoPedido.getMateriais();
            for(int i = 0; i < materiais.size(); i++){
                sql = "INSERT INTO materiais_pedido SET " + "codigo_pedido = ?, " + "codigo_material = ?, " + "tipo_material = ?, " + "quantidade_material = ?, " + "valor_unitario_material = ?;";
                
                statement = connection.prepareStatement(sql);

                statement.setInt(1, novoPedido.getCodigoPedido());
                statement.setInt(2, novoPedido.getMateriais().get(i).getCodigo());
                statement.setString(3, novoPedido.getMateriais().get(i).getTipo());
                statement.setInt(4, novoPedido.getQuantidadeItens()[i]);
                statement.setDouble(5, novoPedido.getMateriais().get(i).getValorUnitario());

                inseridos[1] = statement.executeUpdate();
            }

            return inseridos[0] > 0 && inseridos[1] > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Pedido> select(String tipo, String valor){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM pedido";
            } else if(tipo.equals("id")) {
                sql = "SELECT * FROM pedido AS p INNER JOIN materiais_pedido as m ON p.codigo_pedido = m.codigo_pedido;";
            } else{
                sql = "SELECT * FROM pedido WHERE " + tipo + " = " + valor + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Pedido pedido = new Pedido();
                pedido.setCodigoPedido(result.getInt("codigo_pedido"));
                pedido.setCodigoRastreio(result.getInt("codigo_rastreio"));
                pedido.setDataPedido(result.getString("data_pedido"));
                pedido.setDataEntrega(result.getString("data_entrega"));
                pedido.setValorPedido(result.getDouble("valor_pedido"));
                pedido.setCodigoCliente(result.getInt("codigo_cliente"));
                pedido.setMateriais(pedido.getMateriais());
                pedido.setQuantidadeItens(pedido.getQuantidadeItens());
                pedidos.add(pedido);
            }

            result.close();
            statement.close();
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
        }

        return pedidos;
    }

    public Boolean update(Pedido pedido, int id){
        try{
            String sql = "UPDATE pedido SET " + "data_pedido = ?, " + "data_entrega = ?, " + "valor = ?, " + "codigo_cliente = ? " + "WHERE codigo_pedido = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pedido.getDataPedido());
            statement.setString(2, pedido.getDataEntrega());
            statement.setDouble(3, pedido.getValorPedido());
            statement.setInt(4, pedido.getCodigoCliente());
            statement.setInt(5, id);

            int[] atualizados = {2};
            atualizados[0] = statement.executeUpdate();

            ArrayList<Material> materiais = pedido.getMateriais();
            for(int i = 0; i < materiais.size(); i++){
                sql = "UPDATE materiais_pedido SET" + "codigo_material = ?, " + "tipo_material = ?, " + "quantidade_material = ?, " + "valor_unitario_material = ? " + "WHERE codigo_pedido = ?;";

                statement = connection.prepareStatement(sql);

                statement.setInt(1, materiais.get(i).getCodigo());
                statement.setString(2, materiais.get(i).getTipo());
                statement.setInt(3, materiais.get(i).getQuantidade());
                statement.setDouble(4, materiais.get(i).getValorUnitario());
                statement.setInt(5, id);

                atualizados[1] = statement.executeUpdate();
            }

            return atualizados[0] > 0 && atualizados[1] > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public Boolean delete(int id){
        try{
            String sql = "DELETE FROM pedido WHERE " + "codigo_pedido = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            int[] deletados = {2};
            deletados[0] = statement.executeUpdate();

            sql = "DELETE FROM materiais_pedido WHERE " + "codigo_pedido = ?;";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            deletados[1] = statement.executeUpdate();

            return deletados[0] > 0 && deletados[1] > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }
}