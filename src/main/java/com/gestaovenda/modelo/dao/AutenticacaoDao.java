package com.gestaovenda.modelo.dao;

import com.gestaovenda.modelo.entidades.PERFIL;
import com.gestaovenda.modelo.entidades.Usuario;
import com.gestaovenda.modelo.exception.NegocioException;
import com.gestaovenda.view.modelo.LoginDto;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Luiz & Pedro
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    public boolean temPermissao(Usuario usuario) {
        try {
            permissao(usuario);
            return true;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    private void permissao(Usuario usuario) {
        if(!PERFIL.ADMIN.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem permissao para realizar essa accao.");
        }
    }

    public Usuario login(LoginDto login) {
    Usuario usuario = usuarioDao.buscarUsuarioPeloUsername(login.getUsername());
    
    if (usuario == null || !usuario.isEstado()) {
        return null;
    }
    
    // Verifica a senha diretamente, sem criptografia (não seguro)
    if (usuario.isEstado() && usuario.getSenha().equals(login.getSenha())) {
        usuarioDao.actualizarUltimoLogin(usuario);
        return usuario;
    }
    return null;
}
    
//    private boolean validaSenha(String usuarioSenha, String loginSenha) {
//        return usuarioSenha.equals(loginSenha);
//    }
    
    private boolean validaSenha(String usuarioSenha, String loginSenha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(loginSenha, usuarioSenha);
    }
    
}