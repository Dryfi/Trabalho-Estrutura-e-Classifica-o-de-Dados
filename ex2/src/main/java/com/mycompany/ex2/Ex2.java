/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex2;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author mateu
 */
public class Ex2 {

    public static void main(String[] args) {
      

        Queue<Cliente> filaPrioritaria = new LinkedList<>();
        Queue<Cliente> filaNormal = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCliente(scanner, filaPrioritaria, filaNormal);
                    break;
                case 2:
                    chamarProximoCliente(filaPrioritaria, filaNormal);
                    break;
                case 0:
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente. ");
            }
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void adicionarCliente(Scanner scanner, Queue<Cliente> filaPrioritaria, Queue<Cliente> filaNormal) {
        System.out.print("Informe o nome do cliente: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine();
        System.out.print("Informe o ano de nascimento do cliente: ");
        int anoNascimento = scanner.nextInt();
        System.out.print("Informe a senha do cliente: ");
        int senha = scanner.nextInt();

        Cliente cliente = new Cliente(senha, nome, anoNascimento);
        if (cliente.getIdade() > 65) {
            filaPrioritaria.offer(cliente);
            System.out.println("Cliente adicionado à fila prioritária.");
        } else {
            filaNormal.offer(cliente);
            System.out.println("Cliente adicionado à fila normal.");
        }
    }

    private static void chamarProximoCliente(Queue<Cliente> filaPrioritaria, Queue<Cliente> filaNormal) {
        if (!filaPrioritaria.isEmpty()) {
            atenderCliente(filaPrioritaria.poll());
            atenderCliente(filaPrioritaria.poll());
        } else {
            if (!filaNormal.isEmpty()) {
                atenderCliente(filaNormal.poll());
            } else {
                System.out.println("Não há clientes na fila.");
            }
        }
    }

    private static void atenderCliente(Cliente cliente) {
        System.out.println("Cliente atendido: " + cliente.getNome());
    }
}

