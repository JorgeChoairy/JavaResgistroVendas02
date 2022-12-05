package service;

import model.Produto;
import model.Venda;
import model.Vendedor;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class RegistroVenda {

    public RegistroVenda() {
    }

    public static void exibirResumoVenda(Venda venda) {
        venda.imprimeVenda();
    }

    public static void registroVenda(Vendedor vendedor, Venda venda, Produto produto) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        String codigo = "";
        String descricao;
        int qtdItens = 0;
        double desconto = 0;
        double valorVenda = 0;
        double valorCusto = 0;
        boolean promocao = false;
        String simNao = "";

        System.out.println("Informe o Código do Produto: ");
        codigo = scanner.nextLine();
        System.out.println("-----------------------------------------------");

        System.out.println("Informe a Descrição do Produto: ");
        descricao = scanner.nextLine();
        descricao = descricao.toUpperCase();
        System.out.println("-----------------------------------------------");

        System.out.println("Informe o Valor da Venda do Produto(R$): ");
        valorVenda = scanner.nextDouble();
        System.out.println("-----------------------------------------------");

        System.out.println("Informe o Valor de Custo do Produto(R$): ");
        valorCusto = scanner.nextDouble();
        System.out.println("-----------------------------------------------");

        System.out.println("O Produto está em Promoção? [S/N]");
        simNao = scanner.next();

        if (simNao.equalsIgnoreCase("S")) {
            desconto = valorVenda - ((valorVenda * 15) / 100);
            promocao = true;
        } else if (!simNao.equalsIgnoreCase("N")) {
            System.out.println("Informar apenas S ou N");
            throw new InputMismatchException();
        }
        System.out.println("-----------------------------------------------");

        System.out.println("Quantidade de Itens: ");
        qtdItens = scanner.nextInt();
        System.out.println("-----------------------------------------------");

        if (codigo.isEmpty() || descricao.isEmpty() || valorVenda <= 0 || valorCusto <= 0 || qtdItens <= 0) {
            throw new NullPointerException();
        }

        produto.setCodigo(codigo);
        produto.setDescricao(descricao);
        produto.setValorVenda(valorVenda);
        produto.setValorCusto(valorCusto);
        produto.setPromocao(promocao);

        venda.setVendedor(vendedor);
        venda.setProduto(produto);
        venda.setQtdItens(qtdItens);
        venda.setDesconto(desconto);
        venda.setValor(valorVenda);
        venda.calcularValor();
        venda.calcularComissao();
    }

    public static void cadastroVendedor(Vendedor vendedor) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        String nome = "";
        String codigo = "";
        String endereco = "";

        System.out.println("Informe o Nome do Vendedor: ");
        nome = scanner.nextLine();
        nome = nome.toUpperCase();
        System.out.println("-----------------------------------------------");

        System.out.println("Informe o Código do Vendedor: ");
        codigo = scanner.nextLine();
        System.out.println("-----------------------------------------------");

        System.out.println("Informe o Endereço do Vendedor: ");
        endereco = scanner.nextLine();
        endereco = endereco.toUpperCase();
        System.out.println("-----------------------------------------------");

        if (nome.isEmpty() || codigo.isEmpty() || endereco.isEmpty()) {
            throw new NullPointerException();
        }
        
        vendedor.setNome(nome);
        vendedor.setCodigo(codigo);
        vendedor.setEndereco(endereco);
    }
}
