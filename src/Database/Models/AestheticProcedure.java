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
public class AestheticProcedure {

    /**
     * O identificador único do procedimento estético.
     */
    private int id;

    /**
     * O nome do procedimento estético.
     */
    private String name;

   /**
     * O preço do procedimento estético.
     */
    private double price;

    /**
     * Construtor padrão da classe `AestheticProcedures`.
     */
    public AestheticProcedure() {
    }

    /**
     * Construtor que inicializa um objeto `AestheticProcedures` com nome, descrição e preço.
     * 
     * @param name O nome do procedimento estético.
     * @param price O preço do procedimento estético.
     */
    public AestheticProcedure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Construtor que inicializa um objeto `AestheticProcedures` com um identificador único, nome, descrição e preço.
     * 
     * @param id O identificador único do procedimento estético.
     * @param name O nome do procedimento estético.
     * @param price O preço do procedimento estético.
     */
    public AestheticProcedure(int id, String name, double price) {
        this.id = id;
        this.name = name;
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
