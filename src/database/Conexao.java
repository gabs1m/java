package database;

import java.sql.*;

public class Conexao {
    public static Connection getConexao(){
        try {
            final String url = "jdbc:mysql://localhost:3306/escola";
            final String user = "root";
            final String senha = "";

            Connection connection = DriverManager.getConnection(url, user, senha);
            return connection;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
