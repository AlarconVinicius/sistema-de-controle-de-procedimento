/*
 * The MIT License
 *
 * Copyright 2023 Alarcon Vinicius.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * ---
 * 
 * Este projeto é disponibilizado sob a licença MIT.
 * 
 * 🔗 LinkedIn: https://www.linkedin.com/in/vin%C3%ADcius-alarcon-52a8a820a/
 * 🔗 GitHub: https://github.com/AlarconVinicius
 * 💼 Website: http://alarconvinicius.com.br/
 */
package Tests.Business;

import Business.Services.AestheticProcedureService;
import Business.Services.ProcedurePerformedService;
import Database.Models.AestheticProcedure;
import Database.Models.ProcedurePerformed;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de teste para o serviço de procedimentos realizados
 * (ProcedurePerformedService). Esta classe permite testar a funcionalidade de
 * gerenciamento de procedimentos realizados, incluindo a criação, listagem,
 * atualização e exclusão de procedimentos realizados. Também permite listar os
 * procedimentos estéticos disponíveis para associação.
 *
 * @author Alarcon Vinicius
 */
public class ProcedurePerformedTest {

    /**
     * Método principal que inicia a execução do teste do serviço de
     * procedimentos realizados. Permite ao usuário interagir com o serviço,
     * criando procedimentos realizados, listando todos os procedimentos
     * estéticos e realizados, listando um procedimento realizado específico por
     * ID, atualizando um procedimento realizado existente e excluindo um
     * procedimento realizado.
     *
     * @param args Os argumentos da linha de comando (não são usados neste
     * contexto).
     */
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
                System.out.println("ID: " + procedurePerformed.getId() + ", ID Procedimento Estético: " + procedurePerformed.getProcedure().getName() + ", Data: " + procedurePerformed.getDate() + ", Valor Recebido: " + procedurePerformed.getAmountReceived());
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
