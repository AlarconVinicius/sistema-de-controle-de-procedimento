/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Helpers;

/**
 *
 * @author Alarcon Vinicius
 */
public class ConsoleUtils {

    // Método para limpar o terminal no Windows
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                for (int i = 0; i < 50; i++) {
                    System.out.println();
                }
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (final Exception e) {
        }
    }
}
