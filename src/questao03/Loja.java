package questao03;

import java.util.ArrayList;
import java.util.HashMap;

public class Loja {
    private String nome;
    private final HashMap<String, ArrayList<Produto>> sessoes;

    public Loja(String nome) {
        this.nome = nome;
        this.sessoes = new HashMap<>();
    }

    public Float comprarProdutos(Produto... produtos) {
        Float valorTotal = 0f;

        for (Produto produto : produtos) {
            if (this.estaCadastrado(produto)) {
                boolean tentativaDeVenda = produto.vender();
                if (tentativaDeVenda) {
                    valorTotal += produto.getPreco();
                }
            }
        }

        return valorTotal;
    }

    public Float getPrecoProduto(Produto produto) {
        if (this.estaCadastrado(produto)) {
            return produto.getPreco();
        }
        return null;
    }

    public void mostrarProdutosDisponiveis() {
        this.getSessoes().forEach((sessao, produtos) -> {
            System.out.println("---- Sessão: " + sessao.toLowerCase() + " ----");

            produtos.forEach((produto) -> {
                if (produto.getQuantidade() > 0) {
                    System.out.println(produto);
                }
            });
        });
    }

    public void mostrarProdutosDisponiveis(String sessao) {
        if (this.getSessoes().containsKey(sessao)) {
            this.getSessoes().get(sessao).forEach((produto) -> {
                if (produto.getQuantidade() > 0) {
                    System.out.println(produto);
                }
            });
        }
    }

    public void cadastrarProduto(Produto produto) {
        if (!this.estaCadastrado(produto)) {
            String nomeClasseProduto = produto.getClass().getSimpleName();

            if (this.getSessoes().containsKey(nomeClasseProduto)) {
                ArrayList<Produto> sessao = this.getSessoes().get(nomeClasseProduto);
                sessao.add(produto);
            } else {
                ArrayList<Produto> novaSessao = new ArrayList<>();
                novaSessao.add(produto);
                this.getSessoes().put(nomeClasseProduto, novaSessao);
            }

            System.out.println("Produto cadastrado com sucesso!");
        } else {
            System.out.println("Produto já cadastrado no sistema!");
        }
    }

    public void removerProduto(Produto produto) {
        if (this.estaCadastrado(produto)) {
            String nomeClasseProduto = produto.getClass().getSimpleName();
            ArrayList<Produto> sessao = this.sessoes.get(nomeClasseProduto);
            sessao.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("O produto não está cadastrado!");
        }
    }

    public void removerSessao(String sessao) {
        if (this.getSessoes().containsKey(sessao)) {
            this.getSessoes().remove(sessao);
            System.out.println("Sessão removida com sucesso!");
        } else {
            System.out.println("A sessão não está cadastrada!");
        }
    }

    public boolean estaCadastrado(Produto produto) {
        String nomeClasseProduto = produto.getClass().getSimpleName();

        if (this.getSessoes().containsKey(nomeClasseProduto)) {
            ArrayList<Produto> sessao = this.getSessoes().get(nomeClasseProduto);

            for (Produto p : sessao) {
                if (p.equals(produto)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashMap<String, ArrayList<Produto>> getSessoes() {
        return sessoes;
    }
}
