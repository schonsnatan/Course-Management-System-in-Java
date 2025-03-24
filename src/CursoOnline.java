import Interface.Avaliavel;

public class CursoOnline extends Curso implements Avaliavel {

    private String plataforma;
    private boolean possuiSuporte;

    public CursoOnline(int id, String nome, double precoBase, String plataforma, boolean possuiSuporte) {
        super(id, nome, precoBase);
        this.plataforma = plataforma;
        this.possuiSuporte = possuiSuporte;
        this.precoFinal = CalcularPrecoFinal();
    }

    @Override
    public double CalcularPrecoFinal() {
        if(possuiSuporte){
            return this.precoBase+100;
        }else{
            return this.precoBase;
        }
    }

    @Override
    public String toString(){
        return ("\nId:" + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Preço: " + getPrecoBase() + "\n" +
                "Preço final: " + this.precoFinal + "\n" +
                "Plataforma: " + plataforma + "\n" +
                "Possui suporte: " + possuiSuporte + "\n");
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
