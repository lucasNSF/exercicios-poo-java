package questao02;

import java.util.Comparator;

public class ComparadorJogadores implements Comparator<Jogador> {
    public int compare(Jogador j1, Jogador j2) {
        if (j1.getPontos() == j2.getPontos()) {
            return 0;
        } else if (j1.getPontos() > j2.getPontos()) {
            return -1;
        } else return 1;
    }
}
