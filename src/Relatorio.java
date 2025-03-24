import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
    public SistemaGestaoCursos ordenarItens(SistemaGestaoCursos gestao) {
        Curso aux;
        for (int i=0; i< gestao.qtdCursos-1; i++){
            for(int j=0; j<gestao.qtdCursos-1; j++){
                if(gestao.cursos[j].precoFinal > gestao.cursos[j+1].precoFinal){
                    aux = gestao.cursos[j];
                    gestao.cursos[j] = gestao.cursos[j+1];
                    gestao.cursos[j+1] = aux;
                }
            }
        }
        return gestao;
    }

    public void salvarItensOrdenados(String file, SistemaGestaoCursos gestao) {
        SistemaGestaoCursos gestao_ordenada = ordenarItens(gestao);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for(int i=0; i<gestao_ordenada.qtdCursos; i++) {
                writer.write(gestao_ordenada.cursos[i].toString());
                writer.newLine();
            }
            System.out.println("\nArquivo '" + file + "' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar itens ordenados: " + e.getMessage());
        }
    }

    public SistemaGestaoCursos ordenarAlunos(SistemaGestaoCursos gestao) {
        Aluno aux;
        for (int i=0; i< gestao.qtdAlunos-1; i++){
            for(int j=0; j<gestao.qtdAlunos-1; j++){
                if(gestao.alunos[j].media > gestao.alunos[j+1].media){
                    aux = gestao.alunos[j];
                    gestao.alunos[j] = gestao.alunos[j+1];
                    gestao.alunos[j+1] = aux;
                }
            }
        }
        return gestao;
    }

    public void salvarItensOrdenadosAlunos(String file, SistemaGestaoCursos gestao) {
        SistemaGestaoCursos gestao_ordenada = ordenarAlunos(gestao);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for(int i=0; i<gestao_ordenada.qtdAlunos; i++) {
                writer.write(gestao_ordenada.alunos[i].toString());
                writer.newLine();
            }
            System.out.println("\nArquivo '" + file + "' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar itens ordenados: " + e.getMessage());
        }
    }


}
