/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.MConta;
import modelo.MTabela;
import modelo.MUsuario;

/**
 *
 * @author Bruno
 */
public class ControlaContas {

    ConectaBanco conexao = new ConectaBanco();

    public void adicionarConta(MConta conta) throws SQLException {
        MUsuario usuario = MUsuario.getInstance();
        conexao.conexao();
        try {
            PreparedStatement insere = conexao.conn.prepareStatement("insert into cadastroConta(tipoTitulo,nome,DataCadastro,DataVencimento,numeroParcelas,valor,idCliente,juros) values (?,?,?,?,?,?,?,?)");
            //alimenta metodo de inserir conta
            insere.setString(1, conta.getTipoTitulo());
            insere.setString(2, conta.getNome());
            insere.setString(3, conta.getJdcDataCadastro());
            insere.setString(4, conta.getJdcDataVencimento());
            insere.setInt(5, conta.getNumeroParcelas());
            insere.setDouble(6, conta.getValor());
            insere.setInt(7, usuario.getIdUsuario());
            insere.setDouble(8, conta.getJurosDia());

            insere.executeUpdate();
            insere.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Inserção \n Erro:" + ex);
        }
    }
}
