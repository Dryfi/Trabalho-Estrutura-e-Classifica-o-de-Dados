/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex5;
import java.util.*;
import com.mycompany.ex5.Produto;
/**
 *
 * @author mateu
 */
public class Ex5 {

    public static void main(String[] args) {
         Map<Integer, Stack<Produto>> deposito = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            deposito.put(i, new Stack<>());
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Retirar produto");
            System.out.println("3 - Exibir pilhas no depósito");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, deposito);
                    break;
                case 2:
                    retirarProduto(scanner, deposito);
                    break;
                case 3:
                    exibirPilhas(deposito);
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

    private static void adicionarProduto(Scanner scanner, Map<Integer, Stack<Produto>> deposito) {
        int numPilha = selecionarPilha(scanner);
        if (deposito.containsKey(numPilha)) {
            System.out.print("Informe o código do produto: ");
            int codProduto = scanner.nextInt();
            System.out.print("Informe a descrição do produto: ");
            scanner.nextLine();
            String descricao = scanner.nextLine();
            System.out.print("Informe a data de entrada do produto: ");
            String dataEntrada = scanner.next();
            System.out.print("Informe o UF de origem do produto: ");
            String ufOrigem = scanner.next();
            System.out.print("Informe o UF de destino do produto: ");
            String ufDestino = scanner.next();

            Produto produto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
            deposito.get(numPilha).push(produto);
            System.out.println("Produto adicionado à pilha " + numPilha);
        } else {
            System.out.println("Pilha inválida.");
        }
    }

    private static void retirarProduto(Scanner scanner, Map<Integer, Stack<Produto>> deposito) {
        int numPilha = selecionarPilha(scanner);
        if (deposito.containsKey(numPilha)) {
            Stack<Produto> pilha = deposito.get(numPilha);
            if (!pilha.isEmpty()) {
                Produto produtoRetirado = pilha.pop();
                System.out.println("Produto retirado da pilha " + numPilha + ": " + produtoRetirado.getDescricao());
            } else {
                System.out.println("Não há produtos na pilha " + numPilha);
            }
        } else {
            System.out.println("Pilha inválida.");
        }
    }

    private static void exibirPilhas(Map<Integer, Stack<Produto>> deposito) {
        System.out.println("Pilhas no depósito:");
        for (Map.Entry<Integer, Stack<Produto>> entry : deposito.entrySet()) {
            int numPilha = entry.getKey();
            Stack<Produto> pilha = entry.getValue();
            System.out.println("Pilha " + numPilha);
            if (pilha.isEmpty()) {
                System.out.println("Pilha vazia");
            } else {
                for (int i = pilha.size() - 1; i >= 0; i--) {
                    Produto produto = pilha.get(i);
                    System.out.println("    - " + produto.getDescricao());
                }
            }
        }
    }

    private static int selecionarPilha(Scanner scanner) {
        int numPilha;
        do {
            System.out.print("Informe o número da pilha (1 a 5): ");
            numPilha = scanner.nextInt();
        } while (numPilha < 1 || numPilha > 5);
        return numPilha;
    }
    }

