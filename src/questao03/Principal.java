package questao03;

public class Principal {
    public static void main(String[] args) {
        // Criando a Loja
        Loja mercadinho = new Loja("Mercadinho POO");

        // Criando Produtos
        Chocolate barra1 = new Chocolate("Barra de Chocolate - Diamante Negro", 9.99f, 50);
        Chocolate barra2 = new Chocolate("Barra de Chocolate - Hersheys", 5.99f, 50);
        Chocolate bombons = new Chocolate("Kit Bombons - Cacau Show 50uni.", 24.99f, 25);

        Refrigerante pepsi = new Refrigerante("Refrig. PEPSI 2L", 8.99f, 100);
        Refrigerante coca = new Refrigerante("Refrig. COCA-COLA 2L", 9.99f, 100);
        Refrigerante fanta = new Refrigerante("Refrig. Fanta 2L - Laranja", 9.99f, 100);

        Biscoito wafer = new Biscoito("Bisc. Wafer Bauducco - Chocolate", 1.49f, 200);
        Biscoito oreo = new Biscoito("Bisc. Recheado Oreo - Baunilha", 2.99f, 200);
        Biscoito bono = new Biscoito("Bisc. Recheado Bono - Chocolate", 2.49f, 200);

        // Cadastrando produtos na loja
        mercadinho.cadastrarProduto(barra1);
        mercadinho.cadastrarProduto(barra2);
        mercadinho.cadastrarProduto(bombons);
        mercadinho.cadastrarProduto(pepsi);
        mercadinho.cadastrarProduto(coca);
        mercadinho.cadastrarProduto(fanta);
        mercadinho.cadastrarProduto(wafer);
        mercadinho.cadastrarProduto(oreo);
        mercadinho.cadastrarProduto(bono);

        System.out.println("------------------");

        // Listando produtos
        mercadinho.mostrarProdutosDisponiveis();

        // Comprando produtos
        Float valorTotal = mercadinho.comprarProdutos(
                barra1, barra1,
                barra2, barra2, barra2,
                coca, coca,
                wafer, wafer, wafer, wafer, wafer,
                oreo, oreo, oreo,
                bono, bono, bono, bono, bono,
                bombons
        );

        System.out.println("------------------");
        System.out.println("Valor Total: R$" + valorTotal);
        System.out.println("------------------");

        mercadinho.mostrarProdutosDisponiveis();
    }
}
