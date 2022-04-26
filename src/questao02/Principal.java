package questao02;

public class Principal {
    public static void main(String[] args) {
        // Criando jogadores
        Jogador lucas = new Jogador("Lucas", 19);
        Jogador joao = new Jogador("João", 18);
        Jogador maria = new Jogador("Maria", 20);
        Jogador ana = new Jogador("Ana", 18);
        Jogador pedro = new Jogador("Pedro", 19);
        Jogador marcos = new Jogador("Marcos", 22);

        // Criando o torneio
        Torneio circuitoTenis = new Torneio("Circuito de Tênis LTII");

        // Cadastrando jogadores
        circuitoTenis.cadastrarJogador(lucas);
        circuitoTenis.cadastrarJogador(joao);
        circuitoTenis.cadastrarJogador(maria);
        circuitoTenis.cadastrarJogador(ana);
        circuitoTenis.cadastrarJogador(pedro);
        circuitoTenis.cadastrarJogador(marcos);

        System.out.println("----------------------");

        // Mostrando status inicial de cada jogador
        circuitoTenis.mostrarPontosDosJogadores();

        System.out.println("----------------------");

        // Iniciando partidas
        circuitoTenis.iniciarPartida(lucas, joao);
        circuitoTenis.iniciarPartida(joao, maria);
        circuitoTenis.iniciarPartida(ana, pedro);
        circuitoTenis.iniciarPartida(marcos, joao);
        circuitoTenis.iniciarPartida(lucas, maria);
        circuitoTenis.iniciarPartida(pedro, joao);

        System.out.println("----------------------");

        // Mostrando pontuação de cada jogador
        circuitoTenis.mostrarPontosDosJogadores();

        System.out.println("----------------------");

        // Mostrando jogador na frente da 1ª fase
        circuitoTenis.mostrarMelhorJogador1Fase();

        System.out.println("----------------------");

        // Indo para Fase 2 do Torneio
        circuitoTenis.subirDeFase();

        // Iniciando partidas da 2ª fase
        circuitoTenis.iniciarPartida(lucas, ana);
        circuitoTenis.iniciarPartida(pedro, maria);
        circuitoTenis.iniciarPartida(joao, marcos);
        circuitoTenis.iniciarPartida(maria, joao);
        circuitoTenis.iniciarPartida(lucas, pedro);
        circuitoTenis.iniciarPartida(marcos, ana);

        System.out.println("----------------------");

        // Mostrando o vencedor do torneio
        circuitoTenis.organizarParticipantes();
        circuitoTenis.obterGanhadorDoTorneio();

        System.out.println("----------------------");

        // Mostrando resultados gerais
        circuitoTenis.mostrarPontosDosJogadores();
    }
}
