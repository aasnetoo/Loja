import java.util.*;

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
                case 1 -> Utils.criarProduto(scan, produtos);
                case 2 -> Utils.editarProduto(produtos,scan,produto);
                case 3 -> Utils.excluirProduto(produtos,scan);
                case 4 -> Utils.pesquisarProduto(scan,produtos,produtosFiltrados);
                case 5 -> Utils.comprarProduto(scan,produto,produtos,produtosComprados);
                case 6 ->{ scan.close();
                    System.exit(0);}
                default -> System.out.println("Escolha uma opção válida. ");
//            Utils.mostrarMenu(scan, produto, produtos, produtosFiltrados, parada);
        }



        }

    }

}








