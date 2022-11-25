import java.util.*;
// Projeto CRUD
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Produto produto = new Produto();
        List<Produto> produtos = new ArrayList<>();
        List<Produto> produtosFiltrados = new ArrayList<>();
        List<Produto> produtosComprados = new ArrayList<>();
        while(true) {
            System.out.println("Olá! Digite a opção que você deseja: ");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Editar Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Pesquisa de Produtos");
            System.out.println("5 - Compra de Produtos");
            System.out.println("6 - Sair do programa");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1 -> criarProduto(scan, produtos);
                case 2 -> editarProduto(produtos,scan,produto);
                case 3 -> excluirProduto(produtos,scan);
                case 4 -> pesquisarProduto(scan,produtos,produtosFiltrados);
                case 5 -> comprarProduto(scan,produtos,produtosComprados);
                case 6 ->{ scan.close();
                    System.exit(0);}
                default -> System.out.println("Escolha uma opção válida. ");
        }
        }
    }

    private static void pesquisarProduto(Scanner scan, List<Produto> produtos, List<Produto> produtosFiltrados) {
        System.out.println("Digite o nome ou parte dele: ");
        String resposta = scan.nextLine().toLowerCase();
        produtosFiltrados.clear();
        for (Produto produto: produtos) {
            if (produto.getNome().toLowerCase().contains(resposta)){
                produtosFiltrados.add(produto);
            }
        }
        for (Produto produto: produtosFiltrados) {
            System.out.println(produto.getNome());
        }
    }

    private static void comprarProduto(Scanner scan, List<Produto> produtos, List<Produto> produtosComprados) {

        produtosComprados.clear();
        String resp = "Y";
        while(resp.equalsIgnoreCase("y")) {
            System.out.println("Digite o indice do produto que você deseja: ");
            int id = 1;
            System.out.println("Temos os seguintes produtos em estoque: ");
            for (Produto produto1 : produtos) {
                System.out.println("Indice: " + id + " - Nome " + produto1.getNome() + " - Quantidade: " + produto1.getQuantidade() + " e o valor: R$" + produto1.getPreco());
                id++;
            }
            int indice = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite a quantidade desejada do produto: ");
            int quantidadeProduto = scan.nextInt();
            scan.nextLine();
            int teste = produtos.get(indice-1).getQuantidade();
            if (quantidadeProduto > teste){
                System.out.println("A quantidade digitada não contém no estoque");
                continue;
            }
            else {
                Produto produtoComprado = new Produto();
                produtoComprado.setNome(produtos.get(indice - 1).getNome());
                produtoComprado.setQuantidade(quantidadeProduto);
                int antigaQuantidade = produtos.get(indice-1).getQuantidade();
                produtos.get(indice-1).setQuantidade(antigaQuantidade-quantidadeProduto);
                produtoComprado.setPreco(produtos.get(indice - 1).getPreco());
                produtosComprados.add(produtoComprado);

                System.out.println("Deseja continuar comprando? 'Y' para sim ");
                resp = scan.nextLine();
            }
        }

        System.out.println("Compras: ");
        for (Produto produto2: produtosComprados) {
            System.out.println("Nome: "+produto2.getNome()+" - Quantidade: "+produto2.getQuantidade()+" - Preço:  R$"+produto2.getPreco());
        }
        System.out.println("Valor total: R$ "+somaProdutosComprados(produtosComprados));
    }



    private static double somaProdutosComprados(List<Produto> produtosComprados) {
        double soma = 0;
        for (Produto produto: produtosComprados) {
            soma += produto.getQuantidade()* produto.getPreco();
        }
        return soma;
    }



    private static void criarProduto(Scanner scan, List<Produto> produtos) {

        System.out.println("Digite o nome do Produto: ");
        String nome = scan.nextLine();
        System.out.println("Digite a quantidade do Produto: ");
        String quantidade = scan.nextLine();
        System.out.println("Digite o preco do Produto: ");
        String preco = scan.nextLine();

        Produto produto = new Produto();
        produto.setQuantidade(Integer.parseInt(quantidade));
        produto.setNome(nome);
        produto.setPreco(Double.parseDouble(preco));
        produtos.add(produto);
    }
    private static void editarProduto(List<Produto> produtos, Scanner scan, Produto produto) {
        System.out.println("Você deseja editar qual produto? Se não deseja remover nada digite 0");
        int identificador = 1;
        for (Produto produto1: produtos) {
            System.out.println("Opção "+identificador+" - "+produto1.getNome());
            identificador++;
        }


        int respostaEditar = scan.nextInt();
        scan.nextLine();
        if(respostaEditar == 0){
            System.out.println("Volte pro menu e digite a opção correta.");
        }else {
            System.out.println("Digite o nome do novo Produto: ");
            String nome = scan.nextLine();
            System.out.println("Digite a quantidade do novo Produto: ");
            String quantidade = scan.nextLine();
            System.out.println("Digite o preco do novo Produto: ");
            String preco = scan.nextLine();
            produto.setQuantidade(Integer.parseInt(quantidade));
            produto.setNome(nome);
            produto.setPreco(Double.parseDouble(preco));
            produtos.set(respostaEditar-1,produto);
        }
    }

    private static void excluirProduto(List<Produto> produtos, Scanner scan) {
        System.out.println("Você deseja remover qual produto? Se não deseja remover nada digite 0");
        int id = 1;
        for (Produto produto: produtos) {
            System.out.println("Opção "+id+" - "+produto.getNome());
            id++;
        }
        int respostaRemover = scan.nextInt();
        scan.nextLine();
        if(respostaRemover == 0){
            System.out.println("Volte pro menu e digite a opção correta.");
        }else {
            produtos.remove(respostaRemover - 1);
        }
        System.out.println("Nova lista de Produtos: ");
        for (Produto produto1: produtos) {
            System.out.println(produto1.getNome());
            System.out.println();
        }
    }


}








