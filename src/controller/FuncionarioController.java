package controller;

import java.sql.*;
import java.util.ArrayList;
import database.Conexao;
import model.Funcionario;
import model.Gerente;

public class FuncionarioController implements Controller<Boolean, Funcionario>{
    public FuncionarioController(){}

    public Boolean insert(Funcionario funcionario){
        try{
            String sql = "INSERT INTO funcionario SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?, " + "numero_conta = ?, " + "permissao_admin = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setInt(3, funcionario.getIdade());
            statement.setString(4, funcionario.getSexo());
            statement.setString(5, funcionario.getEndereco());
            statement.setString(6, funcionario.getTelefone());
            statement.setString(7, funcionario.getContaBancaria());
            statement.setBoolean(8, funcionario.getPermissaoAdmin());

            int inseridos = statement.executeUpdate();
            return inseridos > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Funcionario> select(String tipo, String valor){
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM funcionario";
            } else{
                sql = "SELECT * FROM funcionario WHERE " + tipo + " = " + valor + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(result.getString("nome"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setIdade(result.getInt("idade"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setEndereco(result.getString("endereco"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setContaBancaria(result.getString("numero_conta"));
                funcionario.setPermissaoAdmin(result.getBoolean("permissao_admin"));
                funcionarios.add(funcionario);
            }

            result.close();
            statement.close();
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
        }

        return funcionarios;
    }

    public Boolean update(Funcionario funcionario, int id){
        try{
            String sql = "UPDATE funcionario SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?, " + "numero_conta = ?, " + "permissao_admin = ? " +  "WHERE codigo_funcionario = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setInt(3, funcionario.getIdade());
            statement.setString(4, funcionario.getSexo());
            statement.setString(5, funcionario.getEndereco());
            statement.setString(6, funcionario.getTelefone());
            statement.setString(7, funcionario.getContaBancaria());
            statement.setBoolean(8, funcionario.getPermissaoAdmin());
            statement.setInt(9, id);

            int atualizados = statement.executeUpdate();
            return atualizados > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public Boolean insertGerente(Gerente gerente){
        try{
            String sql = "INSERT INTO funcionario SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?, " + "numero_conta = ?, " + "permissao_admin = ?, " + "senha_gerencial = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, gerente.getNome());
            statement.setString(2, gerente.getCpf());
            statement.setInt(3, gerente.getIdade());
            statement.setString(4, gerente.getSexo());
            statement.setString(5, gerente.getEndereco());
            statement.setString(6, gerente.getTelefone());
            statement.setString(7, gerente.getContaBancaria());
            statement.setBoolean(8, gerente.getPermissaoAdmin());
            statement.setString(9, gerente.getSenhaGerencial());

            int inseridos = statement.executeUpdate();
            return inseridos > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Gerente> selectGerente(String tipo, String valor){
        ArrayList<Gerente> gerentes = new ArrayList<>();
        String sql;

        try{
            if(tipo.equals("null")){
                sql = "SELECT * FROM funcionario";
            } else{
                sql = "SELECT * FROM funcionario WHERE " + tipo + " = " + valor + ";";
            }

            Connection connection = Conexao.getConexao();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                Gerente gerente = new Gerente();
                gerente.setNome(result.getString("nome"));
                gerente.setCpf(result.getString("cpf"));
                gerente.setIdade(result.getInt("idade"));
                gerente.setSexo(result.getString("sexo"));
                gerente.setEndereco(result.getString("endereco"));
                gerente.setTelefone(result.getString("telefone"));
                gerente.setContaBancaria(result.getString("numero_conta"));
                gerente.setPermissaoAdmin(result.getBoolean("permissao_admin"));
                gerente.setSenhaGerencial(result.getString("senha_gerencial"));
                gerentes.add(gerente);
            }

            result.close();
            statement.close();
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
        }

        return gerentes;
    }

    public Boolean updateGerente(Gerente gerente, int id){
        try{
            String sql = "UPDATE funcionario SET " + "nome = ?, " + "cpf = ?, " + "idade = ?, " + "sexo = ?, " + "endereco = ?, " + "telefone = ?, " + "numero_conta = ?, " + "permissao_admin = ?, " + "senha_gerencial = ? " +  "WHERE codigo_funcionario = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, gerente.getNome());
            statement.setString(2, gerente.getCpf());
            statement.setInt(3, gerente.getIdade());
            statement.setString(4, gerente.getSexo());
            statement.setString(5, gerente.getEndereco());
            statement.setString(6, gerente.getTelefone());
            statement.setString(7, gerente.getContaBancaria());
            statement.setBoolean(8, gerente.getPermissaoAdmin());
            statement.setString(9, gerente.getSenhaGerencial());
            statement.setInt(10, id);

            int atualizados = statement.executeUpdate();
            return atualizados > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }

    public Boolean delete(int id){
        try{
            String sql = "DELETE FROM funcionario WHERE " + "codigo_funcionario = ?;";

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

    public Boolean promote(int id, String senha_gerencial){
        try{
            String sql = "UPDATE funcionario SET permissao_admin = true, " + "senha_gerencial = ? " + "WHERE codigo_funcionario = ?;";

            Connection connection = Conexao.getConexao();
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, senha_gerencial);
            statement.setInt(2, id);

            int atualizados = statement.executeUpdate();
            return atualizados > 0;
        } catch(SQLException e){
            System.out.println("[ERRO]: " + e.getMessage());
            return false;
        }
    }
}
