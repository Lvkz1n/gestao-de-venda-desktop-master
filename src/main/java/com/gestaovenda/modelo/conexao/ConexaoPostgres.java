
package com.gestaovenda.modelo.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Luiz & Pedro
 */
public class ConexaoPostgres implements Conexao{

    @Override
    public Connection obterConexao() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fecharConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
