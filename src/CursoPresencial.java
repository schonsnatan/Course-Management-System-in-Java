import Interface.Avaliavel;

public class CursoPresencial extends Curso implements Avaliavel {

    private String local;
    private int cargaHoraria;

    public CursoPresencial(int id, String nome, double precoBase, String local, int cargaHoraria) {
        super(id, nome, precoBase);
        this.local = local;
        this.cargaHoraria = cargaHoraria;
        this.precoFinal = CalcularPrecoFinal();
    }

    @Override
    public double CalcularPrecoFinal() {
        return this.precoBase + 20*this.cargaHoraria;
    }

    @Override
    public String toString(){
        return("\nId:" + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Preço: " + getPrecoBase() + "\n" +
                "Preço final: " + this.precoFinal + "\n" +
                "Local: " + this.local + "\n" +
                "Carga Horária: " + this.cargaHoraria + "\n");
    }

    @Override
    public double calcularMedia(double[][] notas) {
        double[] media = new double[notas.length];
        for(int i=0; i<notas.length; i++){
            int elementos = 0;
            for(int j=0; j<notas[i].length; j++){
                media[i] += notas[i][j];
                elementos++;
            }
            media[i] /= elementos;

        }

        double max = media[0];
        for(int i=1; i<media.length; i++){
            if(media[i] > max){
                max = media[i];
            }
        }
        return max;
    }
}
