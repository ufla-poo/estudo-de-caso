package br.ufla.dcc.ppoo.modelo;

import java.util.Arrays;
import javax.swing.JPasswordField;

/**
 * Representa um usuário do sistema.
 */
public class Usuario {
    private String login;
    private char[] senha;
    private String nome;

    public Usuario(String login, char[] senha, String nome) {
        this.login = login;
        this.senha = Arrays.copyOf(senha, senha.length);
        this.nome = nome;
    }
    
    public boolean validarUsuario(String login, char[] senha) {
        return (this.login.equals(login) && Arrays.equals(this.senha, senha));
    }
}
