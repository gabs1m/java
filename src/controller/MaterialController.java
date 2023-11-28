package controller;

import java.sql.*;
import java.util.ArrayList;
import database.Conexao;
import model.Material;

public class MaterialController implements Controller<Boolean, Material>{
    public MaterialController(){}

    public Boolean insert(Material material){
        try{
            String sql = "INSERT INTO material SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            

            int inseridos = statement.executeUpdate();
            return inseridos > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Material> select(String tipo, String valor){
        ArrayList<Material> materiais = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM material";
            } else{
                sql = "SELECT * FROM material WHERE " + tipo + " = " + valor + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Material material = new Material();
                
                materiais.add(material);
            }

            result.close();
            statement.close();
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
        }

        return materiais;
    }

    public Boolean update(Material material, int id){
        try{
            String sql = "UPDATE material SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ? " +  "WHERE codigo_material = ?;";

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
            String sql = "DELETE FROM material WHERE " + "codigo_material = ?;";

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