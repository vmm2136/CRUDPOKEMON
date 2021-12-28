package factor;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConectionFactor {

	//Nome do usuário
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "816816vm";
	
	//Caminho do Banco, porta, nome do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pokedex";
	
	/*
	 * Conexão com o banco de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz a classe ser carregada pela JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Cria a conexão com o banco
		Connection connection = (Connection) DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main (String[] args) throws Exception {
		
		//recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//testar conexão
		if (con!=null) {
			System.out.println("Conexão obtida com sucesso");
			con.close();
		}
	
	}
}
