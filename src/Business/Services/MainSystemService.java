/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Services;

import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class MainSystemService {

    private final AestheticProceduresRepository _aProcedureRepository;
    private final ProceduresPerformedRepository _pPerformedRepository;
    public MainSystemService(AestheticProceduresRepository aProcedureRepository, ProceduresPerformedRepository pPerformedRepository) {
        _aProcedureRepository = aProcedureRepository;
        _pPerformedRepository = pPerformedRepository;
    }

    // Método para retornar menu de cadastro de serviços disponíveis
    public void createAestheticProcedure(Scanner scanner) {
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

        _aProcedureRepository.create(new AestheticProcedures(nome, descricao, valor));
    }

    // Método para retornar menu de cadastro de serviços disponíveis
    public void createProcedurePerformed(Scanner scanner) {
        System.out.println("");
        System.out.println("Cadastrar Procedimento Realizado: ");
        System.out.println("");
        menuServicos();

        System.out.print("Escolha o número do serviço: ");
        int escolhaServico = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");

        if (escolhaServico >= 1 && escolhaServico <= _aProcedureRepository.findAll().size()) {
            AestheticProcedures servicoEscolhido = _aProcedureRepository.findAll().get(escolhaServico - 1);

            System.out.print("Data: ");
            String data = scanner.nextLine();

            System.out.println("");

            System.out.print("Valor Recebido: ");
            double valor = Double.parseDouble(scanner.nextLine());

            System.out.println("");

            _pPerformedRepository.create(new ProceduresPerformed(data, servicoEscolhido.getId(), valor));
        } else {
            System.out.println("Opção inválida. Escolha um número de serviço válido.");
        }
    }

    // Método para retornar menu de serviços disponíveis
    public void menuServicos() {
         List<AestheticProcedures> servicosDb = _aProcedureRepository.findAll();

        System.out.println("");
        System.out.println("Serviços disponíveis: ");
        System.out.println("");
        for (AestheticProcedures servico : servicosDb) {
        System.out.println("Serviço (" + servico.getId() + "): " + servico.getName());
        System.out.println("-------------------------");
    }
        System.out.println("");
    }

    // Método para gerar um relatório de procedimentos
    public void generateProceduresReport() {
        List<ProceduresPerformed> registrosDb = _pPerformedRepository.findAll();
        double receitaMensal = calcularReceitaMensal();
        System.out.println("");
        System.out.println("Receita Mensal: R$" + receitaMensal);
        System.out.println("");
        for (ProceduresPerformed registro : registrosDb) {
            System.out.println("Data: " + registro.getDate());
            System.out.println("Serviço: " + registro.getProcedure().getName());
            System.out.println("Valor Recebido: " + String.format("%.2f", registro.getAmountReceived()));
            System.out.println("-------------------------");
        }
        System.out.println("");
    }

    // Método para calcular a receita mensal da clínica
    private double calcularReceitaMensal() {
        var registrosDb = _pPerformedRepository.findAll();
        double receita = 0.0;
        for (ProceduresPerformed registro : registrosDb) {
            receita += registro.getAmountReceived();
        }
        return receita;
    }
}
