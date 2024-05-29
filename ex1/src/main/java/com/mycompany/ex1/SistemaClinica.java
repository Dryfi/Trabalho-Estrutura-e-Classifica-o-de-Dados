package com.mycompany.ex1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaClinica {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar paciente");
            System.out.println("2 - Chamar próximo paciente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome do paciente: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nomePaciente = scanner.nextLine();
                    adicionarPaciente(fila, nomePaciente);
                    break;
                case 2:
                    chamarProximoPaciente(fila);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void adicionarPaciente(Queue<String> fila, String nome) {
        if (fila.size() < 20) {
            fila.offer(nome); // Adiciona o paciente ao final da fila
            System.out.println("Paciente adicionado à fila com sucesso.");
        } else {
            System.out.println("A fila de senhas está lotada para o dia.");
        }
    }

    private static void chamarProximoPaciente(Queue<String> fila) {
        if (!fila.isEmpty()) {
            String proximoPaciente = fila.poll(); // Remove e retorna o próximo paciente da fila
            System.out.println("Próximo paciente: " + proximoPaciente);
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }
}
