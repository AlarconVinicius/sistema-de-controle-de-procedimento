/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models;

/**
 *
 * @author Alarcon Vinicius
 */
public class RegistroProcedimento {

    private String data;
    private ServicoEstetico servico;
    private double valorRecebido;

    public RegistroProcedimento(String data, ServicoEstetico servico, double valorRecebido) {
        this.data = data;
        this.servico = servico;
        this.valorRecebido = valorRecebido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ServicoEstetico getServico() {
        return servico;
    }

    public void setServico(ServicoEstetico servico) {
        this.servico = servico;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

}
