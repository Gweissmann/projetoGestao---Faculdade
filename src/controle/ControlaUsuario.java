/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.MUsuario;

/**
 *
 * @author Bruno
 */
public class ControlaUsuario {

    Connection con;

    public void criarConexao() {
        try {
            con = ClasseConexao.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarUsuario() throws SQLException {
        MUsuario usuario = MUsuario.getInstance();
        criarConexao();
        if (con != null) {
            PreparedStatement insere = con.prepareStatement("insert into usuario(nome,email,senha,salarioMensal,rendaExtra) values (?,?,?,?,?)");
            //alimenta metodo de inserir usuario
            insere.setString(1, usuario.getNome());
            insere.setString(2, usuario.getEmail());
            insere.setString(3, usuario.getSenha());
            insere.setDouble(4, usuario.getSalarioMensal());
            insere.setDouble(5, usuario.getRendaExtra());
            try {

                insere.execute();
                insere.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //pega parametro do usuario
    public void getUserParameters(String email) throws SQLException {
        criarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email='" + email + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                MUsuario usuario = MUsuario.getInstance();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setRendaExtra(rs.getDouble("rendaExtra"));
                usuario.setSalarioMensal(rs.getDouble("salarioMensal"));
                usuario.setNome(rs.getString("nome"));
            }
        } catch (Exception e) {
            if (stmt != null) {
                stmt.close();
            }
            e.printStackTrace();
        }
    }

    public boolean getLogin(String email, String senha) throws SQLException {
        boolean senhaIgual = false;
        criarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email='" + email + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String senhaPara = rs.getString("senha");
                MUsuario usuario = MUsuario.getInstance();
                usuario.setIdUsuario(rs.getInt("idUsuario"));

                if (senha.compareTo(senhaPara) == 0) {
                    senhaIgual = true;
                    getUserParameters(email);

                } else {
                    senhaIgual = false;
                }
            }
        } catch (Exception e) {
            if (stmt != null) {
                stmt.close();
            }
            e.printStackTrace();
        }

        return senhaIgual;
    }

}
