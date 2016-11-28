
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcastaldi
 */
public class Recipe {
    private String name, description;
    private int time, numUsed;//time is in seconds
    private List<Ingredient> ingredients;
    
    public Recipe(String name, String description, int time, List<Ingredient> ingredients){
        this.name = name;
        this.description = description;
        this.time = time;
        this.ingredients = ingredients;
        numUsed = 0;
    }
    
    public Recipe(String name, String description, int time){
        this.name = name;
        this.description = description;
        this.time = time;
        this.ingredients = new ArrayList<>();
        numUsed = 0;
    }

    public int getNumIngredients(){
        return ingredients.size();
    }
    public int getNumUsed(){
        return numUsed;
    }
    
    public List<Ingredient> useRecipe(){
        numUsed++;
        return ingredients;
    }
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    
}
