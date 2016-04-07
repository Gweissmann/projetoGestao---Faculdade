/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public void adicionarUsuario(MUsuario usuario) throws SQLException {
        criarConexao();
        if (con != null) {
            PreparedStatement insere = con.prepareStatement("insert into usuario(nome,email,senha,confirmacaoSenha,salarioMensal,rendaExtra) values (?,?,?,?,?,?)");
            insere.setString(1,usuario.getNome());
            insere.setString(2,usuario.getEmail());
            insere.setString(3,usuario.getSenha());
            insere.setString(4,usuario.getConfirmasenha());
            insere.setDouble(5,usuario.getSalarioMensal());
            insere.setDouble(6,usuario.getRendaExtra());
            try {

                insere.execute();
                insere.close();
                con.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
