/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Models;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProceduresPerformed {

    private int id;
    private String date;
    private int procedure_id;
    private double amountReceived;
    private transient AestheticProcedures procedure;

    public ProceduresPerformed() {
    }

    public ProceduresPerformed(String date, int procedure_id, double amountReceived) {
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
    }

    public ProceduresPerformed(int id, String date, int procedure_id, double amountReceived) {
        this.id = id;
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
    }

    public ProceduresPerformed(int id, String date, int procedure_id, double amountReceived, AestheticProcedures procedure) {
        this.id = id;
        this.date = date;
        this.procedure_id = procedure_id;
        this.amountReceived = amountReceived;
        this.procedure = procedure;
    }

    
    public AestheticProcedures getProcedure() {
        return procedure;
    }

    public void setProcedure(AestheticProcedures procedure) {
        this.procedure = procedure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProcedure_id() {
        return procedure_id;
    }

    public void setProcedure_id(int procedure_id) {
        this.procedure_id = procedure_id;
    }

    public double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(double amountReceived) {
        this.amountReceived = amountReceived;
    }
    
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
