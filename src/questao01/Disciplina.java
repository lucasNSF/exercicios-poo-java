package questao01;

import java.util.HashMap;

public class Disciplina {
    private String nome;
    private String codigo;
    private int vagas;
    private final HashMap<Aluno, Integer> semestreEntrada;

    public Disciplina(String nome, String codigo) {
        this.setNome(nome);
        this.setCodigo(codigo);
        this.setVagas(40);
        this.semestreEntrada = new HashMap<>();
    }

    public int getQtdAlunos() {
        return this.getVagas();
    }

    public void registrarAluno(Aluno aluno, Integer semestre) {
        this.getSemestreEntrada().put(aluno, semestre);
    }

    public void excluirAluno(Aluno aluno) {
        this.getSemestreEntrada().remove(aluno);
    }

    public void listarAlunos() {
        this.getSemestreEntrada().forEach((aluno, semestre) -> {
            System.out.print(aluno);
            System.out.println("Semestre de Entrada: " + semestre);
        });
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public HashMap<Aluno, Integer> getSemestreEntrada() {
        return semestreEntrada;
    }

    @Override
    public String toString() {
        return "Nome = " + this.getNome() + "\n"
                + "Código = " + this.getCodigo() + "\n"
                + "Vagas = " + this.getQtdAlunos() + "\n";
    }
}
