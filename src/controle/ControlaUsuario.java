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
<<<<<<< HEAD
    //classe de adicao de usuario
    public void adicionarUsuario(MUsuario usuario) throws SQLException {
=======

    public void adicionarUsuario() throws SQLException {
        MUsuario usuario = MUsuario.getInstance();
>>>>>>> projetoGestao
        criarConexao();
        if (con != null) {
            //parametros do banco de dados
            PreparedStatement insere = con.prepareStatement("insert into usuario(nome,email,senha,confirmacaoSenha,salarioMensal,rendaExtra) values (?,?,?,?,?,?)");
<<<<<<< HEAD
            //pega valores do metodo de alimentaçao e insere no banco
            insere.setString(1,usuario.getNome());
            insere.setString(2,usuario.getEmail());
            insere.setString(3,usuario.getSenha());
            insere.setString(4,usuario.getConfirmasenha());
            insere.setDouble(5,usuario.getSalarioMensal());
            insere.setDouble(6,usuario.getRendaExtra());
=======
            //alimenta metodo de inserir usuario
            insere.setString(1, usuario.getNome());
            insere.setString(2, usuario.getEmail());
            insere.setString(3, usuario.getSenha());
            insere.setString(4, usuario.getConfirmasenha());
            insere.setDouble(5, usuario.getSalarioMensal());
            insere.setDouble(6, usuario.getRendaExtra());
>>>>>>> projetoGestao
            try {

                insere.execute();
                insere.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
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
