package questao01;

public class Principal {
    public static void main(String[] args) {
        // Criando Alunos
        Aluno lucas = new Aluno("Lucas Nascimento", "123456", 3);
        Aluno pedro = new Aluno("Pedro", "123123", 2);
        Aluno ana = new Aluno("Ana", "000123", 3);

        // Criando Disciplinas
        Disciplina ads = new Disciplina("Análise e Desenvolvimento de Sistemas", "0001A");
        Disciplina quimica = new Disciplina("Engenharia Química", "0002A");
        Disciplina historia = new Disciplina("História", "0003A");

        // Criando Faculdade
        Faculdade ifba = new Faculdade("Instituto Federal de Educação, Ciência e Tecnologia da Bahia");

        // Cadastrando cursos
        ifba.cadastrarCurso(ads);
        ifba.cadastrarCurso(quimica);
        ifba.cadastrarCurso(historia);

        // Cadastrando alunos nos cursos
        ads.registrarAluno(lucas, 3);
        ads.registrarAluno(pedro, 2);
        ads.registrarAluno(ana, 5);

        historia.registrarAluno(pedro, 4);
        historia.registrarAluno(ana, 1);

        quimica.registrarAluno(lucas, 2);

        // ifba.listarDisciplinas();
        System.out.println(ifba.getCursoComMaisAlunos());
    }
}
