package Polimorfismo.Contribuinte.Entities;

public abstract class Contribuinte {
    private String nome;
    private Double rendaAnual;

    public Contribuinte() {
    }

    public Contribuinte(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setImpostoAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract Double imposto();

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(": $ ");
        sb.append(String.format("%.2f", imposto()));

        return sb.toString();
    }
}
