/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.MConta;

/**
 *
 * @author Bruno
 */
public class ControlaContas {

    // adicionar inserts delets e atualization 
    Connection con;

    public void criarConexao() {
        try {
            con = ClasseConexao.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarConta(MConta conta) throws SQLException {
        criarConexao();
        if (con != null) {
            PreparedStatement insere = con.prepareStatement("insert into cadastroConta(tipoTitulo,nome,dataCadastro,dataVencimento,numeroParcelas,valor) values (?,?,?,?,?,?)");
            insere.setString(1,conta.getTipoTitulo());
            insere.setString(2,conta.getNome());
            insere.setString(3,conta.getDataCadastro());
            insere.setString(4,conta.getDataVencimento());
            insere.setInt(5,conta.getNumeroParcelas());
            insere.setDouble(6,conta.getValor());
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