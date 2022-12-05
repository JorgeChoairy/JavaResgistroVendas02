package service;

import model.Produto;
import model.Venda;
import model.Vendedor;

import java.util.InputMismatchException;
import java.util.Scanner;

import static service.RegistroVenda.*;

public class MenuOpcoes {

    public MenuOpcoes() {}

    public static void menu() {
        System.out.println("[>] DIGITE A OPÇÃO DESEJADA [<]");
        System.out.println("[1] - Cadastrar Vendedor.");
        System.out.println("[2] - Registrar Venda.");
        System.out.println("[3] - Exibir Resumo de vendas.");
        System.out.println("[100] - Sair...\n");
    }

    public static void run() {
        Scanner entrada = new Scanner(System.in);
        Venda venda = new Venda();
        Vendedor vendedor = new Vendedor();
        Produto produto = new Produto();

        int numero = 0;
        do {
            menu();
            try {
                numero = entrada.nextInt();

                switch (numero) {
                    case 1:
                        cadastroVendedor(vendedor);
                        break;
                    case 2:
                        registroVenda(vendedor, venda, produto);
                        break;
                    case 3:
                        exibirResumoVenda(venda);
                        break;
                    case 100:
                        System.out.println("Programa Encerrado...");
                        break;
                    default:
                        System.out.println("Digite um número que corresponde as opções do menu...");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERRO] - Verifique o valor inserido e digite corretamente!");
            } catch (NullPointerException e) {
                System.out.println("[ERRO] - Realize o registro corretamente.\n");
            } catch (Exception e) {
                System.out.println("[ERRO] - Informação Incorreta.");
            }

        } while (numero != 100);
    }
}
