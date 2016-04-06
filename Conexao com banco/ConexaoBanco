package InterfaceGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClasseConexao {
	static final String DATABASE_URL =
			"jdbc:mysql://127.0.0.1:3306/locadora";
	static Connection con = null;
			String user = "root";
			String pass = "root;"
			String titulo = "x-men";
			int codFilme = 1;
			//Criar a conex�o
			con = DriverManager.getConnection(
					DATABASE_URL,"root","root");
			//Cria��o do comando
			PreparedStatement insere =
					con.prepareStatement("insert into "
							+ "filme(titulo,descricao,duracao,genero,lancamento) "
							+ "values (?,?,?,?,?)");

							insert into filme(filme_cod,titulo,descricao,duracao,genero,lancamento) values ("X-men", "descricao teste","23:00","acao","abril");

			insere.setString(1, titulo);
			insere.setString(2, descricao);
			insere.setString(3, duracao);
			insere.setString(4, genero);
			insere.setString(5, lancamento);
			//Executar o comando
			int qtdeLinhasAfetadas = insere.executeUpdate();
			System.out.println("Linhas Afetadas: "+qtdeLinhasAfetadas);
			//Fechar o comando e a conex�o
			insere.close();
			con.close();
		}
		catch(SQLException e){
			System.err.println(e);
		}
		catch(Exception e){
			System.err.println(e);
		}
	}

}
