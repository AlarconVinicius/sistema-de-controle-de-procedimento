/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Models;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedures {

    private int id;
    private String name;
    private String description;
    private double price;

    public AestheticProcedures() {
    }

    public AestheticProcedures(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public AestheticProcedures(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(this.id).append(", ")
            .append("Name = ").append(this.name).append(", ")
            .append("Description = ").append(this.description).append(", ")
            .append("Price = ").append(this.price);
        return sb.toString();
    }

    
}
