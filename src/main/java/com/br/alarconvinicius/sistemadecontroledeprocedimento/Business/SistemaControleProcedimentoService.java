/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.alarconvinicius.sistemadecontroledeprocedimento.Business;

import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.RegistroProcedimento;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Models.ServicoEstetico;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.RegistroProcedimentoRepository;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.ServicoEsteticoRepository;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class SistemaControleProcedimentoService {

    private final ServicoEsteticoRepository _servicoRepository;
    private final RegistroProcedimentoRepository _registroRepository;

    public SistemaControleProcedimentoService(ServicoEsteticoRepository servicoRepository, RegistroProcedimentoRepository registroRepository) {
        _servicoRepository = servicoRepository;
        _registroRepository = registroRepository;
    }

    // Método para retornar menu de cadastro de serviços disponíveis
    public void cadastrarServicos(Scanner scanner) {
        System.out.println("");
        System.out.println("Cadastrar Serviço: ");
        System.out.println("");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.println("");

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("");

        System.out.println("Valor: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.println("");

        _servicoRepository.cadastrarServico(new ServicoEstetico(nome, descricao, valor));
    }

    // Método para retornar menu de cadastro de serviços disponíveis
    public void cadastrarProcedimentoRealizado(Scanner scanner) {
        System.out.println("");
        System.out.println("Cadastrar Procedimento Realizado: ");
        System.out.println("");
        menuServicos();

        System.out.print("Escolha o número do serviço: ");
        int escolhaServico = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");

        if (escolhaServico >= 1 && escolhaServico <= _servicoRepository.listarServicos().size()) {
            ServicoEstetico servicoEscolhido = _servicoRepository.listarServicos().get(escolhaServico - 1);

            System.out.print("Data: ");
            String data = scanner.nextLine();

            System.out.println("");

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            System.out.println("");

            System.out.print("Valor Recebido: ");
            double valor = Double.parseDouble(scanner.nextLine());

            System.out.println("");

            _registroRepository.cadastrarRegistro(new RegistroProcedimento(data, servicoEscolhido, valor));
        } else {
            System.out.println("Opção inválida. Escolha um número de serviço válido.");
        }
    }

    // Método para retornar menu de serviços disponíveis
    public void menuServicos() {
        var servicosDb = _servicoRepository.listarServicos();

        System.out.println("");
        System.out.println("Serviços disponíveis: ");
        System.out.println("");
        for (int i = 0; i < servicosDb.size(); i++) {
            ServicoEstetico servico = servicosDb.get(i);
            System.out.println("Serviço (" + (i + 1) + "): " + servico.getNome());
            System.out.println("-------------------------");
        }
        System.out.println("");
    }

    // Método para gerar um relatório de procedimentos
    public void gerarRelatorioProcedimentos() {
        var registrosDb = _registroRepository.listarRegistros();
        double receitaMensal = calcularReceitaMensal();
        System.out.println("");
        System.out.println("Receita Mensal: R$" + receitaMensal);
        System.out.println("");
        for (RegistroProcedimento registro : registrosDb) {
            System.out.println("Data: " + registro.getData());
            System.out.println("Serviço: " + registro.getServico().getNome());
            System.out.println("Valor Recebido: " + registro.getValorRecebido());
            System.out.println("-------------------------");
        }
        System.out.println("");
    }

    // Método para calcular a receita mensal da clínica
    private double calcularReceitaMensal() {
        var registrosDb = _registroRepository.listarRegistros();
        double receita = 0.0;
        for (RegistroProcedimento registro : registrosDb) {
            receita += registro.getValorRecebido();
        }
        return receita;
    }
}
