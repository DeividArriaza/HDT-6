//Clase para guardar datos de un pokemon
public class Pokemon{
    private String name;
    private String pokemonNum;
    private String type1;
    private String type2; 
    private String classification;
    private String height;
    private String weight;
    private String[] abilities;
    private String generation;
    private String legendaryStatus;

    //Constructor
    public Pokemon(String name, String pokemonNum, String type1, String type2, String classification, String height, String weight, String[] abilities, String generation, String legendaryStatus){
        this.name = name;
        this.pokemonNum = pokemonNum;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String getPokemonNum(){
        return pokemonNum;
    }

    public String getType1(){
        return type1;
    }

    public String getType2(){
        return type2;
    }

    public String getClassification(){
        return classification;
    }

    public String getHeight(){
        return height;
    }

    public String getWeight(){
        return weight;
    }

    public String getGeneration(){
        return generation;
    }

    public String getLegendaryStatus(){
        return legendaryStatus;
    }

    public String[] getAbilities(){
        return abilities;
    }

    @Override
    public String toString(){
        //Escribir todos los datos del pokemón
        return "";
    }
}