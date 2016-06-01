/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.MUsuario;

/**
 *
 * @author GWEISSMANN
 */
public class ConectaBanco {

    public Statement stm; // responsável preparar e realizar pesquisas no banco de dados
    public ResultSet rs;// responsável por armezenar os resultados de uma pesquisa passa para o statement
    private String driver = "com.mysql.jdbc"; //responsável por identificar o banco de dados, serviço de banco de dados
    private String caminho = "jdbc:mysql://localhost:3306/projetogestao"; //responsável por setar o local do banco de dados
    private String usuario = "root";
    private String senha = "";
    public Connection conn; // responsável por realizar a conexão com o banco de dados    

    public void conexao() { // Metodo necessário pra realizar a conexão com o banco

        try {// tentiva inicial
            System.setProperty("jdbc.Driver", driver); //seta a propriedade do driver de conexão
            conn = DriverManager.getConnection(caminho, usuario, senha); // realiza a conexão com o banco de dados
            //JOptionPane.showMessageDialog(null,"Conectado com Sucesso!"); // Imprime a conexão

        } catch (SQLException ex) { //excessão
            JOptionPane.showMessageDialog(null, "Erro de conexão! \n Erro:" + ex.getMessage());
        }

    }

    public void executaSQL(String sql) {
        
        try {
            stm = (Statement) conn.prepareStatement(sql);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL! \n Erro:" + ex.getMessage());
        }

    }

    public void desconecta() { // Metodo para fechar a conexão
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão! \n Erro:" + ex.getMessage());
        }

    }
}
