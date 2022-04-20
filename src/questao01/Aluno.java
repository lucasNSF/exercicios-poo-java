package questao01;

import java.util.HashMap;

public class Aluno {
    private String nome;
    private String matricula;
    private final HashMap<String, Disciplina> disciplinas;
    private int semestre;

    public Aluno(String nome, String matricula, int semestre) {
        this.setNome(nome);
        this.setMatricula(matricula);
        this.setSemestre(semestre);
        this.disciplinas = new HashMap<>();
    }

    public void cursarDisciplina(Disciplina materia) {
        if (materia.getVagas() == 0) {
            System.out.println("Não há vagas para esta disciplina!");
        } else if (this.getDisciplinas().containsKey(materia.getNome())) {
            System.out.println("O aluno já está cursando esta disciplina!");
        } else {
            this.getDisciplinas().put(materia.getNome(), materia);
            materia.registrarAluno(this, this.getSemestre());
            materia.setVagas(materia.getVagas() - 1);
            System.out.println(this.getNome() + " agora está cursando " + materia.getNome());
        }
    }

    public void trancarDisciplina(Disciplina materia) {
        if (this.getDisciplinas().containsKey(materia.getNome())) {
            this.getDisciplinas().remove(materia.getNome());
            materia.excluirAluno(this);
            materia.setVagas(materia.getVagas() + 1);
            System.out.println("Disciplina removida com sucesso!");
        } else {
            System.out.println("O aluno não está cursando esta disciplina!");
        }
    }

    public void atualizarSemestre() {
        this.setSemestre(this.getSemestre() + 1);
    }

    public boolean estaMatriculadoEm(Disciplina materia) {
        return this.getDisciplinas().containsValue(materia);
    }

    public boolean estaMatriculadoEm(String materia) {
        return this.getDisciplinas().containsKey(materia);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public HashMap<String, Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n"
                + "Matrícula: " + this.getMatricula() + "\n"
                + "Semestre: " + this.getSemestre() + "\n";
    }
}
