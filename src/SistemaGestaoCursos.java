import Exceptions.AlunoNaoEncontradoException;
import Exceptions.CursoNaoEncontradoException;
import Exceptions.ImpossivelAdicionarAlunoException;
import Exceptions.ImpossivelAdicionarCursoException;

import java.io.*;

public class SistemaGestaoCursos {
    public Curso[] cursos = new Curso[50];
    public Aluno[] alunos = new Aluno[200];
    public int qtdCursos = 0;
    public int qtdAlunos = 0;

    public void carregarCursos(String arquivo){
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))){

            String line;

            while((line = reader.readLine()) != null){
                String[] elementos = line.split("\\|");
                int id = Integer.parseInt(elementos[0].trim());
                String tipo_curso = elementos[1].trim();
                String nome = elementos[2].trim();
                double preco = Double.parseDouble(elementos[3].trim());

                if(tipo_curso.equals("ONLINE")){
                    String plataforma = elementos[4].trim();
                    boolean possui_suporte = Boolean.parseBoolean(elementos[5].trim());
                    CursoOnline novo_curso_online = new CursoOnline(id,nome,preco,plataforma,possui_suporte);
                    adicionarCursos(novo_curso_online);

                }else if(tipo_curso.equals("PRESENCIAL")){
                    String local = elementos[4].trim();
                    int carga_horaria = Integer.parseInt(elementos[5].trim());
                    CursoPresencial novo_curso_presencial = new CursoPresencial(id,nome,preco,local,carga_horaria);
                    adicionarCursos(novo_curso_presencial);
                }
            }
        } catch (IOException | ImpossivelAdicionarCursoException e){
            System.out.println("ERRO: arquivo inexistente ou formato inválido");
        }
    }

    public void carregarAlunos(String arquivo){
        try(BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String elementos[] = line.split("\\|");
                int id_aluno = Integer.parseInt(elementos[0].trim());
                String nome_aluno = elementos[1].trim();
                int id_curso = Integer.parseInt(elementos[2].trim());
                String s_notas[] = elementos[3].split(";");
                double notas_final[][] = new double[2][3];

                for(int i=0; i<s_notas.length; i++){
                    String notas[] = s_notas[i].split(",");
                    for(int j=0; j<notas.length; j++){
                        notas_final[i][j] = Double.parseDouble(notas[j]);
                    }
                }

                Aluno novo_aluno = new Aluno(id_aluno,nome_aluno,getCursoById(id_curso),notas_final);
                adicionarAluno(novo_aluno);

            }
        } catch(IOException | ImpossivelAdicionarAlunoException | CursoNaoEncontradoException e){
            System.out.println("Arquivo inválido");
        }
    }

    public void adicionarCursos(Curso curso) throws ImpossivelAdicionarCursoException{
        if (qtdCursos >= cursos.length) {
            throw new ImpossivelAdicionarCursoException("Não é possível adicionar mais cursos.");
        }
        cursos[qtdCursos] = curso;
        qtdCursos++;
    }

    public void adicionarAluno(Aluno aluno) throws ImpossivelAdicionarAlunoException {
        if (qtdAlunos >= alunos.length) {
            throw new ImpossivelAdicionarAlunoException("Não é possível adicionar mais alunos.");
        }
        alunos[qtdAlunos] = aluno;
        qtdAlunos++;
    }

    public void removerCurso(int id_curso){

    }

    public void removerAluno(int id_aluno){

    }

    public void gerarRelatorioCursos(String arquivo_saida){

    }

    public void gerarRelatorioAlunos(String arquivo_saida){

    }

    public Curso getCursoById(int id) throws CursoNaoEncontradoException {
        return cursos[id-1];
    }

    public Aluno getAlunobyId(int id) throws AlunoNaoEncontradoException {
        return alunos[id-1];
    }

    public void listarAlunosComMediaAbaixo(double notaCorte){
        System.out.println("\nAlunos com nota abaixo da nota de corte:\n");
        for(int i=0; i<qtdAlunos; i++){
            if(alunos[i].media < notaCorte){
                System.out.println(alunos[i].toString());
            }
        }
    }
}
