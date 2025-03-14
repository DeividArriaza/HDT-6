import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class PokemonManagerTest {
    
    @Test
    public void testAddPokemon() {

        Map<String, Pokemon> pokemonDataSheet = new HashMap<>();

        String[] abilities1 = {"Overgrow", "Chlorophyll"};
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "001", "Grass", "Poison", "Seed Pokémon", "0.7m", "6.9kg", abilities1, "1", "false");

        String[] abilities2 = {"Blaze", "Solar Power"};
        Pokemon charmander = new Pokemon("Charmander", "004", "Fire", "None", "Lizard Pokémon", "0.6m", "8.5kg", abilities2, "1", "false");

        String[] abilities3 = {"Torrent", "Rain Dish"};
        Pokemon squirtle = new Pokemon("Squirtle", "007", "Water", "None", "Tiny Turtle Pokémon", "0.5m", "9.0kg", abilities3, "1", "false");

        pokemonDataSheet.put(bulbasaur.getName(), bulbasaur);
        pokemonDataSheet.put(charmander.getName(), charmander);
        pokemonDataSheet.put(squirtle.getName(), squirtle);

        Assert.assertEquals(3, pokemonDataSheet.size());
        Assert.assertTrue(pokemonDataSheet.containsKey("Bulbasaur"));
        Assert.assertTrue(pokemonDataSheet.containsKey("Charmander"));
        Assert.assertTrue(pokemonDataSheet.containsKey("Squirtle"));
    }

    @Test
    public void testSearchByAbility() {
        Map<String, Pokemon> pokemonDataSheet = new HashMap<>();
        
        String[] abilities1 = {"Overgrow", "Chlorophyll"};
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "001", "Grass", "Poison", "Seed Pokémon", "0.7m", "6.9kg", abilities1, "1", "false");
        
        String[] abilities2 = {"Blaze", "Solar Power"};
        Pokemon charmander = new Pokemon("Charmander", "004", "Fire", "None", "Lizard Pokémon", "0.6m", "8.5kg", abilities2, "1", "false");
        
        pokemonDataSheet.put(bulbasaur.getName(), bulbasaur);
        pokemonDataSheet.put(charmander.getName(), charmander);

        boolean found = false;
        for (Pokemon pokemon : pokemonDataSheet.values()) {
            for (String ability : pokemon.getAbilities()) {
                if (ability.equals("Overgrow")) {
                    found = true;
                }
            }
        }

        Assert.assertTrue(found);
    }

    @Test
    public void testSortAllPokemons() {
        Map<String, Pokemon> pokemonDataSheet = new HashMap<>();

        pokemonDataSheet.put("Bulbasaur", new Pokemon("Bulbasaur", "001", "Grass", "Poison", "Seed Pokémon", "0.7m", "6.9kg", new String[]{"Overgrow", "Chlorophyll"}, "1", "false"));
        pokemonDataSheet.put("Charmander", new Pokemon("Charmander", "004", "Fire", "None", "Lizard Pokémon", "0.6m", "8.5kg", new String[]{"Blaze", "Solar Power"}, "1", "false"));
        pokemonDataSheet.put("Squirtle", new Pokemon("Squirtle", "007", "Water", "None", "Tiny Turtle Pokémon", "0.5m", "9.0kg", new String[]{"Torrent", "Rain Dish"}, "1", "false"));

        String[] expectedOrder = {"Bulbasaur", "Charmander", "Squirtle"};
        String[] sortedNames = pokemonDataSheet.keySet().stream().sorted().toArray(String[]::new);

        Assert.assertArrayEquals(expectedOrder, sortedNames);
    }
}
