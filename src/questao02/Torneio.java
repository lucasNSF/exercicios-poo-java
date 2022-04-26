package questao02;

import java.util.ArrayList;
import java.util.Random;

public class Torneio {
    private String nome;
    private final ArrayList<Jogador> participantes;
    private int fase;

    public Torneio(String nome) {
        this.nome = nome;
        this.participantes = new ArrayList<>();
        this.fase = 1;
    }

    public void cadastrarJogador(Jogador jogador) {
        if (this.getParticipantes() == null || !this.getParticipantes().contains(jogador)) {
            this.getParticipantes().add(jogador);
            System.out.println("O jogador " + jogador.getNome() + " está participando do torneio agora!");
        } else {
            System.out.println("Este jogador já está participando do torneio!");
        }
    }

    public void subirDeFase() {
        this.setFase(this.getFase() + 1);
    }

    public Jogador obterGanhadorDoTorneio() {
        if (this.getParticipantes() != null) {
            System.out.println("O Vencedor do torneio foi...");
            System.out.println("Nome: " + this.getParticipantes().get(0).getNome());
            System.out.println("Total de Pontos: " + this.getParticipantes().get(0).getPontos());
            return this.getParticipantes().get(0);
        } else return null;
    }

    public void mostrarMelhorJogador1Fase() {
        if (this.getParticipantes() != null && this.getFase() == 1) {
            System.out.println("O melhor jogador na primeira fase é...");
            System.out.println("Nome: " + this.getParticipantes().get(0).getNome());
            System.out.println("Idade: " + this.getParticipantes().get(0).getIdade());
            System.out.println("Total de Pontos: " + this.getParticipantes().get(0).getPontos());
            System.out.println("Partidas Jogadas: " + this.getParticipantes().get(0).getPartidasJogadas());
        }
    }

    public void mostrarPontosDosJogadores() {
        if (this.getParticipantes() != null) {
            for (Jogador jogador : this.getParticipantes()) {
                System.out.println("Nome: " + jogador.getNome() + " | Total de Pontos: " + jogador.getPontos() + "\n");
            }
        }
    }

    public void iniciarPartida(Jogador player1, Jogador player2) {
        if (this.getParticipantes().contains(player1) && this.getParticipantes().contains(player2)) {
            if (this.validarJogadorApto(player1) && this.validarJogadorApto(player2)) {
                try {
                    Random rand = new Random();
                    int resultado = rand.nextInt(3);
                    Thread.sleep(2000);

                    if (resultado == 1) {
                        System.out.println("O jogador " + player1.getNome() + " ganhou a partida!");
                        this.pontuarJogador(player1);
                    } else if (resultado == 2) {
                        System.out.println("O jogador " + player2.getNome() + " ganhou a partida!");
                        this.pontuarJogador(player2);
                    } else {
                        System.out.println("Partida empatada!");
                    }

                    player1.setPartidasJogadas(player1.getPartidasJogadas() + 1);
                    player2.setPartidasJogadas(player2.getPartidasJogadas() + 1);
                } catch (Exception e) {
                    System.out.println("Erro ao gerar número aleatório");
                }

                if (this.getFase() == 1) {
                    this.organizarParticipantes();
                }
            } else {
                if (this.validarJogadorApto(player1)) {
                    System.out.println("O jogador " + player1.getNome() + " já jogou 6 partidas!");
                } else if (this.validarJogadorApto(player2)) {
                    System.out.println("O jogador " + player2.getNome() + " já jogou 6 partidas!");
                }
            }
        }
    }

    public boolean validarJogadorApto(Jogador jogador) {
        return jogador.getPartidasJogadas() < 6;
    }

    public void organizarParticipantes() {
        if (this.getParticipantes() != null) {
            this.getParticipantes().sort(new ComparadorJogadores());
        }
    }

    private void pontuarJogador(Jogador jogador) {
        if (this.getFase() == 1) {
            jogador.setPontos(jogador.getPontos() + 10);
        } else if (this.getFase() == 2) {
            jogador.setPontos(jogador.getPontos() + 15);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public ArrayList<Jogador> getParticipantes() {
        return participantes;
    }
}
