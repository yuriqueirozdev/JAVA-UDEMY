package Polimorfismo.Contribuinte.Entities;

public class Juridica extends Contribuinte{
    private Integer numeroDeFuncionarios;

    public Juridica() {
        super();
    }

    public Juridica(String nome, Double rendaAnual, Integer numeroDeFuncionarios) {
        super(nome, rendaAnual);
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    public Integer getNumeroDeFuncionarios() {
        return numeroDeFuncionarios;
    }

    public void setNumeroDeFuncionarios(Integer numeroDeFuncionarios) {
        this.numeroDeFuncionarios = numeroDeFuncionarios;
    }

    @Override
    public Double imposto(){
        if (numeroDeFuncionarios > 10){
            return getRendaAnual() * 0.14;
        }else {
            return getRendaAnual() * 0.15;
        }
    }
}
