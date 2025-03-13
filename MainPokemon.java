import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;

public class MainPokemon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MapFactory factory = new ChoiceMap();
        int end  = 0;
        String line;
        String pokeName; 

        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Ingrese el número de la opción con la que desea almacenar los datos: ");
        int option = input.nextInt();
        Map<String, Pokemon> pokemonDataSheet = factory.createMap(option);
        TreeMap<String, Pokemon> userPokedex = new TreeMap<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader("pokemon_data_pokeapi.csv"))) {
            br.readLine(); 
            //Se lee fila por fila, separándose por comas los datos
            while ((line = br.readLine()) != null) {
                String[] data;
                String name;
                String pokemonNum;
                String type1;
                String type2;
                String classification;
                String height;
                String weight;
                String[] abilities;
                String generation;
                String legendaryStatus;

                if(line.indexOf( "\"") > 0){ //almacenamiento de datos para pokemones con varias habilidades
                    int first = line.indexOf("\"");
                    int last = line.indexOf("\"", first +1);
                    abilities = line.substring(first+1, last).split(",");
                    line = line.substring(0,first) + line.substring(last+2);
                    System.out.println(line);
                    data = line.split(",");
                    name = data[0].trim();
                    pokemonNum = data[1].trim();
                    type1 = data[2].trim();
                    type2 = data[3].trim();
                    classification = data[4];
                    height = data[5];
                    weight = data[6];
                    generation = data[7];
                    legendaryStatus = data[8];
                }
                else{ //almacenamiento de datos para pokemones con una sola habilidad
                    data = line.split(",");
                    name = data[0].trim();
                    pokemonNum = data[1].trim();
                    type1 = data[2].trim();
                    type2 = data[3].trim();
                    classification = data[4];
                    height = data[5];
                    weight = data[6];
                    abilities = data[7].split(",");
                    generation = data[8];
                    legendaryStatus = data[9];
                }

                Pokemon pokemon = new Pokemon(name, pokemonNum, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                //Guardar en Map
                pokemonDataSheet.put(name, pokemon);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV");
        }

        //Menú
        while(end==0){
            System.out.println("Menú de opciones para su pokemón");
            System.out.println("1. Agregar pokemón a tu colección");
            System.out.println("2. Ver datos de un pokemón en general");
            System.out.println("3. Mostrar nombre y tipo 1 de tu colección");
            System.out.println("4. Mostrar nombre y tipo 1 de todos los pokemones existentes");
            System.out.println("5. Mostrar pokemones según la habilidad indicada");
            System.out.println("6. Salir");
            System.out.print("Ingresar el número de la opción que desea realizar: ");
            option = input.nextInt();

            if(option==1){
                System.out.print("Ingrese el nombre del pokemon que desea agregar: ");
                pokeName = input.nextLine();
                pokeName = input.nextLine();
                if(!(userPokedex.containsKey(pokeName)) && pokemonDataSheet.containsKey(pokeName)){
                    userPokedex.put(pokeName, pokemonDataSheet.get(pokeName));
                }
                else{
                    System.out.println("No se pudo agregar el pokemón");
                }
            }
            
            if(option==2){
                System.out.print("Ingrese el nombre del pokemon que desea buscar: ");
                pokeName = input.nextLine();
                pokeName = input.nextLine();
                if(pokemonDataSheet.containsKey(pokeName)){
                    System.out.println();
                    System.out.println(pokemonDataSheet.get(pokeName).toString());
                }
                else{
                    System.out.println("Este pokemón no se encuentra");
                }
            }
            
            if(option==6){
                end  = 1;
            }
            System.out.println();
                    
        }

    }
}
