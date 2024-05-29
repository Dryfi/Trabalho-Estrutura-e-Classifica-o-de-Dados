/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex4;
import java.util.Scanner;
import java.util.Stack;
import com.mycompany.ex4.Produto;
/**
 *
 * @author mateu
 */
public class Ex4 {

    public static void main(String[] args) {
Stack<Produto> pilhaProdutos = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Retirar produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner, pilhaProdutos);
                    exibirPilhaProdutos(pilhaProdutos);
                    break;
                case 2:
                    retirarProduto(pilhaProdutos);
                    exibirPilhaProdutos(pilhaProdutos);
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

    private static void adicionarProduto(Scanner scanner, Stack<Produto> pilhaProdutos) {
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
        pilhaProdutos.push(produto);
        System.out.println("Produto adicionado à pilha com sucesso.");
    }

    private static void retirarProduto(Stack<Produto> pilhaProdutos) {
        if (pilhaProdutos.isEmpty()) {
            System.out.println("Não há produtos na pilha para retirar.");
        } else {
            Produto produtoRetirado = pilhaProdutos.pop();
            System.out.println("Produto retirado: " + produtoRetirado.getDescricao());
        }
    }

    private static void exibirPilhaProdutos(Stack<Produto> pilhaProdutos) {
        if (pilhaProdutos.isEmpty()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Produtos na pilha:");
            for (int i = pilhaProdutos.size() - 1; i >= 0; i--) {
                Produto produto = pilhaProdutos.get(i);
                System.out.println("- " + produto.getDescricao());
            }
        }
    }    }

