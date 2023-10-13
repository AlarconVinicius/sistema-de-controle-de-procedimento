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
 * Classe que representa procedimentos realizados.
 * Cada procedimento realizado possui uma data, um ID de procedimento associado e um valor recebido.
 * Pode estar associado a um procedimento estético específico.
 * 
 * A classe também possui anotação transient para o campo 'procedure', indicando que este campo não deve ser serializado.
 * 
 * @author Alarcon Vinicius
 */
public class ProcedurePerformed {

    /**
     * O identificador único do procedimento realizado.
     */
    private int id;

    /**
     * A data em que o procedimento foi realizado.
     */
    private String date;

    /**
     * O ID do procedimento associado a este procedimento realizado.
     */
    private int procedure_id;

    /**
     * O valor recebido pelo procedimento realizado.
     */
    private double amountReceived;

    /**
     * Uma referência ao procedimento estético associado a este procedimento realizado.
     * O campo é marcado como transient para não ser serializado.
     */
    private transient AestheticProcedure procedure;

    /**
     * Construtor padrão da classe `ProceduresPerformed`.
     */
    public ProcedurePerformed() {
    }

    /**
     * Construtor que inicializa um objeto `ProceduresPerformed` com data, ID de procedimento e valor recebido.
     * 
     * @param date A data em que o procedimento foi realizado.
     * @param procedure_id O ID do procedimento associado a este procedimento realizado.
     * @param amountReceived O valor recebido pelo procedimento realizado.
     */
    public ProcedurePerformed(String date, int procedure_id, double amountReceived) {
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
    }

    /**
     * Construtor que inicializa um objeto `ProceduresPerformed` com um identificador único, data, ID de procedimento e valor recebido.
     * 
     * @param id O identificador único do procedimento realizado.
     * @param date A data em que o procedimento foi realizado.
     * @param procedure_id O ID do procedimento associado a este procedimento realizado.
     * @param amountReceived O valor recebido pelo procedimento realizado.
     */
    public ProcedurePerformed(int id, String date, int procedure_id, double amountReceived) {
        this.id = id;
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
    }

    /**
     * Construtor que inicializa um objeto `ProceduresPerformed` com um identificador único, data, ID de procedimento, valor recebido e procedimento associado.
     * 
     * @param id O identificador único do procedimento realizado.
     * @param date A data em que o procedimento foi realizado.
     * @param procedure_id O ID do procedimento associado a este procedimento realizado.
     * @param amountReceived O valor recebido pelo procedimento realizado.
     * @param procedure O procedimento estético associado a este procedimento realizado.
     */
    public ProcedurePerformed(int id, String date, int procedure_id, double amountReceived, AestheticProcedure procedure) {
        this.id = id;
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
        this.procedure = procedure;
    }

    /**
     * Obtém o procedimento estético associado a este procedimento realizado.
     * 
     * @return O procedimento estético associado.
     */
    public AestheticProcedure getProcedure() {
        return procedure;
    }

     /**
     * Define o procedimento estético associado a este procedimento realizado.
     * 
     * @param procedure O procedimento estético a ser associado.
     */
    public void setProcedure(AestheticProcedure procedure) {
        this.procedure = procedure;
    }

    /**
     * Obtém o identificador único do procedimento realizado.
     * 
     * @return O identificador único do procedimento realizado.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador único do procedimento realizado.
     * 
     * @param id O identificador único do procedimento realizado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém a data em que o procedimento foi realizado.
     * 
     * @return A data em que o procedimento foi realizado.
     */
    public String getDate() {
        return date;
    }

     /**
     * Define a data em que o procedimento foi realizado.
     * 
     * @param date A data em que o procedimento foi realizado.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Obtém o ID do procedimento associado a este procedimento realizado.
     * 
     * @return O ID do procedimento associado.
     */
    public int getProcedure_id() {
        return procedure_id;
    }

     /**
     * Define o ID do procedimento associado a este procedimento realizado.
     * 
     * @param procedure_id O ID do procedimento associado.
     */
    public void setProcedure_id(int procedure_id) {
        this.procedure_id = procedure_id;
    }

    /**
     * Obtém o valor recebido pelo procedimento realizado.
     * 
     * @return O valor recebido pelo procedimento realizado.
     */
    public double getAmountReceived() {
        return amountReceived;
    }

    /**
     * Define o valor recebido pelo procedimento realizado.
     * 
     * @param amountReceived O valor recebido pelo procedimento realizado.
     */
    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }
    
    /**
     * Retorna uma representação em string do objeto `ProceduresPerformed`.
     * 
     * @return Uma string que representa o objeto `ProceduresPerformed`.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(this.id).append(", ")
            .append("Date = ").append(this.date).append(", ")
            .append("Procedure Id = ").append(this.procedure_id).append(", ")
            .append("Amount Received = ").append(this.amountReceived).append(", ")
            .append("Aesthetic Procedures = ").append(this.procedure);
        return sb.toString();
    }

}
