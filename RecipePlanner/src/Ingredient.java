/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcastaldi, kdrexler
 */
public class Ingredient {
    String name, description, unitOfMeasure;
    int amount, id;
    
    public Ingredient(int id,String name, String description,int amount){
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
    
    public Ingredient(){
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        return  "\nId: " + id +
                "\nName: " + name +
                "\nAmount: " + amount +
                "\nUnit: " + unitOfMeasure;
    }
    
}
