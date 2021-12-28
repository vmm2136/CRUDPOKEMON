package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factor.ConectionFactor;
import pokedex.Pokemon;

public class PokemonDAO {
	
	/*
	 * CRUD
	 * C: CREATE - feito
	 * R: READ	 - feito
	 * U: UPDATE - feito
	 * D: DELETE - feito
	 */
	
	public void save(Pokemon pokemon) {
		
		String sql = "INSERT INTO pokemon(nome, tipo) VALUES (?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
	
		try {
			//Cria uma coenxão com o banco
			conn = ConectionFactor.createConnectionToMySQL();
			
			//Criado para executar uma querry
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar valores na querry
			pstm.setString(1, pokemon.getNome());
			pstm.setString(2, pokemon.getTipo());
			
			//executar a querry
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//fechar as conexões
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Pokemon> getPokemons(){
		
		String sql = "SELECT * FROM pokemon";
		
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera dados do banco
		ResultSet rst = null;
		
		try {
			conn = ConectionFactor.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
		
			rst = pstm.executeQuery();
			
			while (rst.next()) {
				Pokemon pokemon = new Pokemon();
				
				//Recuperar ID
				pokemon.setId(rst.getInt("id"));
				
				//recuperar nome
				pokemon.setNome(rst.getString("nome"));
				
				//recuperar tipo
				pokemon.setTipo(rst.getString("tipo"));
				
				
				pokemons.add(pokemon);
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
			
			
		}finally {
			
			try { 
				
			
			if(rst != null) {
				rst.close();
			}
			
			if(pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	return pokemons;
	}
	
	public void update(Pokemon pokemon) {
		String sql = "UPDATE pokemon SET nome = ?, tipo = ? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			//Cria conexão
			conn = ConectionFactor.createConnectionToMySQL();
			
			//Criar a classe para executar a querry
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Valores para atualizar
			pstm.setString(1, pokemon.getNome());
			pstm.setInt(3, pokemon.getId());
			pstm.setString(2, pokemon.getTipo());


			//executar
			pstm.execute();
		
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID (int id) {
		
		String sql = "DELETE from pokemon Where id = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			conn = ConectionFactor.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
		
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	