package controller;

import java.sql.*;
import java.util.ArrayList;
import database.Conexao;
import model.Cliente;

public class ClienteController implements Controller<Boolean, Cliente>{
    public ClienteController(){}

    public Boolean insert(Cliente cliente){
        try{
            String sql = "INSERT INTO cliente SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, cliente.getIdade());
            statement.setString(4, cliente.getSexo());
            statement.setString(5, cliente.getEndereco());
            statement.setString(6, cliente.getTelefone());

            int inseridos = statement.executeUpdate();
            return inseridos > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Cliente> select(String tipo, String...valor){
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM cliente";
            } else{
                sql = "SELECT * FROM cliente WHERE " + tipo + " = " + valor[0] + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(result.getString("nome"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setIdade(result.getInt("idade"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setEndereco(result.getString("endereco"));
                cliente.setTelefone(result.getString("telefone"));
                clientes.add(cliente);
            }

            result.close();
            statement.close();
        } catch(SQLException e){
            System.out.println("clienteDAO.select: " + e.getMessage());
        }

        return clientes;
    }

    public Boolean update(Cliente cliente, int id){
        try{
            String sql = "UPDATE cliente SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ? " +  "WHERE codigo_cliente = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, cliente.getIdade());
            statement.setString(4, cliente.getSexo());
            statement.setString(5, cliente.getEndereco());
            statement.setString(6, cliente.getTelefone());
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
            String sql = "DELETE FROM cliente WHERE " + "codigo_cliente = ?;";

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