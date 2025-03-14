import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonDataSheet;
    private TreeMap<String, Pokemon> userPokedex;

    public PokemonManager(Map<String, Pokemon> pokemonDataSheet) {
        this.pokemonDataSheet = pokemonDataSheet;
        this.userPokedex = new TreeMap<>();
    }

    public boolean addPokemon(String name) {
        if (!pokemonDataSheet.containsKey(name)) {
            return false; 
        }
        if (userPokedex.containsKey(name)) {
            return false; 
        }
        userPokedex.put(name, pokemonDataSheet.get(name));
        return true;
    }

    public Pokemon getPokemon(String name) {
        return pokemonDataSheet.get(name);
    }

    public List<String> sortUserPokemons() {
        return userPokedex.values().stream().sorted(Comparator.comparing(Pokemon::getType1)).map(Pokemon::getName).toList();
    }

    public List<String> sortAllPokemons() {
        return pokemonDataSheet.values().stream().sorted(Comparator.comparing(Pokemon::getType1)).map(Pokemon::getName).toList();
    }

    public List<String> searchByAbility(String ability) {
        List<String> result = new ArrayList<>();
        for (Pokemon pokemon : pokemonDataSheet.values()) {
            for (String abiliti : pokemon.getAbilities()) {
                if (abiliti.equalsIgnoreCase(ability)) {
                    result.add(pokemon.getName());
                }
            }
        }
        return result;
    }
}
