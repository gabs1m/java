package controller;

import java.sql.*;
import java.util.ArrayList;
import database.Conexao;
import model.Pedido;

public class PedidoController implements Controller<Boolean, Pedido>{
    public PedidoController(){}

    public Boolean insert(Pedido pedido){
        try{
            String sql = "INSERT INTO pedido SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            

            int inseridos = statement.executeUpdate();
            return inseridos > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Pedido> select(String tipo, String...valor){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM pedido";
            } else{
                sql = "SELECT * FROM pedido WHERE " + tipo + " = " + valor[0] + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Pedido pedido = new Pedido();
                
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
            String sql = "UPDATE pedido SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ? " +  "WHERE codigo_pedido = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            
            statement.setInt(7, id);

            int atualizados = statement.executeUpdate();
            return atualizados > 0;
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
            int deletados = statement.executeUpdate();
            return deletados > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }
}