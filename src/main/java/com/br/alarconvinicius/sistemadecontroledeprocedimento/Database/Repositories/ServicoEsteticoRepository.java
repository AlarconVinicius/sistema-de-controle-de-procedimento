/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories;

import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.ServicoEstetico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alarcon Vinicius
 */
public class ServicoEsteticoRepository {
    private final List<ServicoEstetico> servicos;

    public ServicoEsteticoRepository() {
        this.servicos = new ArrayList<>();
    }
    
    // Método para cadastrar um novo serviço estético
    public void cadastrarServico(ServicoEstetico servico) {
        this.servicos.add(servico);
    }
    
    // Método para listar os serviços cadastrados
    public List<ServicoEstetico> listarServicos(){
        return this.servicos;
    }
    
}
