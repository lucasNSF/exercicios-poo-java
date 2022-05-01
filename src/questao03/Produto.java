package questao03;

public abstract class Produto {
    private String nome;
    private Float preco;
    private Integer quantidade;
    private int qtdVendida;

    public Produto(String nome, Float preco, Integer quantidade) {
        this.nome = nome;
        setPreco(preco);
        setQuantidade(quantidade);
        this.qtdVendida = 0;
    }

    public boolean vender() {
        if (this.getQuantidade() > 0) {
            this.setQuantidade(this.getQuantidade() - 1);
            this.qtdVendida++;
            System.out.println("Produto vendido!");
            return true;
        } else {
            System.out.println("O produto " + this.getNome() + " está fora do estoque!");
            return false;
        }
    }

    public float getLucro() {
        return this.getPreco() * this.getQtdVendida();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = (preco > 0) ? preco : null;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = (quantidade > 0) ? quantidade : null;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + '\n' +
                "Preço: " + preco + '\n' +
                "Qtd. Disponível: " + quantidade +
                '\n';
    }
}
