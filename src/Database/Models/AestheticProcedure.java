/*
 * The MIT License
 *
 * Copyright 2023 Alarcon Vinicius.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * ---
 * 
 * Este projeto é disponibilizado sob a licença MIT.
 * 
 * 🔗 LinkedIn: https://www.linkedin.com/in/vin%C3%ADcius-alarcon-52a8a820a/
 * 🔗 GitHub: https://github.com/AlarconVinicius
 * 💼 Website: http://alarconvinicius.com.br/
 */
package Database.Models;

/**
 * Classe que representa procedimentos estéticos.
 * Cada procedimento estético possui um nome e preço.
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
     * Construtor que inicializa um objeto `AestheticProcedures` com nome e preço.
     * 
     * @param name O nome do procedimento estético.
     * @param price O preço do procedimento estético.
     */
    public AestheticProcedure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Construtor que inicializa um objeto `AestheticProcedures` com um identificador único, nome e preço.
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
