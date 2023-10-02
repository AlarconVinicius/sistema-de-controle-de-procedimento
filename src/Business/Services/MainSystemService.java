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
 *
 * @author Alarcon Vinicius
 */
public class MainSystemService {

    private final AestheticProceduresRepository _aProcedureRepository;
    private final ProceduresPerformedRepository _pPerformedRepository;
    private final UserRepository _userRepository;
    public MainSystemService(AestheticProceduresRepository aProcedureRepository, ProceduresPerformedRepository pPerformedRepository, UserRepository userRepository) {
        _aProcedureRepository = aProcedureRepository;
        _pPerformedRepository = pPerformedRepository;
        _userRepository = userRepository;
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

    // Método para listar todos os serviços
    public void getAllAestheticProcedures(){
        List<AestheticProcedures> proceduresDb = _aProcedureRepository.findAll();
        System.out.println("Serviços:");
        System.out.println("");
        for (AestheticProcedures procedure : proceduresDb) {
            System.out.println("Id: " + procedure.getId() + " | Nome: " + procedure.getName() + " | Preço: " + procedure.getPrice() + " | Descrição: " + procedure.getDescription());
            System.out.println("-------------------------------------------------");
        }
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
    public void getProfile() {
        User user = _userRepository.findById(1);
        System.out.println("Id: " + user.getId() + " | Nome: " + user.getName() + " | Email: " + user.getEmail() + " | Senha: " + user.getPassword());
    }
    public void updateProfile(Scanner scanner) {
        User user = _userRepository.findById(1);
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
