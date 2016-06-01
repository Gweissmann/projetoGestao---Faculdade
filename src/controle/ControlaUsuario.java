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
import javax.swing.JOptionPane;
import modelo.MUsuario;

/**
 *
 * @author Bruno
 */
public class ControlaUsuario {

    ConectaBanco conexao = new ConectaBanco();
    MUsuario usuario = MUsuario.getInstance();

    public void adicionarUsuario() throws SQLException {
        
        conexao.conexao();

        try {
            PreparedStatement insere = conexao.conn.prepareStatement("insert into usuario(nome,email,senha,salarioMensal,rendaExtra) values (?,?,?,?,?)"); //alimenta metodo de inserir usuario
            insere.setString(1, usuario.getNome());
            insere.setString(2, usuario.getEmail());
            insere.setString(3, usuario.getSenha());
            insere.setDouble(4, usuario.getSalarioMensal());
            insere.setDouble(5, usuario.getRendaExtra());

            insere.executeUpdate();
            insere.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Inserção \n Erro:" + ex);

        }

    }
    
    
    public void UpdateUsuario(String email) throws SQLException {
        
        conexao.conexao();

        try {
            PreparedStatement update = conexao.conn.prepareStatement("UPDATE usuario SET nome=?, senha=?, salarioMensal=?, rendaExtra=?  WHERE email='" + email + "'"); //Faz a atualização do usuario logado
            update.setString(1, usuario.getNome());
            update.setString(3, usuario.getSenha());
            update.setDouble(4, usuario.getSalarioMensal());
            update.setDouble(5, usuario.getRendaExtra());

            update.executeUpdate();
            update.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Inserção \n Erro:" + ex);

        }

    }
    

//pega parametro do usuario
    public void getUserParameters(String email) throws SQLException {
       
        conexao.conexao();
        PreparedStatement stmt = null;
        try {
            stmt = conexao.conn.prepareStatement("SELECT * FROM usuario WHERE email='" + email + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSalarioMensal(rs.getDouble("salarioMensal"));
                usuario.setRendaExtra(rs.getDouble("rendaExtra"));

            }
        } catch (Exception e) {
            if (stmt != null) {
                stmt.close();
            }
            e.printStackTrace();
        }
    }

    public boolean getLogin(String email, String senha) throws SQLException {
        conexao.conexao();
        boolean senhaIgual = false;

        PreparedStatement stmt = null;
        try {
            stmt = conexao.conn.prepareStatement("SELECT * FROM usuario WHERE email='" + email + "'");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String senhaPara = rs.getString("senha");
               
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
