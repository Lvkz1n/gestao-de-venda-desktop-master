
package com.gestaovenda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luiz & Pedro
 */
public class ConexaoMysql implements Conexao{
    
    private Connection connection;
    private  String URL = "jdbc:mysql://localhost:3306/gestaografica?useTimezone=true&serverTimezone=America/Recife";
    private  String USER = "root";
    private  String PASSWORD = "12345678";

    @Override
    public Connection obterConexao() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    @Override
    public void fecharConexao() throws SQLException {
        if(connection != null)
            connection.close();
    }

}
