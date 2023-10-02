/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Business.Test;

import Auth.UserService;
import Business.Services.MainSystemService;
import Database.Models.User;
import Database.Repositories.AestheticProceduresRepository;
import Database.Repositories.ProceduresPerformedRepository;
import Helpers.ConsoleUtils;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class MainSystemServiceFlowTest {
public static void main(String[] args) {
        User auth = new User();
        AestheticProceduresRepository aesProduceresRepository = new AestheticProceduresRepository();
        ProceduresPerformedRepository procePerformedRepository = new ProceduresPerformedRepository();
        MainSystemService sistema = new MainSystemService(aesProduceresRepository, procePerformedRepository);
        UserService userService = new UserService(auth);

        
        Scanner scanner = new Scanner(System.in);
        
        var logado = userService.authenticate(scanner);

        while (logado) {
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
                    ConsoleUtils.clearConsole();
                    System.out.println("");
                    sistema.createAestheticProcedure(scanner);
                    System.out.println("");
                    break;
                case 2:
                    ConsoleUtils.clearConsole();
                    System.out.println("");
                    sistema.createProcedurePerformed(scanner);
                    System.out.println("");
                    break;
                case 3:
                    ConsoleUtils.clearConsole();
                    System.out.println("");
                    sistema.gerarRelatorioProcedimentos();
                    System.out.println("");
                    break;
                case 4:
                    ConsoleUtils.clearConsole();
                    System.out.println("");
                    System.out.println("Encerrando o programa.");
                    System.out.println("");
                    scanner.close();
                    userService.logout();
                    logado = false;
                    break;
                default:
                    ConsoleUtils.clearConsole();
                    System.out.println("");
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    System.out.println("");
            }
        }
    }
}
