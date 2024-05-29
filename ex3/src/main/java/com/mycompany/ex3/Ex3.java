/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex3;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author mateu
 */
public class Ex3 {

    public static void main(String[] args) {
      
        Stack<String> pilhaLivros = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar livro ");
            System.out.println("2 - Listar todos os livros ");
            System.out.println("3 - Retirar livro");
            System.out.println("0 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarLivro(scanner, pilhaLivros);
                    break;
                case 2:
                    listarLivros(pilhaLivros);
                    break;
                case 3:
                    retirarLivro(pilhaLivros);
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

    private static void adicionarLivro(Scanner scanner, Stack<String> pilhaLivros) {
        System.out.print("Informe o nome do livro: ");
        scanner.nextLine();
        String nomeLivro = scanner.nextLine();
        pilhaLivros.push(nomeLivro);
        System.out.println("Livro adicionado à pilha ");
    }

    private static void listarLivros(Stack<String> pilhaLivros) {
        if (pilhaLivros.isEmpty()) {
            System.out.println("A pilha está vazia.");
        } else {
            System.out.println("Livros na pilha:");
            for (String livro : pilhaLivros) {
                System.out.println("- " + livro);
            }
        }
    }

    private static void retirarLivro(Stack<String> pilhaLivros) {
        if (pilhaLivros.isEmpty()) {
            System.out.println("Não há livros para retirar.");
        } else {
            String livroRemovido = pilhaLivros.pop();
            System.out.println("Livro retirado: " + livroRemovido);
        }
    }
}



