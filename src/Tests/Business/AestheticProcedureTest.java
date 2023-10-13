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
import Database.Models.AestheticProcedure;
import java.util.List;
import java.util.Scanner;

/**
 * Classe de teste para o serviço de procedimentos estéticos
 * (AestheticProcedureService). Essa classe permite testar as operações do
 * serviço, como criar, listar, atualizar e excluir procedimentos estéticos, bem
 * como exibir informações detalhadas sobre um procedimento específico.
 *
 * @author Alarcon Vinicius
 */
public class AestheticProcedureTest {

    /**
     * Método principal que inicia a execução do teste do serviço de
     * procedimentos estéticos. Permite ao usuário interagir com o serviço,
     * inserindo informações sobre procedimentos estéticos, listando
     * procedimentos existentes, atualizando procedimentos e excluindo
     * procedimentos.
     *
     * @param args Os argumentos da linha de comando (não são usados neste
     * contexto).
     */
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
