/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.alarconvinicius.sistemadecontroledeprocedimento.Tests;

import com.br.alarconvinicius.sistemadecontroledeprocedimento.Business.SistemaControleProcedimentoService;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.RegistroProcedimentoRepository;
import com.br.alarconvinicius.sistemadecontroledeprocedimento.Database.Repositories.ServicoEsteticoRepository;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class TestFluxoSistemaControleProcedimentos {

    public static void main(String[] args) {
        ServicoEsteticoRepository servicoRepository = new ServicoEsteticoRepository();
        RegistroProcedimentoRepository registroRepository = new RegistroProcedimentoRepository();
        SistemaControleProcedimentoService sistema = new SistemaControleProcedimentoService(servicoRepository, registroRepository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearConsole();
            System.out.println("");
            System.out.println("Menu");
            System.out.println("");
            System.out.println("1 - Cadastrar Serviços");
            System.out.println("2 - Cadastrar Procedimento");
            System.out.println("3 - Relatório de Procedimentos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcaoMenu = scanner.nextLine();
            switch (Integer.parseInt(opcaoMenu)) {
                case 1:
                    clearConsole();
                    System.out.println("");
                    sistema.cadastrarServicos(scanner);
                    System.out.println("");
                    break;
                case 2:
                    clearConsole();
                    System.out.println("");
                    sistema.cadastrarProcedimentoRealizado(scanner);
                    System.out.println("");
                    break;
                case 3:
                    clearConsole();
                    System.out.println("");
                    sistema.gerarRelatorioProcedimentos();
                    System.out.println("");
                    break;
                case 4:
                    clearConsole();
                    System.out.println("");
                    System.out.println("Encerrando o programa.");
                    System.out.println("");
                    scanner.close();
                    System.exit(0);
                default:
                    clearConsole();
                    System.out.println("");
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    System.out.println("");
            }

        }
    }
    // Método para limpar o terminal no Windows
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // No Windows, adicionamos várias linhas em branco para "limpar" a tela
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            } else {
                // Em outros sistemas, usamos o comando "clear"
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
            // Tratar exceções, se necessário
        }
    }

}
