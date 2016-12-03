
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
    private String name, instructions;
    private int time, numUses,id;//time is in seconds
    private List<Ingredient> ingredients;
    
    public Recipe(int id,String name, String instructions, int time, List<Ingredient> ingredients){
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.time = time;
        this.ingredients = ingredients;
        numUses = 0;
    }
    
    public Recipe(int id, String name, String instructions, int time){
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.time = time;
        this.ingredients = new ArrayList<>();
        numUses = 0;
    }
    
    public Recipe(){
        ingredients = new ArrayList<>();
    }
    public Recipe(Recipe r){
        this.name = r.getName();
        this.instructions = r.getInstructions();
        this.time = r.getTime();
        this.numUses = r.getNumUses();
        this.id = r.getId();
        this.ingredients = r.getIngredients();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getNumIngredients(){
        return ingredients.size();
    }
    public int getNumUses(){
        return numUses;
    }
    
    public List<Ingredient> useRecipe(){
        numUses++;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public String getPrettyInstructions(){
        String[] parts = instructions.split("\\.");
        String returnString = " ";
        for(String s: parts){
            returnString += s +".\n";
        }
        return returnString;
    }
    public int getTime() {
        return time;
    }
    public String getDisplayTime(){
        return (time/3600) + ":" + ((time/60)%60) + ":" + (time%60);
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
    
    @Override
    public String toString(){
        String returnString = "Id: " + id +
                              "\nName: " + name +
                              "Ingredients: \n";
        for(Ingredient i: ingredients){
            returnString+= i.toString();
        }
        returnString += "\nInstructions: \n" + instructions +"\n" + 
                        "Time: " + time;
        
        return returnString;
    }
    
    
}
