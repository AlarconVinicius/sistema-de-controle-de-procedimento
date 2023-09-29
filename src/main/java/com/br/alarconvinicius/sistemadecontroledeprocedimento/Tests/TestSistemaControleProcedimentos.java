/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.alarconvinicius.sistemadecontroledeprocedimento.Tests;

import com.br.alarconvinicius.sistemadecontroledeprocedimento.Business.SistemaControleProcedimentoService;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.RegistroProcedimento;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.ServicoEstetico;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.RegistroProcedimentoRepository;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.ServicoEsteticoRepository;

/**
 *
 * @author Alarcon Vinicius
 */
public class TestSistemaControleProcedimentos {

    public static void main(String[] args) {
        ServicoEsteticoRepository servicoRepository = new ServicoEsteticoRepository();
        RegistroProcedimentoRepository registroRepository = new RegistroProcedimentoRepository();
        SistemaControleProcedimentoService sistema = new SistemaControleProcedimentoService(servicoRepository, registroRepository);

        
        ServicoEstetico servico1 = new ServicoEstetico("Preenchimento Labial", "", 900.00);
        ServicoEstetico servico2 = new ServicoEstetico("Botox", "", 1500.00);
        ServicoEstetico servico3 = new ServicoEstetico("Preenchimento de Mandíbula", "", 1300.00);

        servicoRepository.cadastrarServico(servico1);
        servicoRepository.cadastrarServico(servico2);
        servicoRepository.cadastrarServico(servico3);
        
        RegistroProcedimento registro1 = new RegistroProcedimento("20/09/2023", servico1, 900.00);
        RegistroProcedimento registro2 = new RegistroProcedimento("25/09/2023", servico2, 1500.0);
        RegistroProcedimento registro3 = new RegistroProcedimento("29/09/2023", servico3, 1300.0);
        
        registroRepository.cadastrarRegistro(registro1);
        registroRepository.cadastrarRegistro(registro2);
        registroRepository.cadastrarRegistro(registro3);
        
        sistema.gerarRelatorioProcedimentos();
    }
}
