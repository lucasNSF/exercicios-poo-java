package questao01;

import java.util.ArrayList;
import java.util.HashMap;

public class Faculdade {
    private String nome;
    private final HashMap<String, Disciplina> cursos;

    public Faculdade(String nome) {
        this.setNome(nome);
        this.cursos = new HashMap<>();
    }

    public Disciplina getCursoComMaisAlunos() {
        if (this.getCursos() != null) {
            Disciplina cursoAux = new Disciplina("aux", "000");
            cursoAux.setVagas(40);

            for (Disciplina curso : this.getCursos().values()) {
                if (curso.getQtdAlunos() > cursoAux.getQtdAlunos()) {
                    cursoAux = curso;
                }
            }

            return cursoAux;
        } else {
            System.out.println("Não há nenhum curso cadastrado no " + this.getNome() + "!");
            return null;
        }
    }

    public void listarTodosAlunosMatriculados() {
        if (this.getCursos() != null) {
            for (Disciplina curso : this.getCursos().values()) {
                System.out.println(
                        "Curso: " + curso.getNome() + "\n"
                        + "Código: " + curso.getCodigo() + "\n"
                        + "--- Alunos Matriculados ---" + "\n"
                );
                curso.listarAlunos();
            }
        }
    }

    public void listarTodosAlunosMatriculados(Disciplina curso) {
        if (this.getCursos().containsValue(curso)) {
            System.out.println(
                    "Curso: " + curso.getNome() + "\n"
                            + "Código: " + curso.getCodigo() + "\n"
                            + "--- Alunos Matriculados ---" + "\n"
            );
            curso.listarAlunos();
        }
    }

    public void listarDisciplinas() {
        for (Disciplina curso : this.getCursos().values()) {
            System.out.println(curso);
            System.out.println("--- Alunos Matriculados ---");
            curso.listarAlunos();
        }
    }

    public void cadastrarCurso(Disciplina curso) {
        if (this.getCursos().containsValue(curso)) {
            System.out.println(this.getNome() + " já possui esse curso!");
        } else {
            this.getCursos().put(curso.getNome(), curso);
            System.out.println("Curso cadastrado com sucesso!");
        }
    }

    public void removerCurso(Disciplina curso) {
        if (this.getCursos().containsValue(curso)) {
            this.getCursos().remove(curso.getNome());
            System.out.println("Curso removido com sucesso!");
        } else {
            System.out.println(this.getNome() + " não possui este curso!");
        }
    }

    public HashMap<String, Disciplina> getCursos() {
        return this.cursos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
