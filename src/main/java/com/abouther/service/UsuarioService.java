package com.abouther.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.abouther.DAO.IUsuario;
import com.abouther.model.Usuario;

@Service
public class UsuarioService {
    
    private IUsuario dao;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario dao) {
        this.dao = dao;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = dao.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoder);
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    public Usuario editarUsuario(Usuario usuario) {

        Usuario usuarioExistente = dao.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        String encoder = this.passwordEncoder.encode(usuario.getSenha());
        usuarioExistente.setSenha(encoder);
        Usuario usuarioNovo = dao.save(usuarioExistente);
        return usuarioNovo;
    }

    public Boolean deletarUsuario(Integer id) {
        dao.deleteById(id);
        return true;
    }

    //@SuppressWarnings("deprecation")
    public Boolean validarSenha(Usuario usuarioEncontrado) {
        // Adicione logs para verificar as senhas
        System.out.println("Senha para validar: " + usuarioEncontrado.getSenha());
    
        Usuario usuarioBD = dao.findByEmail(usuarioEncontrado.getEmail());
        if (usuarioBD == null) {
            System.out.println("Usuário não encontrado.");
            return false;
        }
    
        System.out.println("Senha armazenada: " + usuarioBD.getSenha());
    
        Boolean isValid = passwordEncoder.matches(usuarioEncontrado.getSenha(), usuarioBD.getSenha());
        System.out.println("Senha válida: " + isValid);
        return isValid;
    }

}
