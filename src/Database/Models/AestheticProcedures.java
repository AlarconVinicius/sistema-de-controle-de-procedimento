/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Models;

/**
 * Classe que representa procedimentos estéticos.
 * Cada procedimento estético possui um nome, descrição e preço.
 * 
 * @author Alarcon Vinicius
 */
public class AestheticProcedures {

    /**
     * O identificador único do procedimento estético.
     */
    private int id;

    /**
     * O nome do procedimento estético.
     */
    private String name;

    /**
     * A descrição detalhada do procedimento estético.
     */
    private String description;

   /**
     * O preço do procedimento estético.
     */
    private double price;

    /**
     * Construtor padrão da classe `AestheticProcedures`.
     */
    public AestheticProcedures() {
    }

    /**
     * Construtor que inicializa um objeto `AestheticProcedures` com nome, descrição e preço.
     * 
     * @param name O nome do procedimento estético.
     * @param description A descrição detalhada do procedimento estético.
     * @param price O preço do procedimento estético.
     */
    public AestheticProcedures(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Construtor que inicializa um objeto `AestheticProcedures` com um identificador único, nome, descrição e preço.
     * 
     * @param id O identificador único do procedimento estético.
     * @param name O nome do procedimento estético.
     * @param description A descrição detalhada do procedimento estético.
     * @param price O preço do procedimento estético.
     */
    public AestheticProcedures(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Obtém o identificador único do procedimento estético.
     * 
     * @return O identificador único do procedimento estético.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do procedimento estético.
     * 
     * @param id O identificador único do procedimento estético.
     */
    public void setId(int id) {
        this.id = id;
    }

   /**
     * Obtém o nome do procedimento estético.
     * 
     * @return O nome do procedimento estético.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do procedimento estético.
     * 
     * @param name O nome do procedimento estético.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a descrição detalhada do procedimento estético.
     * 
     * @return A descrição detalhada do procedimento estético.
     */
    public String getDescription() {
        return description;
    }

     /**
     * Define a descrição detalhada do procedimento estético.
     * 
     * @param description A descrição detalhada do procedimento estético.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém o preço do procedimento estético.
     * 
     * @return O preço do procedimento estético.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Define o preço do procedimento estético.
     * 
     * @param price O preço do procedimento estético.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retorna uma representação em string do objeto `AestheticProcedures`.
     * 
     * @return Uma string que representa o objeto `AestheticProcedures`.
     */
    @Override
    public String toString() {
        return getName();
    }

    
}
