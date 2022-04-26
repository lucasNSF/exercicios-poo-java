package questao02;

public class Jogador {
    private String nome;
    private int idade;
    private int pontos;
    private int partidasJogadas;

    public Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.pontos = 0;
        this.partidasJogadas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }
}
