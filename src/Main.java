//

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Produto produto = new Produto();
        List<Produto> produtos = new ArrayList<>();
        List<Produto> produtosFiltrados = new ArrayList<>();
        boolean continuar = true;
        while(continuar) {
            Utils.mostrarMenu(scan, produto, produtos, produtosFiltrados);
        }

    }


}








