/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Services;

import Database.Models.AestheticProcedures;
import Database.Models.ProceduresPerformed;
import Database.Models.User;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import Database.Repositories.UserRepository;
import java.util.List;
import java.util.Scanner;

/**
 * Classe que fornece serviços principais para o sistema. Essa classe oferece
 * funcionalidades para gerenciar procedimentos estéticos, relatórios, perfil do
 * usuário e muito mais.
 *
 * @author Alarcon Vinicius
 */
public class MainSystemService {

    /**
     * Repositório de procedimentos estéticos.
     */
    private final AestheticProceduresRepository _aProcedureRepository;

    /**
     * Repositório de procedimentos realizados.
     */
    private final ProceduresPerformedRepository _pPerformedRepository;

    /**
     * Repositório de usuários.
     */
    private final UserRepository _userRepository;

    /**
     * Construtor para a classe MainSystemService.
     *
     * @param aProcedureRepository O repositório de procedimentos estéticos.
     * @param pPerformedRepository O repositório de procedimentos realizados.
     * @param userRepository O repositório de usuários.
     */
    public MainSystemService(AestheticProceduresRepository aProcedureRepository, ProceduresPerformedRepository pPerformedRepository, UserRepository userRepository) {
        _aProcedureRepository = aProcedureRepository;
        _pPerformedRepository = pPerformedRepository;
        _userRepository = userRepository;
    }

    /**
     * Exibe o menu para criar um novo procedimento estético e o adiciona ao
     * repositório.
     *
     * @param scanner O Scanner para entrada de dados.
     */
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

    /**
     * Exibe o menu para criar um novo procedimento realizado e o adiciona ao
     * repositório.
     *
     * @param scanner O Scanner para entrada de dados.
     */
    public void createProcedurePerformed(Scanner scanner) {
        System.out.println("");
        System.out.println("Cadastrar Procedimento Realizado: ");
        System.out.println("");
        menuServicos();

        System.out.print("Escolha o número do serviço: ");
        int escolhaServico = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");

        if (escolhaServico >= 1 && escolhaServico <= _aProcedureRepository.getAll().size()) {
            AestheticProcedures servicoEscolhido = _aProcedureRepository.getAll().get(escolhaServico - 1);

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

    /**
     * Exibe o menu de serviços estéticos disponíveis.
     */
    public void menuServicos() {
        List<AestheticProcedures> servicosDb = _aProcedureRepository.getAll();

        System.out.println("");
        System.out.println("Serviços disponíveis: ");
        System.out.println("");
        for (AestheticProcedures servico : servicosDb) {
            System.out.println("Serviço (" + servico.getId() + "): " + servico.getName());
            System.out.println("-------------------------");
        }
        System.out.println("");
    }

    /**
     * Lista todos os procedimentos estéticos disponíveis.
     */
    public void getAllAestheticProcedures() {
        List<AestheticProcedures> proceduresDb = _aProcedureRepository.getAll();
        System.out.println("Serviços:");
        System.out.println("");
        for (AestheticProcedures procedure : proceduresDb) {
            System.out.println("Id: " + procedure.getId() + " | Nome: " + procedure.getName() + " | Preço: " + procedure.getPrice() + " | Descrição: " + procedure.getDescription());
            System.out.println("-------------------------------------------------");
        }
    }

    /**
     * Gera um relatório de procedimentos realizados, incluindo a receita
     * mensal.
     */
    public void generateProceduresReport() {
        List<ProceduresPerformed> registrosDb = _pPerformedRepository.getAll();
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

    /**
     * Obtém e exibe o perfil do usuário.
     */
    public void getProfile() {
        User user = _userRepository.getById(1);
        System.out.println("Id: " + user.getId() + " | Nome: " + user.getName() + " | Email: " + user.getEmail() + " | Senha: " + user.getPassword());
    }

    /**
     * Exibe um menu para atualizar o perfil do usuário.
     *
     * @param scanner O Scanner para entrada de dados.
     */
    public void updateProfile(Scanner scanner) {
        User user = _userRepository.getById(1);
        System.out.println("Qual informação você deseja atualizar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Email");
        System.out.println("3 - Senha");
        System.out.println("4 - Cancelar");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Novo Nome: ");
                String novoNome = scanner.nextLine();
                user.setName(novoNome);
                _userRepository.update(user);
                System.out.println("Nome atualizado com sucesso.");
                break;
            case 2:
                System.out.print("Novo Email: ");
                String novoEmail = scanner.nextLine();
                user.setEmail(novoEmail);
                _userRepository.update(user);
                System.out.println("Email atualizado com sucesso.");
                break;
            case 3:
                System.out.print("Nova Senha: ");
                String novaSenha = scanner.nextLine();
                user.setPassword(novaSenha);
                _userRepository.update(user);
                System.out.println("Senha atualizada com sucesso.");
                break;
            case 4:
                System.out.println("Operação de atualização cancelada.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    /**
     * Método privado para calcular a receita mensal da clínica.
     *
     * @return A receita mensal calculada.
     */
    private double calcularReceitaMensal() {
        var registrosDb = _pPerformedRepository.getAll();
        double receita = 0.0;
        for (ProceduresPerformed registro : registrosDb) {
            receita += registro.getAmountReceived();
        }
        return receita;
    }
}
