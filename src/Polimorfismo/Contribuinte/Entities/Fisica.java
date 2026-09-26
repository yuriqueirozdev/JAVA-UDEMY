package Polimorfismo.Contribuinte.Entities;

public class Fisica extends Contribuinte {
    private Double gastoComSaude;

    public Fisica() {
        super();
    }

    public Fisica(String nome, Double impostoAnual, Double gastoComSaude) {
        super(nome, impostoAnual);
        this.gastoComSaude = gastoComSaude;
    }

    public Double getGastoComSaude() {
        return gastoComSaude;
    }

    public void setGastoComSaude(Double gastoComSaude) {
        this.gastoComSaude = gastoComSaude;
    }

    @Override
    public Double imposto(){
        if (getRendaAnual() < 20000){
            return getRendaAnual() * 0.15 - getGastoComSaude() * 0.50;
        }else {
            return getRendaAnual() * 0.25 - getGastoComSaude() * 0.50;
        }
    }
}
