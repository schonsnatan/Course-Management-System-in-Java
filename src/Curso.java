import Interface.Avaliavel;

public abstract class Curso implements Avaliavel {
    public int id;
    public String nome;
    public double precoBase;
    public double precoFinal;

    public Curso(int id, String nome, double precoBase){
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public String toString(){
        return("Id:" + getId() + "\n" +
                            "Nome: " + getNome() + "\n" +
                            "Preço: " + getPrecoBase());
    }

    public abstract double CalcularPrecoFinal();
}
