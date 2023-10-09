/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Tests.Business;

import Business.Services.AestheticProcedureService;
import Business.Services.ProcedurePerformedService;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedTest {
    public static void main(String[] args) {
        AestheticProcedureService aestService = new AestheticProcedureService();
        ProcedurePerformedService service = new ProcedurePerformedService();
        Scanner scanner = new Scanner(System.in);

        // Listar todos os procedimentos
        List<AestheticProcedure> allProcedures = aestService.getAll();
        if (allProcedures != null && !allProcedures.isEmpty()) {
            System.out.println("Lista de todos os procedimentos estéticos:");
            for (AestheticProcedure procedureDb : allProcedures) {
                System.out.println("ID: " + procedureDb.getId() + ", Nome: " + procedureDb.getName() + ", Preço: " + procedureDb.getPrice());
            }
        } else {
            System.out.println("Nenhum procedimento encontrado.");
        }
        // Criar um novo procedimento realizado
        System.out.println("Informe o ID do Procedimento Estético: ");
        int aestheticProcedureId = Integer.parseInt(scanner.nextLine());
        System.out.println("Informe a Data (no formato dd-MM-yyyy): ");
        String date = scanner.nextLine();
        System.out.println("Valor recebido: ");
        Double amountReceived = Double.parseDouble(scanner.nextLine());
        ProcedurePerformed newProcedurePerformed = new ProcedurePerformed(date, aestheticProcedureId, amountReceived);
        boolean procedurePerformedCreated = service.createProcedurePerformed(newProcedurePerformed);
        if (procedurePerformedCreated) {
            System.out.println("Procedimento realizado criado com sucesso!");
        } else {
            System.out.println("Falha ao criar procedimento realizado!");
        }
        
        // Listar todos os procedimentos realizados
        List<ProcedurePerformed> allProceduresPerformed = service.getAll();
        if (allProceduresPerformed != null && !allProceduresPerformed.isEmpty()) {
            System.out.println("Lista de todos os procedimentos realizados:");
            for (ProcedurePerformed procedurePerformed : allProceduresPerformed) {
                System.out.println("ID: " + procedurePerformed.getId() + ", ID Procedimento Estético: " + procedurePerformed.getProcedure().getName()+ ", Data: " + procedurePerformed.getDate() + ", Valor Recebido: " + procedurePerformed.getAmountReceived());
            }
        } else {
            System.out.println("Nenhum procedimento realizado encontrado.");
        }

        // Listar um procedimento realizado específico por ID
        System.out.println("Informe o ID do procedimento realizado a ser listado: ");
        int idToDisplay = Integer.parseInt(scanner.nextLine());
        ProcedurePerformed procedurePerformedToDisplay = service.getById(idToDisplay);
        if (procedurePerformedToDisplay != null) {
            System.out.println("Procedimento realizado encontrado:");
            System.out.println("ID: " + procedurePerformedToDisplay.getId() + ", ID Procedimento Estético: " + procedurePerformedToDisplay.getProcedure().getName() + ", Data: " + procedurePerformedToDisplay.getDate() + ", Valor Recebido: " + procedurePerformedToDisplay.getAmountReceived());
        } else {
            System.out.println("Procedimento realizado não encontrado.");
        }        

        // Atualizar um procedimento realizado existente
        System.out.println("Informe o ID do procedimento realizado a ser atualizado: ");
        int idToUpdate = Integer.parseInt(scanner.nextLine());
        ProcedurePerformed updatedProcedurePerformed = service.getById(idToUpdate);
        if (updatedProcedurePerformed != null) {
            System.out.println("Nova Data (no formato dd-MM-yyyy): ");
            String newDate = scanner.nextLine();
            System.out.println("Novo valor recebido: ");
            Double newAmountReceived = Double.parseDouble(scanner.nextLine());
            updatedProcedurePerformed.setDate(newDate);
            updatedProcedurePerformed.setAmountReceived(newAmountReceived);
            boolean procedurePerformedUpdated = service.updateProcedurePerformed(updatedProcedurePerformed);
            if (procedurePerformedUpdated) {
                System.out.println("Procedimento realizado atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar procedimento realizado!");
            }
        } else {
            System.out.println("Procedimento realizado não encontrado.");
        }

        // Excluir um procedimento realizado existente
        System.out.println("Informe o ID do procedimento realizado a ser excluído: ");
        int idToDelete = Integer.parseInt(scanner.nextLine());
        ProcedurePerformed procedurePerformedToDelete = service.getById(idToDelete);
        if (procedurePerformedToDelete != null) {
            boolean procedurePerformedDeleted = service.deleteProcedurePerformed(procedurePerformedToDelete);
            if (procedurePerformedDeleted) {
                System.out.println("Procedimento realizado excluído com sucesso!");
            } else {
                System.out.println("Falha ao excluir procedimento realizado!");
            }
        } else {
            System.out.println("Procedimento realizado não encontrado.");
        }

        scanner.close();
    }
}