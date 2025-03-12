//Clase para guardar datos de un pokemon
public class Pokemon{
    private String name;
    private int pokemonNum;
    private String type1;
    private String type2; 
    private String[] classification;
    private float height;
    private float weight;
    private int generation;
    private String legendaryStatus;

    //Constructor
    public Pokemon(String name, int pokemonNum, String type1, String type2, String classification, float height, float weight, int generation, String legendaryStatus){
        this.name = name;
        this.pokemonNum = pokemonNum;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.generation = legendaryStatus;
    }

    //Getters
    public String getName(){
        return name;
    }

    public int getPokemonNum(){
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

    public float getHeight(){
        return height;
    }

    public float getWeight(){
        return weight;
    }

    public int getGeneration(){
        return generation;
    }

    public String getLegendaryStatus(){
        return legendaryStatus;
    }
}