public class Aluno {
    private int id;
    private String nome;
    private Curso cursoMatriculado;
    private double[][] notas;
    double media;

    public Aluno(int id, String nome, Curso cursoMatriculado, double[][] notas){
        this.id = id;
        this.nome = nome;
        this.cursoMatriculado = cursoMatriculado;
        this.notas = notas;
        this.media = getMediaFinal(notas);
    }

    public double getMediaFinal(double[][] notas){
        return cursoMatriculado.calcularMedia(notas);
    }

    public String toString(){
        return("Nome: " + this.nome + "\n" +
                "Curso: " + this.cursoMatriculado.getNome() + "\n" +
                "Media final: " + String.format("%.2f", this.media) + "\n");
    }
}
