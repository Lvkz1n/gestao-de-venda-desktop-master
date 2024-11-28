
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
    private final String URL = "jdbc:mysql://localhost/studio_grafica?useTimezone=true&serverTimezone=America/Recife";
    private final String USER = "root";
    private final String PASSWORD = "12345678";

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
