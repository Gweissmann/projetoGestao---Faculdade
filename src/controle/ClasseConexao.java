package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClasseConexao {

    public static Connection getConnection() {
        Connection connection = null;          //atributo do tipo Connection

        try {
            // Carregando o JDBC Driver padrão
           String driverName = "com.mysql.jdbc.Driver";

            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost:3306";    //caminho do servidor do BD

            String mydatabase = "projetogestao";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD      

            String password = "";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
           
            return connection;

      } catch (ClassNotFoundException e) {  //Driver não encontrado

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println(e);
            return null;

        }

    }


    
    
    
    
    
    
    
    
    
    
    /*.prepareStatement("insert into "
                    + "filme(titulo,descricao,duracao,genero,lancamento) "
                    + "values (?,?,?,?,?)");

    insert into

    filme(filme_cod, titulo, descricao, duracao, genero, lancamento)

    values ("X-men", "descricao teste","23:00","acao","abril");

    insere.setString (
            

    1, titulo);
    insere.setString (
            

    2, descricao);
    insere.setString (
            

    3, duracao);
    insere.setString (
            

    4, genero);
    insere.setString (
            
    5, lancamento);
			//Executar o comando
			int qtdeLinhasAfetadas = insere.executeUpdate();

    System.out.println (
            

    "Linhas Afetadas: "+qtdeLinhasAfetadas);
			//Fechar o comando e a conex�o
    insere.close ();

    con.close ();

    catch(SQLException e

    
        ){
			System.err.println(e);
    }
    catch(Exception e

    
        ){
			System.err.println(e);
    }*/
}
