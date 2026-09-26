package Polimorfismo.Forma.Entities;

import Polimorfismo.Forma.Enums.Color;

public class Circulo extends Forma {
    private Double raio;

    public Circulo(Double raio) {
        super();
    }

    public Circulo(Color cor, Double raio) {
        super(cor);
        this.raio = raio;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }

    public Double area(){
        return 3.16 * Math.pow(raio, 2);
    }
}
