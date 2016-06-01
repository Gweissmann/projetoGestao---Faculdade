/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controle.ConectaBanco;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gnweissmann
 */
public class MTabela {

    
    ConectaBanco conexao = new ConectaBanco();
    MUsuario usuario = MUsuario.getInstance();
    public DefaultTableModel modelo = new DefaultTableModel();
    public void preencherTable() {
        conexao.conexao();
        
         
        //Integer idUsuario = usuario.getIdUsuario();
        
        //"SELECT * FROM usuario WHERE email='" + email + "'"
        
        conexao.executaSQL("SELECT cadastroconta.* FROM cadastroconta,usuario WHERE cadastroconta.idCliente = usuario.idUsuario");
        try {
            conexao.rs.first();
            do {
                modelo.addRow(new Object[]{
                    conexao.rs.getString("idCadastroConta"),
                    conexao.rs.getString("tipoTitulo"),
                    conexao.rs.getString("nome"),
                    conexao.rs.getInt("numeroParcelas"),
                    conexao.rs.getInt("valor"),
                    conexao.rs.getInt("juros"),
                    conexao.rs.getString("dataCadastro"),
                    conexao.rs.getString("dataVencimento")});

            } while (conexao.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Preenhimento \n Erro:" + ex);
        }

    }
}
