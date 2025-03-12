import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class MainPokemon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MapFactory factory = new ChoiceMap();
        int finalizar  = 0;
        String line;

        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.println("Ingrese el número de la opción con la que desea almacenar los datos: ");
        int option = input.nextInt();
        Map<String, Pokemon> pokemonDataSheet = factory.createMap(option);

        try (BufferedReader br = new BufferedReader(new FileReader("pokemon_data_pokeapi.csv"))) {
            br.readLine(); 
            //Se lee fila por fila, separándose por comas los datos
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                //Almacenamiento da datos
                String name = data[0].trim();
                String pokemonNum = data[1].trim();
                String type1 = data[2].trim();
                String type2 = data[3].trim();
                String classification = data[4];
                String height = data[5];
                String weight = data[6];
                String[] abilities = data[7].split(",");
                String generation = data[8];
                String legendaryStatus = data[9];
                Pokemon pokemon = new Pokemon(name, pokemonNum, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                //Guardar en Map
                pokemonDataSheet.put(name, pokemon);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV");
        }

        //Menú
        while(finalizar==0){
            System.out.println("Menú de opciones para su pokemón");
            System.out.println("1. Agregar pokemón a tu colección");
            System.out.println("2. Ver datos de un pokemón en general");
            System.out.println("3. Mostrar nombre y tipo 1 de tu colección");
            System.out.println("4. Mostrar nombre y tipo 1 de todos los pokemones existentes");
            System.out.println("5. Mostrar pokemones según la habilidad indicada");
            System.out.println("6. Salir");
            System.out.println("Ingresar el número de la opción que desea realizar: ");
            option = input.nextInt();

            switch(option){
                case 1:
                case 2: 
                case 3:
                case 4: 
                case 5:
                case 6: 
            }
        }

    }
}
