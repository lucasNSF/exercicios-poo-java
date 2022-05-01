package questao03;

public class Refrigerante extends Produto {
    public Refrigerante(String nome, Float preco, Integer quantidade) {
        super(nome, preco, quantidade);

        Float desconto = this.getPreco() * 0.1f;
        this.setPreco(this.getPreco() - desconto);
    }
}
