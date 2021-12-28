package aplicacao;

import dao.PokemonDAO;
import pokedex.Pokemon;

public class Main {

	public static void main(String[] args) {

		PokemonDAO pokemonDAO = new PokemonDAO();
		int aux = 0;

		switch(aux) {
		
		case 1:
			pokemonDAO.save(null);
			
		
		}
		
		Pokemon pokemon = new Pokemon();
		pokemon.setNome("Malboro");
		pokemon.setTipo("Câncer");

		
		//pokemonDAO.save(pokemon);
		
		//atualizar pokemon
		Pokemon c1 = new Pokemon();
		c1.setNome("Raiquaza");
		c1.setId(13);
		c1.setTipo("Lendário");
		
		
		//pokemonDAO.update(c1);
		
		//Deletar pokemon pelo id
		pokemonDAO.deleteByID(13);
		
		
		
		//visualização dos registros de pokemon
		for(Pokemon c : pokemonDAO.getPokemons()) {
			System.out.println("Pokemon: "+ c.getNome());
		}
		
	}

}
	
