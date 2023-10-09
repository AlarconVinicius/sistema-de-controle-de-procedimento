/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests.Business;

import Business.Services.AestheticProcedureService;
import Database.Models.AestheticProcedure;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureTest {

    public static void main(String[] args) {
        AestheticProcedureService service = new AestheticProcedureService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nome: ");
        String name = scanner.nextLine();
        System.out.println("Preço: ");
        Double price = Double.parseDouble(scanner.nextLine());

        // Criar um novo procedimento estético
        AestheticProcedure procedure = new AestheticProcedure(name, price);
        boolean procedureCreated = service.createAestheticProcedure(procedure);
        if (procedureCreated) {
            System.out.println("Procedimento criado com sucesso!");
        } else {
            System.out.println("Falha ao criar procedimento!");
        }
        // Listar todos os procedimentos
        List<AestheticProcedure> allProcedures = service.getAll();
        if (allProcedures != null && !allProcedures.isEmpty()) {
            System.out.println("Lista de todos os procedimentos estéticos:");
            for (AestheticProcedure procedureDb : allProcedures) {
                System.out.println("ID: " + procedureDb.getId() + ", Nome: " + procedureDb.getName() + ", Preço: " + procedureDb.getPrice());
            }
        } else {
            System.out.println("Nenhum procedimento encontrado.");
        }

        // Listar um procedimento específico por ID
        System.out.println("Informe o ID do procedimento a ser listado: ");
        int idToDisplay = Integer.parseInt(scanner.nextLine());
        AestheticProcedure procedureToDisplay = service.getById(idToDisplay);
        if (procedureToDisplay != null) {
            System.out.println("Procedimento encontrado:");
            System.out.println("ID: " + procedureToDisplay.getId() + ", Nome: " + procedureToDisplay.getName() + ", Preço: " + procedureToDisplay.getPrice());
        } else {
            System.out.println("Procedimento não encontrado.");
        }

        // Atualizar um procedimento estético
        System.out.println("Informe o ID do procedimento a ser atualizado: ");
        int idToUpdate = Integer.parseInt(scanner.nextLine());
        AestheticProcedure updatedProcedure = service.getById(idToUpdate);
        if (updatedProcedure != null) {
            System.out.println("Novo nome: ");
            String newName = scanner.nextLine();
            System.out.println("Novo preço: ");
            Double newPrice = Double.parseDouble(scanner.nextLine());
            updatedProcedure.setName(newName);
            updatedProcedure.setPrice(newPrice);
            boolean procedureUpdated = service.updateAestheticProcedure(updatedProcedure);
            if (procedureUpdated) {
                System.out.println("Procedimento atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar procedimento!");
            }
        } else {
            System.out.println("Procedimento não encontrado.");
        }

        // Excluir um procedimento estético
        System.out.println("Informe o ID do procedimento a ser excluído: ");
        int idToDelete = Integer.parseInt(scanner.nextLine());
        AestheticProcedure procedureToDelete = service.getById(idToDelete);
        if (procedureToDelete != null) {
            boolean procedureDeleted = service.deleteAestheticProcedure(procedureToDelete);
            if (procedureDeleted) {
                System.out.println("Procedimento excluído com sucesso!");
            } else {
                System.out.println("Falha ao excluir procedimento!");
            }
        } else {
            System.out.println("Procedimento não encontrado.");
        }
        scanner.close();
    }
}
